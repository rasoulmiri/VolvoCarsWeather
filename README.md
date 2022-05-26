# Volvo Cars Weather

The project is developed in the Kotlin language and also uses libraries such as Jetpack Compose, Koin, Coroutines, Coil, and Retrofit. The JUnit and Mockk test libraries were used for unit testing.

Multi-module using Clean Architecture alongside other components and MVVM architectural design patterns are used for project architecture.

In the following image, you can see the modules:
![This is a alt text.](https://drive.google.com/uc?export=view&id=1ra56QVsVopOtLonBRA5XrCHubLBqBp-6 "This is a sample image.")

The Gradel Script is written in Kotlin DSL and has three plugins, as shown in the following image.
![This is a alt text.](https://drive.google.com/uc?export=view&id=153wW8f1A-ylCRzOIZNbxEIXDELBMyGIc "This is a sample image.")

**FYI** : the website https://www.metaweather.com that was mentioned in the task is down with the error: page not found (404), so I used this repository https://github.com/Teknologica/meta-weather-test-app For API response.
Due to the response issue, you can find some parts of codes using mocks in the following address:
```sh
VolvoCarsWeather/features/main/src/test/resources/json/
```
and shown in code with **// TODO MOCK**
