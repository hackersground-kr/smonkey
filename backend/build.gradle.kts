import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugin.SPRING_FRAMEWORK) version PluginVersions.SPRING_BOOT_VERSION
    id(Plugin.SPRING_MANAGEMENT) version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin(Plugin.KOTLIN_JVM) version PluginVersions.JVM_VERSION
    kotlin(Plugin.KOTLIN_SPRING) version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin(Plugin.KOTLIN_JPA) version PluginVersions.JPA_PLUGIN_VERSION
//    id(Plugin.KT_LINT) version PluginVersions.KT_LINT
}

group = ProjectProperties.Group
version = PluginVersions.PROJECT_VERSION

java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    installDependencies(
        spring = true,
        kotlin = true,
        ktlint = false,
        jackson = true,
        jwt = true,
        swagger = true,
    )

    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")

    val runtime = listOf(
        Dependencies.MYSQL_DRIVER,
    ).dependenciesFlatten()

    runtime.forEach(::runtimeOnly)

    annotationProcessor(Dependencies.CONFIGUATION_PROCESSOR)
}

allOpen {
    annotation("javax.persistence.Entity")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = ProjectProperties.JvmTarget
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
