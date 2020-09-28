import com.android.build.gradle.internal.dsl.BaseFlavor
import com.android.build.gradle.internal.dsl.DefaultConfig

plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    id(GradlePluginId.SAFE_ARGS)
    id(GradlePluginId.JFROG_ARTIFACTORY)
    id(GradlePluginId.MAVEN_PUBLISH)
    id(GradlePluginId.JACOCO_ID)
    kotlin(GradlePluginId.KAPT)
}

apply(from ="./../config/gradle/common-android-core-library.gradle")
apply(from ="./../config/gradle/jfrog-artifactory.gradle")
apply(from = "./../config/gradle/jacoco.gradle")

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER

        buildConfigFieldFromGradleProperty("apiBaseUrl")
        buildConfigFieldFromGradleProperty("iconBaseUrl")
        buildConfigFieldFromGradleProperty("weatherApikey")
    }
}

kapt {
    generateStubs = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(project(ModuleDependency.TEST_UTILS))

    api(LibraryDependency.KOTLIN)
    api(LibraryDependency.KOTLIN_REFLECT)
    api(LibraryDependency.KODEIN)
    api(LibraryDependency.KODEIN_ANDROID_X)
    api(LibraryDependency.NAVIGATION_FRAGMENT_KTX)
    api(LibraryDependency.NAVIGATION_UI_KTX)
    api(LibraryDependency.TIMBER)
    api(LibraryDependency.APP_COMPAT)
    api(LibraryDependency.COROUTINES_ANDROID)
    api(LibraryDependency.CORE_KTX)
    api(LibraryDependency.FRAGMENT_KTX)
    api(LibraryDependency.LIFECYCLE_EXTENSIONS)
    api(LibraryDependency.LIFECYCLE_VIEW_MODEL_KTX)
    api(LibraryDependency.COIL)

    api(LibraryDependency.RX_JAVA)
    api(LibraryDependency.RX_ANDROID)
    api(LibraryDependency.RX_KOTLIN)

    kapt(LibraryDependency.LIFECYCLE_COMPILER)

    implementation(LibraryDependency.OK_HTTP)
    implementation(LibraryDependency.LOGGING_INTERCEPTOR)
    implementation(LibraryDependency.STETHO)
    implementation(LibraryDependency.STETHO_OK_HTTP)

    api(LibraryDependency.GMS_LOCATION)
    api(LibraryDependency.RETROFIT)
    api(LibraryDependency.RETROFIT_MOSHI_CONVERTER)
}

fun BaseFlavor.buildConfigFieldFromGradleProperty(gradlePropertyName: String) {
    val propertyValue = project.properties[gradlePropertyName] as? String
    checkNotNull(propertyValue) { "Gradle property $gradlePropertyName is null" }

    val androidResourceName = "GRADLE_${gradlePropertyName.toSnakeCase()}".toUpperCase()
    buildConfigField("String", androidResourceName,"\"" + propertyValue + "\"")
}

fun String.toSnakeCase() = this.split(Regex("(?=[A-Z])")).joinToString("_") {
    it.toLowerCase()
}