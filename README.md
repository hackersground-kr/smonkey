# `배그` - `Smonkey (스몽키)`

해커그라운드 해커톤에 참여하는 `배그` 팀의 `Smonkey (스몽키)`입니다.

## 참고 문서

> 아래 두 링크는 해커톤에서 앱을 개발하면서 참고할 만한 문서들입니다. 이 문서들에서 언급한 서비스 이외에도 더 많은 서비스들이 PaaS, SaaS, 서버리스 형태로 제공되니 참고하세요.

- [순한맛](./REFERENCES_BASIC.md)
- [매운맛](./REFERENCES_ADVANCED.md)

## 제품/서비스 소개

<!-- 아래 링크는 지우지 마세요 -->
[제품/서비스 소개 보기](TOPIC.md)
<!-- 위 링크는 지우지 마세요 -->

## 오픈 소스 라이센스

<!-- 아래 링크는 지우지 마세요 -->
[오픈소스 라이센스 보기](./LICENSE)
<!-- 위 링크는 지우지 마세요 -->

## 설치 방법
### 서버
#### 기본 준비 사항
- GitHub account
- Microsoft Azure Free account
- Microsoft Azure Web
- Azure CLI
- Github CLI
- MySQL

##### Azure CLI 설치 방법
mac os - https://learn.microsoft.com/ko-kr/cli/azure/install-azure-cli-macos   
window - https://learn.microsoft.com/ko-kr/cli/azure/install-azure-cli-windows?tabs=azure-cli

##### Github CLI 설치 방법
mac os
```
$ brew install gh
```

window
```
$ scoop bucket add github-gh https://github.com/cli/scoop-gh.git
$ scoop install gh
```

##### MySQL 설치 방법
mac os
```
$ brew install mysql
```
window
```
https://dev.mysql.com/downloads/windows/installer/8.0.html
```

#### 순서

1. 자신의 깃허브 계정으로 이 레포지토리를 포크합니다.
2. 아래 순서대로 Microsoft Azure 리소스를 생성합니다.
```
az login

# App Service 리소스 생성
az webapp create --name smonkey-backend --resource-group <resources 그룹 이름>  --plan ASP-rghgsmonkey-8bac --runtime JAVA:17-java17

# MySQL 리소스 생성
az mysql server create --name smonkey-db --resource-group <resources 그룹 이름> --location KoreaCentral --admin-user smonkey --admin-password "qpwoeirutyalzm12*" --sku-name GP_Gen5_2  --version 8.0

# Redis 리소스 생성
az redis create --name smonkey-redis --resource-group <resources 그룹 이름> --location KoreaCentral --sku "Premium" --vm-size P5 --minimum-tls-version 1.2 --redis-version 6.0


```

3. 마이크로소프트 애저 클라우드 홈페이지에 접속하여 각종 정보를 찾습니다.
   - App Services에서 위에서 생성한 smonkey-backend라는 이름으로 생성된 App Services에 들어가서 왼쪽 메뉴바에 '배포 센터' 라는 메뉴를 클릭합니다.
   - 코드 소스를 Github로 선택하고 깃허브 조직, 리포지토리, 분기를 각각 포크 받은 리포지토리와 동일하게 선택합니다.
   - 워크플로는 추가 옵션을 클릭한 후 위에 저장을 클릭합니다.
   - 이후 포크받은 깃허브 레포지토리에 들어가 .github/workflows 폴더 아래에 추가된 main_smonkey-backend.yml에 deploy: 전의 내용을 다음과 같이 수정합니다.
   ```
   name: Smonkey CI/CD

   on:
      push:
        branches:
          - main
      workflow_dispatch:

   jobs:
      build:
        runs-on: ubuntu-latest

        steps:
          - uses: actions/checkout@v2

          - name: Set up Java version
            uses: actions/setup-java@v1
            with:
              java-version: '17'

          - name: make application.yml
            run: |
                mkdir ./backend/src/main/resources
                cd ./backend/src/main/resources
                touch ./application.yml
                echo "${{ secrets.APPLICATION }}" > ./application.yml
            shell: bash

          - name: Build with Gradle
            run: |
                cd ./backend
                chmod +x ./gradlew
                ./gradlew clean build

          - name: Upload artifact for deployment job
            uses: actions/upload-artifact@v2
            with:
              name: java-app
              path: '${{ github.workspace }}/backend/build/libs/SMonkey-0.0.1.jar'
   ```
   - 다시 마이크로소프트 애저 클라우드 홈페이지로 접속하여 MySQL에서 smonkey-db라는 이름으로 생성된 데이터베이스를 선택하고 데이터베이스의 서버 이름과 서버 관리자 로그인 이름을 복사합니다.
   - 복사한 서버 이름과 서버 관리자 로그인 이름을 다음 application.yml에 넣기 위해 가지고 있습니다.
   - MySQL 왼쪽 메뉴바에 네트워킹으로 들어가 젤 아래의 방화벽 규칙을 확인합니다.
     <img width="299" alt="image" src="https://github.com/hackersground-kr/smonkey/assets/81136764/5a1e97bf-84c9-4d2e-8ca7-0b8a65c0f1b4">
   - 위의 사진과 같은 주소가 존재하지 않다면 [+ 0.0.0.0 - 255.255.255.255 추가] 를 클릭합니다.
   - 이후 위부분의 저장 버튼을 클릭합니다.
   - 다시 마이크로소프트 애저 클라우드 홈페이지로 접속하여 Azure Cache for Redis에 smonkey-redis라는 이름으로 생성된 Redis를 선택하고 호스트 이름을 복사합니다.
   - Redis 화면에서 포트 항목을 누르고 고급 설정에서 SSL을 통해서만 액세스 허용을 아니요로 변경한 후 비 SSL 포트를 6379로 설정하고 저장합니다.
   - 복사한 호스트 이름을 다음 application.yml에 넣기 위해 가지고 있습니다.
   - Redis 화면 왼쪽 메뉴바에 액세스 키 메뉴를 선택합니다.
   - 메뉴에 기본 액세스 키를 복사하여 application.yml에 넣기 위해 가지고 있습니다.

