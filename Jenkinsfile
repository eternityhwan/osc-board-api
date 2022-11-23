pipeline {
    agent any

    environment {
        // Mtag = "{jtag}"
        gitTags = "sh(returnStdout: true, script: 'gitt describe --tags --abbrev=0').trim()"
        // latestHash = "sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()"
        // latestTagHash = "sh(returnStdout: true, script: 'git rev-list 0n 1 ${gitTags}').trim()"
    }

    stages {
        stage ('github clone') {
            steps {
                git branch: '${BRANCH}',
                credentialsId: 'hwan-git-credential',
                url: 'https://github.com/eternityhwan/osc-board-api.git'
                sh 'cat Dockerfile'
                sh 'ls'
                sh 'pwd'
            }
        }

        stage ('Gradle build jar file') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew --version'
                sh 'echo "start gradle build"'
                sh 'echo "{$Cashe}"'

            script {
                if ( params.Cashe == true ) {
            sh './gradlew clean build --debug --exclude-task test'
     }  else {
            sh './gradlew clean build --debug --exclude-task test'
            }
        }
            sh 'pwd'
            // sh 'ls -al ./target'
        }
    }

        stage ('Docker build & PUSH Phase') {
            // when { environment name: 'Mtag', value: "${jtag}" }
            steps {
                // sh 'sudo systemctl status docker.service'
                sh 'sudo chmod 666 /var/run/docker.sock'
                sh 'docker build -t mirrorkyh/osc-board-api:${Mtag} .'
                sh 'echo "docker.io login & image push"'
            script {
                withCredentials([usernamePassword(
                credentialsId: 'dockerIOhwan',
                passwordVariable: 'hwanPass',
                usernameVariable: 'hwanId')]) {
                sh 'docker login -u ${hwanId} -p ${hwanPass}'
                }
        }
        sh 'echo "docker.io pushing work"'
        sh 'sudo docker push mirrorkyh/osc-board-api:${Mtag}'
        }
    }

     // cd 단계

             stage ('CD Stage clone api-app') {
                    steps {
                        git branch: '${BRANCH}',
                        credentialsId: 'hwan-git-credential',
                        url: 'https://github.com/eternityhwan/osc-board-api.git'
                    }
               }

             stage ('CD Stage change tag') {
                     steps {
                            sh 'git checkout ${BRANCH}'
                            dir('k8s') {
                             sh 'pwd'
                             sh '''
                              echo "sed command"
                              chmod 777 osc-board-api.yaml
                              CURRENTTAG=$(grep 'image:' osc-board-api.yaml | awk -F":" '{print $3}')
                              REPLACETAG="$Mtag"
                              sed -i "s|$CURRENTTAG|$REPLACETAG|g" osc-board-api.yaml
                              '''
                               sh 'cat osc-board-api.yaml'

                            }
                            sh 'pwd'
                     }
             }

            stage ('git push') {
                  steps {
                      script {
                 withCredentials([usernamePassword(
                    credentialsId: 'hwan-github-token',
                    passwordVariable: 'hwanGitPass',
                    usernameVariable: 'hwanGitId')]) {
                        // sh 'git config --global --unset http.proxy'
                        // sh 'git config --global --unset https.proxy'
                        sh 'git config --global user.name "mirrorkyh"'
                        sh 'git config --global user.email "mirrorkyh@gmail.com"'
                        sh 'ls -al'
                        sh 'git add .'
                        sh 'git commit -m "change deployment tag"'
                        // sh 'git remote rm origin'
                        // sh 'git remote add origin https://github.com/eternityhwan/osc-board-api.git'
                        // sh 'git push https://${hwanGitId}:${hwanGitPass}@github.com/eternityhwan/osc-board-api.git'
                        sh 'git push https://${hwanGitId}:${hwanGitPass}@github.com/eternityhwan/osc-board-api.git'
                        }
                    }
                }
            }
        }
    }
