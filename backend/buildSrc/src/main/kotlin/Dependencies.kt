object Dependencies {

    // ktlint
    const val KTLINT = "com.pinterest:ktlint:${DependencyVersions.KTLINT_VERSION}"

    // validation
    const val VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

    // kotlin
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"

    // mapstruct
    const val MAPSTRUCT_APT = "org.mapstruct:mapstruct-processor:${DependencyVersions.MAPSTRUCT_VERSION}"

    // test
    const val SPRING_TEST = "org.springframework.boot:spring-boot-starter-test:${PluginVersions.SPRING_BOOT_VERSION}"

    // database
    const val SPRING_DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val MYSQL_DRIVER = "mysql:mysql-connector-java"

    // security
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"

    // validation
    const val SPRING_VALIDATION = "org.springframework.boot:spring-boot-starter-validation"


    // redis
    const val SPRING_REDIS = "org.springframework.boot:spring-boot-starter-data-redis"

    // cloud
    const val SPRING_CLOUD = "org.springframework.cloud:spring-cloud-dependencies:${DependencyVersions.SPRING_CLOUD_VERSION}"

    // web
    const val SPRING_WEB = "org.springframework.boot:spring-boot-starter-web"

    // properties
    const val PROPERTIES_SCAN = "org.springframework.boot:spring-boot-configuration-processor"

    // jwt
    const val JWT = "io.jsonwebtoken:jjwt:${DependencyVersions.JWT}"

    // configuration-processor
    const val CONFIGUATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"

    const val SWAGGER_UI = "io.springfox:springfox-swagger-ui:3.0.0"
    const val SPRINGFOX_STARTER = "io.springfox:springfox-boot-starter:3.0.0"

}
