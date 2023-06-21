@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    id(libs.plugins.kotlin.ksp.get().pluginId)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.saehyun.data"
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        externalNativeBuild {
            cmake {
                cppFlags("")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    compileOptions {
        sourceCompatibility = Application.sourceCompatibility
        targetCompatibility = Application.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Application.jvmTarget
    }
}

dependencies {
    implementation(projects.common.android)
    implementation(projects.common.kotlin)
    implementation(projects.domain)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation(libs.di.hilt.core)
    kapt(libs.di.hilt.compiler)

    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    implementation(libs.datastore.pref)
    implementation(libs.datastore.pref.core)

    implementation(libs.kotlin.collections.immutable)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
}