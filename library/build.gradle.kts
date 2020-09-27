plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    id(GradlePluginId.SAFE_ARGS)
    id(GradlePluginId.JFROG_ARTIFACTORY)
    id(GradlePluginId.MAVEN_PUBLISH)
    kotlin(GradlePluginId.KAPT)
}

apply(from ="./../config/gradle/common-android-core-library.gradle")
apply(from ="./../config/gradle/jfrog-artifactory.gradle")

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }
}

kapt {
    generateStubs = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
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
}
