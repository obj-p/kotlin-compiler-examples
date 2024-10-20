import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    kotlin("jvm") version "2.0.20"
    alias(libs.plugins.kotlin.kapt)
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.auto.service.annotations)
    compileOnly(libs.kotlin.compiler)

    kapt(libs.auto.service.processor)

    testImplementation(kotlin("test"))
    testImplementation(libs.kotlin.compile.testing)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    explicitApi()

    jvmToolchain(19)
}

tasks.withType<KotlinCompilationTask<*>>().configureEach {
    compilerOptions.freeCompilerArgs.add("-opt-in=org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi")
}