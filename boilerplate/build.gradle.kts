plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.example"
version = "0.1.0"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")

    dependencies {
        implementation(kotlin("stdlib"))
    }
}

kotlin {
    jvmToolchain(21)
}