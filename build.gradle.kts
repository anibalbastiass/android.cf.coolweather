plugins {
    id(GradlePluginId.GRADLE_VERSION_PLUGIN)
    id(GradlePluginId.KOTLIN_JVM) apply false
    id(GradlePluginId.KOTLIN_ANDROID) apply false
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS) apply false
    id(GradlePluginId.ANDROID_APPLICATION) apply false
    id(GradlePluginId.ANDROID_LIBRARY) apply false
    id(GradlePluginId.SAFE_ARGS) apply false
}

// all projects = root project + sub projects
allprojects {
    repositories {
        google()
        jcenter()
    }
}
