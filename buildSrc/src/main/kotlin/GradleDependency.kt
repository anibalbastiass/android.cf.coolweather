object GradlePluginVersion {
    const val ANDROID_GRADLE = "3.6.3"
    const val GRADLE_VERSION_PLUGIN = "0.22.0"
    const val KOTLIN = CoreVersion.KOTLIN
    const val SAFE_ARGS = CoreVersion.NAVIGATION
    const val JFROG_ARTIFACTORY = "4.17.1"
    const val JACOCO = "0.8.5"
}

object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val KOTLIN_ANDROID_EXTENSIONS = "org.jetbrains.kotlin.android.extensions"
    const val GRADLE_VERSION_PLUGIN = "com.github.ben-manes.versions"
    const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
    const val JFROG_ARTIFACTORY = "com.jfrog.artifactory"
    const val MAVEN_PUBLISH = "maven-publish"
    const val KAPT = "kapt"
    const val JACOCO = "org.jacoco:org.jacoco.core"
}

object GradleOldWayPlugins {
    const val SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${GradlePluginVersion.SAFE_ARGS}"
    const val JFROG_BUILD_INFO = "org.jfrog.buildinfo:build-info-extractor-gradle:${GradlePluginVersion.JFROG_ARTIFACTORY}"
    const val JACOCO = "${GradlePluginId.JACOCO}:${GradlePluginVersion.JACOCO}"
}
