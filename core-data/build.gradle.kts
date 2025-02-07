plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.hilt.android)
	alias(libs.plugins.kotlin.ksp)
}

android {
	namespace = "com.tellme.core_data"
	compileSdk = 35

	defaultConfig {
		minSdk = 24

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

	implementation(project(":core-domain"))

	ksp(libs.hilt.compiler)
	implementation(libs.hilt.android)

	ksp(libs.androidx.room.compiler)
	implementation(libs.androidx.room.ktx)

	implementation(libs.kotlinx.coroutines.android)

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
}