@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
android {
    namespace = "com.saehyun.presentation"
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
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
    compileOptions {
        sourceCompatibility = Application.sourceCompatibility
        targetCompatibility = Application.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Application.jvmTarget

        freeCompilerArgs += listOf(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=${rootProject.file(".").absolutePath}/report/compose-reports"
        )
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.common.android)
    implementation(projects.common.kotlin)

    implementation(libs.di.hilt.core)
    implementation(platform(libs.compose.bom))
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)
    kapt(libs.di.hilt.compiler)

    implementation(libs.orbit.compose)
    implementation(libs.orbit.viewmodel)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation(platform(libs.compose.bom))
    implementation(libs.activity.compose)
    implementation(libs.compose.ui.coil)
    implementation(libs.compose.nav)
    implementation(libs.compose.hilt)
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta09")
    implementation(libs.kotlin.collections.immutable)

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.appcompat)
    implementation(libs.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
