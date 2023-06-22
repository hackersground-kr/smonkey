import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.installDependencies(
    spring: Boolean = true,
    kotlin: Boolean = true,
    ktlint: Boolean = false,
    jackson: Boolean = true,
    jwt: Boolean = true,
    swagger: Boolean = true,
) {
    if(spring) {
        implementation(Dependencies.SPRING_DATA_JPA)
        implementation(Dependencies.SPRING_WEB)
        implementation(Dependencies.SPRING_SECURITY)
        implementation(Dependencies.SPRING_REDIS)
        implementation(Dependencies.SPRING_VALIDATION)
        testImplementation(Dependencies.SPRING_TEST)
    }

    if(kotlin) {
        implementation(Dependencies.KOTLIN_STDLIB)
        implementation(Dependencies.KOTLIN_REFLECT)
    }

    if(ktlint) {
        implementation(Dependencies.KTLINT)
    }

    if(jackson) {
        implementation(Dependencies.JACKSON)
    }

    if(jwt) {
        implementation(Dependencies.JWT)
    }

    if(swagger) {
        implementation(Dependencies.SWAGGER_UI)
        implementation(Dependencies.SPRINGFOX_STARTER)

    }
}

@Suppress(
    "OPT_IN_IS_NOT_ENABLED",
    "UNCHECKED_CAST"
)
@OptIn(ExperimentalStdlibApi::class)
fun List<*>.dependenciesFlatten() = buildList {
    this@dependenciesFlatten.forEach { dependency ->
        checkNotNull(dependency) {
            "dependency $dependency is null."
        }
        when (dependency) {
            is Collection<*> -> addAll(dependency as Collection<Any>)
            else -> add(dependency)
        }
    }
}

private fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

private fun DependencyHandler.debugImplementation(dependency: Any) {
    add("debugImplementation", dependency)
}

private fun DependencyHandler.testImplementation(dependency: Any) {
    add("testImplementation", dependency)
}

private fun DependencyHandler.kapt(dependency: Any) {
    add("kapt", dependency)
}

private fun DependencyHandler.project(path: String) =
    project(mapOf(Pair("path", path))) as ProjectDependency