4. 위에서 저장한 데이터들을 application.yml에 저장하고 Github Action Secret에 APPLICATION 이라는 키로 아래의 내용을 값으로 저장하기
   - 깃허브 레포지토리의 Settings에 들어갑니다.
   ![image](https://github.com/hackersground-kr/smonkey/assets/81136764/87fb644f-8815-4e38-9423-035ff2707732)
   - 왼쪽 메뉴바에 Secrets and variables -> Actions에 들어갑니다
   - 오른쪽에 초록색 New repository secret을 클릭합니다.
   - Name의 값에는 APPLICATION 을 입력하고 Secret에 아래에서 만든 application.yml을 복사해서 붙여넣습니다.

```
spring:
    datasource:
        url: jdbc:mysql://<위에서 생성한 MySQL 서버 이름>:3306/smonkey?characterEncoding=UTF-8&serverTimezone=Asia/Seoul
        username: <서버 관리자 로그인 이름>
        password: qpwoeirutyalzm12*
        driver-class-name: com.mysql.cj.jdbc.Driver
    mvc:
        pathmatch:
            matching-strategy: ant_path_matcher

    redis:
        host: <위에서 생성한 Redis 호스트 이름>
        port: 6379
        password: <위에서 복사한 Redis 액세스 키>

    cache:
        type: redis

    jpa:
        hibernate:
            ddl-auto: update
        properties:
            hibernate:
                format_sql: false
                show_sql: false
        open-in-view: false

    jackson:
        property-naming-strategy: SNAKE_CASE

jwt:
    secretKey: dskfjalsjfio329390i9r03infjnjdshf!djfoksjodfi3ibobsdfiohsiodjcknklebio
    accessTokenExp: 1800
    refreshTokenExp: 7200
```

5. Github CLI를 통해 Github Action을 실행시켜 배포를 시작합니다.
```
gh auth login

gh workflow run "Smonkey CI/CD" --repo <포크한 사람의 Github ID>/<포크한 리포지토리 이름>
```

6. 데이터베이스 생성하기
   - 위에서 생성한 MySQL의 서버 이름과 서버 관리자 로그인 이름을 가지고 옵니다.
   - 밑의 명령어를 터미널에서 차례대로 입력해줍니다.
   - 윈도우라면 cmd 창에서 진행하고 맥이라면 terminal에서 진행해주세요.
     ```
     터미널 입력화면
     mysql -u <MySQL 서버 관리자 로그인 이름> -p -h <MySQL 서버 이름>
     Enter password: qpwoeirutyalzm12*

     -----------------------------------------
     MySQL 입력화면
     use smonkey;
     create database smonkey;
     exit
     ```

7. 마이크로소프트 애저 클라우드 홈페이지에 접속하여 App Services에 smonkey-backend를 클릭하여 기본 도메인을 복사합니다.
   - 안드로이드 어플과 연결하기 위해 사용할 서버 주소입니다.

## Android - 시작하기
[Android 시작하기 문서](https://github.com/hackersground-kr/smonkey/blob/main/Start_Android.md)
