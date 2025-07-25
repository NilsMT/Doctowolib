// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    //noinspection GradleDependency
    id("com.google.devtools.ksp") version "2.0.0-1.0.24" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}