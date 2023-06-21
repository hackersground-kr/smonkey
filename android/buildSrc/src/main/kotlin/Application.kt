import org.gradle.api.JavaVersion

object Application {
    const val applicationId = "com.saehyun.pdf_viewer"
    const val minSdk = 26
    const val compileSdk = 33
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "17"
    const val jvmTarget = "17"
    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility = JavaVersion.VERSION_17
}