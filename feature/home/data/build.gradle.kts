import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("kotlin-android")
    id ("org.jetbrains.kotlin.kapt")
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "com.avazpar.eventdog.home.data"
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        vectorDrawables.useSupportLibrary = true

        val propertyValue = project.properties["apiBaseUrl"] as? String
        propertyValue?.let { buildConfigField("String", "API_URL", it) }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(project(":feature:home:domain"))

    implementation(libs.koin)
    implementation(libs.koin.android)
    implementation(libs.kotlinx.coroutines.android)

    implementation ("androidx.room:room-runtime:2.4.3")
    kapt ("androidx.room:room-compiler:2.4.3")
    implementation ("androidx.room:room-ktx:2.4.3")

    implementation ("com.squareup.moshi:moshi-kotlin:1.13.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    kapt ("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
}