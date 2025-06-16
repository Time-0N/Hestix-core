import java.util.Properties

plugins {
    id("org.springframework.boot") version "3.3.0" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
    kotlin("jvm") version "1.9.20" apply false
}

allprojects {
    group = "ch.hestix"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

tasks.register("buildFrontend") {
    dependsOn(":frontend:build")
}

// Common .env validation for all tasks
gradle.taskGraph.whenReady {
    val envFile = rootProject.file(".env")
    if (!envFile.exists()) {
        throw GradleException("""
            |ERROR: .env file is required but missing!
            |Create a .env file in the project root with BUILD_PROFILE property.
            |Example:
            |   BUILD_PROFILE=dev
            |""".trimMargin())
    }

    val props = Properties().apply { load(envFile.inputStream()) }
    if (props.getProperty("BUILD_PROFILE").isNullOrBlank()) {
        throw GradleException("""
            |ERROR: BUILD_PROFILE is not defined in .env file!
            |Add this to your .env:
            |   BUILD_PROFILE=dev
            |""".trimMargin())
    }
}

tasks.register("buildBackend") {
    dependsOn(":backend:build")
    doLast {
        val envFile = rootProject.file(".env")
        val props = Properties().apply { load(envFile.inputStream()) }
        val profile = props.getProperty("BUILD_PROFILE") ?: "dev"
        println("Built backend with profile: '$profile'")
    }
}