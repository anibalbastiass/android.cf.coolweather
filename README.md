# android.cf.coolweather
## Weather Android Library + Demo
[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.3.72-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AndroidStudio-4.0.0-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-5.6.4-blue?style=flat)](https://gradle.org)

The goal of the library is share AccuWeather API features for any Android projects using
good practices for programming and keep a modular, scalable, maintainable library.

This project is being maintained to match current industry standards.

## Security

For reuse this library, add this following data in your local `~/.gradle/gradle.properties` file.
If you would like to contribute or use this library, please request the data to anibal.bastias@gmail.com

## Example of use

This is an general example for local gradle.properties file

```
# JFrog Artifactory
artifactory_user={YOUR-ARTIFACTORY-USER}
artifactory_password={YOUR-ARTIFACTORY-USER-PASSWORD}
artifactory_contextUrl={YOUR-ARTIFACTORY-SERVER-URL}
artifactory_rel_repo_key=libs-release-local
```
## Import into project as Artifactory component

For use this library, add the following code into build.gradle (root) file:

```gradle
allprojects {
    repositories {
        jcenter()
        maven { url artifactory_contextUrl + artifactory_rel_repo_key }
    }
}
```

Then, import the library into your `build.gradle` (app) file for use AARMY project:

```gradle
implementation('com.anibalbastias.weatherapi:library:1.0.0@aar')
```

## Example for use in Android Demo App

