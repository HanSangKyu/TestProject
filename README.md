* 무신사 프로젝트

1. 개발 환경

  a.IDE: Android Studio 최신버전
 
  b.Android Studio Koala Feature Drop | 2024.1.2
 
  c.minSdk = 29

  d.targetSdk = 34

  e.빌드 시스템: Gradle 8.6.0

  f.JDK : Java 17을 실행할 수 있는 JDK
  
  g.사용 언어: Kotlin [1.9.0]

2.Architecture
  
  a.앱 아키텍처 가이드  (https://developer.android.com/topic/architecture?hl=ko)

  b.아키텍쳐 : ViewModel 개요  (https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ko)

  c.비동기 처리 : Android의 Kotlin 코루틴 (https://developer.android.com/kotlin/coroutines?hl=ko)  |  Android Developers Android에서의 Kotlin 흐름 (https://developer.android.com/kotlin/flow?hl=ko)

  d.이미지 처리 : Glide (https://github.com/bumptech/glide)

  e.DI : Hilt를 사용한 종속 항목 삽입    Android Developers (https://developer.android.com/training/dependency-injection/hilt-android?hl=ko)

  f.Network : Retrofit (https://github.com/square/retrofit)

  g.UI Layer : 상태는 아래로 이동하고 이벤트는 위로 이동하는 단방향 데이터 흐름(UDF)으로 구성되어 있습니다.

3. 모듈 구조 

* app 

* core

  * data 

  * data-api 

  * designsystem 

  * domain

  * model

* fearue - 

