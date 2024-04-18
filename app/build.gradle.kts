plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.devtools.ksp")
    kotlin("kapt")

}

android {
    val appName = "com.example.outlook.planner"
    namespace = appName
    compileSdk = 34

    defaultConfig {
        applicationId = appName
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    /**
     * Manually-added dependencies
     */
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose")
    implementation("com.google.android.material:material")
    // Room Database
    implementation("androidx.room:room-runtime")
    ksp("androidx.room:room-compiler")
    implementation("androidx.room:room-ktx")
    // Retrofit + Retrofit with Scalar Converter
    implementation(libs.retrofit)
    implementation(libs.converter.scalars)


}

dependencies {
    /**
     * Version variables
     */
    val versionViewModel = "2.7.0"
    val versionMaterial = "1.11.0"
    val versionRoom = "2.6.1"
    constraints {
        /**
         * Manually-added dependencies minimum versions
         */
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$versionViewModel")
        implementation("com.google.android.material:material:$versionMaterial")
        implementation("androidx.room:room-runtime:$versionRoom")
        ksp("androidx.room:room-compiler:$versionRoom")
        implementation("androidx.room:room-ktx:$versionRoom")
    }
}
