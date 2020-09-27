pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }

    plugins {
        id(GradlePluginId.GRADLE_VERSION_PLUGIN) version GradlePluginVersion.GRADLE_VERSION_PLUGIN
        id(GradlePluginId.KOTLIN_JVM) version GradlePluginVersion.KOTLIN
        id(GradlePluginId.KOTLIN_ANDROID) version GradlePluginVersion.KOTLIN
        id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS) version GradlePluginVersion.KOTLIN
        id(GradlePluginId.ANDROID_APPLICATION) version GradlePluginVersion.ANDROID_GRADLE
        id(GradlePluginId.ANDROID_LIBRARY) version GradlePluginVersion.ANDROID_GRADLE
        id(GradlePluginId.SAFE_ARGS) version GradlePluginVersion.SAFE_ARGS
        id(GradlePluginId.JFROG_ARTIFACTORY) version GradlePluginVersion.JFROG_ARTIFACTORY
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                GradlePluginId.ANDROID_APPLICATION,
                GradlePluginId.ANDROID_LIBRARY,
                GradlePluginId.SAFE_ARGS -> useModule(GradleOldWayPlugins.SAFE_ARGS)
                GradlePluginId.JACOCO -> useModule(GradleOldWayPlugins.JACOCO)
                GradlePluginId.JFROG_ARTIFACTORY -> useModule(GradleOldWayPlugins.JFROG_BUILD_INFO)
            }
        }
    }
}

rootProject.buildFileName = "build.gradle.kts"
include(*ModuleDependency.getAllModules().toTypedArray())
