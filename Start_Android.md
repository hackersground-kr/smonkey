### 사전 준비사항

**Account**

- [Github](https://github.com/) Account
- [App Center](https://appcenter.ms/) Account
- Github CLI

**URL**

- Server Base URL
    - **서버 배포 후 안내에 따라 마지막에 복사한 주소**

---

### Github Repository Fork

- Fork 후 android 폴더에 진입합니다.

### App Center에서 App 만들기

- [App Centers](https://appcenter.ms/apps)에 접속하여 사전에 준비한 Azure Free Account를 통해 로그인합니다.
- Add new app을 클릭합니다.
- `App name`과, `Release Type` 을 목적에 맞게 설정합니다.
- OS를 `Android`로 설정하고 Platform을 `Java/Kotlin`으로 설정합니다.

![1](https://github.com/hackersground-kr/smonkey/assets/137253565/3a3e771d-6179-4681-a194-d12eb85ac479)

- 만든 App에 접속합니다.

<img width="636" alt="스크린샷 2023-06-23 오전 2 57 04" src="https://github.com/hackersground-kr/smonkey/assets/80076029/dd5241eb-ba12-4279-b698-e29010673bfe">

- 추후에 활용하기 위해 화면(URL)에 보이는 정보 `이름`, `프로젝트 이름`을 **기억**합니다.

### App Center에서 Token 구해오기

- [AppCenters](https://appcenter.ms/apps)에 접속하여 로그인 후 우측 상단 프로필을 클릭합니다.
- `Account Settings`를 클릭합니다.
- `User API tokens` 옆에 팬 모양 아이콘을 클릭합니다.
- New API Token을 클릭합니다.
    - Description에 해당 `토큰의 설명을 입력`합니다.
    - Access에 `Full Access`를 선택합니다.
    - `Add new API token`을 눌러 토큰을 발급합니다.
    - `해당 토큰`은 추후에 활용하기 위해 `기억`합니다.

### App Center에서 App의 테스트 그룹을 설정하기

- 앱을 배포 대상을 정의하기 위해 배포 그룹(배포 대상)을 정의해야 합니다.
- [AppCenters](https://appcenter.ms/apps)에 접속하여 App에 접근합니다.
- 좌측 메뉴의 `Distribute → Groups`로 접근합니다.
- 새로운 테스트 그룹을 기존의 그룹(Collaborators)를 이용할 수 있습니다.
- 추후 배포할 `테스트 그룹의 이름`이 필요하므로 `기억` 합니다.

### Github Secret 설정하기

- fork한 repository의 Settings 를 진입합니다.
- 좌측의 Security옵션 중 Secrets and variables의 Actions에 진입합니다.
- `New repository secret`를 눌러 다음 정보를 입력합니다.
    - **APP_CENTER_TOKEN**
        - App Center Token을 넣습니다.
    - **BASE_URL**
        - 서버의 URL을 넣습니다.

### workflow에 진입해서 사용자 정보 설정하기

- fork한 repository에서 `.github / workflows / deploy.yml` 로 이동합니다.

<img width="970" alt="스크린샷 2023-06-23 오전 3 04 15" src="https://github.com/hackersground-kr/smonkey/assets/80076029/ca447fe4-18b6-4cc3-ac20-3e913a32de0b">

- 사진의 설명에 따라 1번칸에 `App Center에서 App 만들기`에서 구한 `이름/프로젝트 이름` 을 순서대로 적습니다.
- 사진의 설명에 따라 2번칸에 App centor에서 `배포할 그룹의 이름`을 적습니다. (기본값: Collaborators)
- 변경사항을 반영하기위해 커밋 후 push합니다.

### Github CLI를 통해 Github Action을 실행시켜 배포를 시작합니다.

```
gh auth login
gh workflow run "Build and Deploy to App Center" --repo <포크한 사람의 Github ID>/<포크한 리포지토리 이름>
```

- **Github CLI가 원활하지 않다면 main branch에 push할 경우 자동으로 배포가 시작됩니다.**

### 배포 완료 후 App Centors에서 확인 후 링크 공유

- App Centers에서 App에 접속합니다.
- 자동 배포를 완료한 후 Latest release아래 **see all releases를** 눌러 배포 현황을 확인합니다.
- 원하는 배포 history를 선택합니다.

<img width="1476" alt="4" src="https://github.com/hackersground-kr/smonkey/assets/137253565/7da7bb5a-b728-4e8e-847b-6ab36b0271c2">

- 사진의 설명에 따라 파린색 Download 버튼을 누르면 apk 다운로드가 시작됩니다.
- 다른 기기로의 접속을 원하실 경우 QR또는 링크를 활용하실 수 있습니다.

<img width="455" alt="5" src="https://github.com/hackersground-kr/smonkey/assets/137253565/ff0c2e0d-6688-477a-bd5c-50fc718b3772">
