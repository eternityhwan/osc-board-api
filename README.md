Spring boot RestApi 

OSC KOREA 개인 프로젝트

1. Spring boot : RestAPI - json 방식으로 데이터 전송
2. DataBase : AWS Ec2에 Docker-Compose, 3306포트로 기동
3. FrontEnd : React.js 라이브러리로 제작
4. CROS 문제 : Controller 클래스에 @CrossOrigin(origins = "*") 붙여 해결

webhook test

API 명세서

1. /hello
 - method : 'GET'
 - Description : Hello World 문자열 출력

2. /api/boards
 - method : 'GET'
 - Description : DB 모든 테이블 조회

3. /api/boards/{id}
 - method : 'GET'
 - Description : id 찾기

4. /api/boards/posts
 - method : 'post'
 - Description : 글 추가 기능

5. /api/boardsR/{id}
 - method : 'put'
 - Description : 글 수정 기능

6. /api/boardsD/{id}
 - method : 'delete'
 - Description : 글 삭제 기능

--- k8s secret ---
# make secret
kubectl -n db create secret generic mysql \
--from-literal=root.password="3642" \
--from-literal=user.name="hwan" \
--from-literal=user.password="3642"
