<div align="center">

  <h1>Ekar App</h1>
  
  <p>
    Ekar App which shows the vehicle detail by picking the vehicle from map and on board it.
  </p>

<b>This project is built on `100%` Compose UI and kotlin.</b>
  
<!-- Badges -->
![kotlin](https://img.shields.io/badge/Kotlin-1.7.10-white.svg?style=for-the-badge&labelColor=7E57C2)
![compose](https://img.shields.io/badge/Compose-1.3.1-white.svg?style=for-the-badge&labelColor=5C6BC0)
![Hilt](https://img.shields.io/badge/Hilt-2.42-white.svg?style=for-the-badge&labelColor=42A5F5)
![Coroutines](https://img.shields.io/badge/Coroutines-1.6.0-white.svg?style=for-the-badge&labelColor=26C6DA)
![minSdkVersion](https://img.shields.io/badge/MinSdkVersion-21-white.svg?style=for-the-badge&labelColor=26A69A)
![targetSdkVersion](https://img.shields.io/badge/TargetSdkVersion-33-white.svg?style=for-the-badge&labelColor=66BB6A)
![MVI](https://img.shields.io/badge/CleanCode-MVI-white.svg?style=for-the-badge&labelColor=FFCA28)
   
</div>

<br />

<!-- Table of Contents -->
# Table of Contents

- [Screenshots](#screenshots)
- [Download Apk](#download-apk)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Architecture](#architecture)
- [Architecture Diagram](#architecture-diagram)
- [Project Tree](#project-tree)
- [Test Cases](#test-cases)


<!-- About the Project -->
## About the Project


<!-- Screenshots -->
### Screenshots

[<img src="https://drive.google.com/uc?export=view&id=11roj9Ar-sx1YakQrv4zGnVtZmfT-H9VV" align="left"
width="200"
hspace="10" vspace="10">](https://drive.google.com/uc?export=view&id=11roj9Ar-sx1YakQrv4zGnVtZmfT-H9VV)
[<img src="https://drive.google.com/uc?export=view&id=12a6QhJtpVE9kIutXvoFseCIVXF5skqBN" align="center"
width="200"
hspace="10" vspace="10">](https://drive.google.com/uc?export=view&id=12a6QhJtpVE9kIutXvoFseCIVXF5skqBN)
[<img src="https://drive.google.com/uc?export=view&id=1k5YRI2dyNYgthtYaDY9tVQxhRmBVjeUr" align="center"
width="200"
hspace="10" vspace="10">](https://drive.google.com/uc?export=view&id=1k5YRI2dyNYgthtYaDY9tVQxhRmBVjeUr)


<!-- download-apk -->
### Download Apk

Here is the link to download the apk 
<a href="https://drive.google.com/file/d/1idl6tduAWQm_CEFogXHB1-S0yblwJNh6/view?usp=share_link">Ekar App</a> 


<!-- TechStack -->
### Tech Stack
    
* [Kotlin](https://kotlinlang.org/docs/home.html)
* [Compose](https://developer.android.com/jetpack/compose/documentation)
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Room](https://developer.android.com/training/data-storage/room)
* [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/MutableState)
* [Moshi](https://github.com/square/moshi)
* [Coroutines](https://developer.android.com/kotlin/coroutines) 
* [Retrofit](https://square.github.io/retrofit/) 
* [Mockk](https://mockk.io/)
* [Truth](https://truth.dev/)

Mutable state is used in this project instead of Flows.


### Installation

**Download:**

    $ git clone https://github.com/SyedAmmarSohail/EkarApp.git

Import Project by Android Studio Menu > File > Import Project.

**Release:**

This app is production ready, only need to add your keystore path, password and alias in build.gradle file located under the app folder.

To view the map add your Google map api key in local.properties like
```text 
GOOGLE_MAPS_API_KEY= **YOUR_GOOGLE_MAP_API_KEY**
```

<!-- Architecture -->
### Architecture

**AppModule:**

Used layer-based clean architecture in which include data, domain and presentation layer.

- **Data layer -** Manages application data eg. retrieve data from the network

- **Domain layer -** Contains business logic with separate usecases

- **Presentation layer -** Presents data to a screen and handle user interactions

**BuildSrc:**

Puts every dependencies in one place with respect to its classes, and use it by calling the dependency with its class.


<!-- Architecture Diagram -->
### Architecture Diagram

<div align="center"> 
  <img src="https://drive.google.com/uc?export=view&id=1fpthmNYZkuKFbFGxtUNDJjLuekQX_Tjd" alt="screenshot" />
</div>

  
<!-- Project tree -->
### Project tree

```text
.
├── EkarApp
├── app
    ├── ekar
        ├── data
            ├── di
                ├── EkarDataModule
            ├── intercepter
                ├── QueryInterceptor
            ├── mapper
                ├── EkarMapper.kt    
            ├── remote
                ├── dto
                    ├── VehicleDetail
                ├── EkarApi
            ├── repository
                ├── EkarRepositoryImp
        ├── domain
            ├── model
                ├── VehicleModel
            ├── repository
                ├── EkarRepository
            ├── usecase
                ├── VehicleDetailUsecase
        ├── presentation
            ├── component
                ├── ActionAppBar.kt
                ├── ComposeButton.kt
                ├── ComposeEditText.kt
                ├── ComposeHorizontalList.kt
                ├── ComposeTextWithBackground.kt
                ├── RichText.kt
            ├── map
                ├── MapScreen.kt
            ├── navigation
                ├── Route    
            ├── onboard
                ├── OnBoardScreen.kt
            ├── theme
                ├── Color.kt
                ├── Dimensions.kt
                ├── FontSize.kt
                ├── Shape.kt
                ├── Theme.kt
                ├── Type.kt
            ├── vehicle_detail
                ├── VehicleDetailScreen.kt    
            ├── EkarEvent.kt
            ├── EkarUiState
            ├── EkarViewModel
        ├── utils
            ├── NetworkUtil.kt
            ├── NetworkFormat.kt
            ├── Result.kt
            ├── UiEvent
            ├── UiText
            ├── CommonExt
        ├── EkarApp
        ├── MainActivity
├── buildSrc
    ├── AndroidX
    ├── Build
    ├── Compose
    ├── Coroutines
    ├── DaggerHilt
    ├── Google
    ├── Kotlin
    ├── Moshi
    ├── ProjectConfig
    ├── Retrofit
    ├── Testing
└── .gitignore

```  


### Test Cases

**Unit Test:**

- **Repository Test -** To run the unit tests for repository go to the **EkarRepositoryImpTest** class under the **test/data** folder and run the tests.
- **ViewModel Test -** To run the unit tests for viewModel go to the **EkarViewModelTest** class under the **test/presentation** folder and run the tests.
- **UseCase Test -** To run the unit tests for use cases go to the **VehicleDetailUsecaseTest** class under the **test/domain** folder and run the tests.

<!-- Contact -->
## Contact

Syed Ammar Sohail - ammarsohail321@gmail.com
