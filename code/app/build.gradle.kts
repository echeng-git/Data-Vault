plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.sigma_blue"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sigma_blue"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val nav_version = "2.7.5"

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")
    implementation("com.google.firebase:firebase-firestore")
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
}