plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.kalma_nic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kalma_nic"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    // Habilita View Binding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Librerías principales de Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    // Componentes de Material Design para UI moderna
    implementation(libs.google.material)
    implementation(libs.androidx.constraintlayout)

    // Componente de navegación
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Librerías de prueba
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

