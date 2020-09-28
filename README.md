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

## Example for use in Android Demo App

For use a basic Android project. Please include the following steps (Tutorial for Kotlin):

* `gradle.properties` from root project:

```gradle
artifactory_contextUrl=https://anibalbastias.jfrog.io/artifactory/
artifactory_rel_repo_key=libs-release-local
artifactory_user=tester
artifactory_password=APhDHPFrvL2xUmv64FyXbLo6gr
```

* `build.gradle` from root project:

```gradle
allprojects {
    repositories {
        google()
        jcenter()

        maven { url "https://dl.bintray.com/kodein-framework/Kodein-DI" }
        maven {
            // Library
            url artifactory_contextUrl + "/" + artifactory_rel_repo_key
            authentication {
                basic(BasicAuthentication)
            }
            credentials {
                username artifactory_user
                password artifactory_password
            }
        }
    }
}
```

* `build.gradle` from app module, add the following import libraries:

```gradle
implementation("org.kodein.di:kodein-di-generic-jvm:6.5.5")
implementation("org.kodein.di:kodein-di-framework-android-x:6.5.5")
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3")
implementation("com.squareup.okhttp3:okhttp:4.3.1")
implementation("com.squareup.okhttp3:logging-interceptor:4.3.1")
implementation("com.squareup.retrofit2:retrofit:2.7.1")
implementation("com.squareup.retrofit2:converter-moshi:2.7.1")

implementation("com.anibalbastias.weatherapi:library:1.0.0@aar")
```

* In the Android Manifest file:

```xml
<!-- Mandatory permission for request to Endpoint -->
<uses-permission android:name="android.permission.INTERNET" />

<!-- Mandatory usesCleartextTraffic attribute for secure SSL endpoints -->
<application
    android:allowBackup="true"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:roundIcon="@mipmap/ic_launcher_round"
    android:supportsRtl="true"
    android:usesCleartextTraffic="true"
    android:theme="@style/Theme.WeatherTestApp"
    tools:ignore="UnusedAttribute">
    <activity android:name=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
</application>
```

* In the `MainActivity` class or your prefered MainFragment:

```kotlin
class MainActivity : AppCompatActivity() {

    lateinit var manager: WeatherManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = WeatherManager(application)

        val latitude = -33.5346427
        val longitude = -70.630751

        manager.getCurrentWeather(latitude, longitude,
            object: WeatherListener {
                override fun onGetGeoLocationSuccess(geoLocation: WeatherGeoLocation) {
                    Toast.makeText(applicationContext, geoLocation.cityName, Toast.LENGTH_LONG).show()
                }

                override fun onGetGeoLocationError(message: String) {
                    Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
                }

                override fun onGetCurrentConditionsSuccess(currentConditions: WeatherCurrentCondition) {

                }

                override fun onGetCurrentConditionsError(message: String) {

                }

                override fun onGet1DayForecastSuccess(currentConditions: WeatherForecast) {

                }

                override fun onGet1DayForecastError(message: String) {

                }

                override fun onGet5DayForecastSuccess(currentConditions: WeatherForecast) {

                }

                override fun onGet5DayForecastError(message: String) {

                }
            })
    }
}
```

This is a screenshot for the needed and important data from API:

![demo](misc/demo.png?raw=true)

## Test Coverage

The following image shows the almost 80% of coverage for Unit testing in library

![test_coverage](misc/test-coverage.png?raw=true)

## TODO

* Implement Actions for Github CI
* Implement Detekt for vulnerability code
* Increment coverage for Unit tests
* Implement this library for iOS Apps.
* Import 3rd parties libraries as aar files in libs folder for avoid import in the external projects
* Complete Demo handling connection cases and integrate forecast data

