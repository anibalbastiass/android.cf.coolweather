import kotlin.reflect.full.memberProperties


@Suppress("unused")
object ModuleDependency {
    // All consts are accessed via reflection
    const val APP = ":app"
    const val TEST_UTILS = ":testutils"
    const val LIBRARY = ":library"

    fun getAllModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .map { it.getter.call().toString() }
        .toSet()

}
