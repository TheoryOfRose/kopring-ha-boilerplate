plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "org.example.cmd"
version = "0.1.0"

dependencies {
    implementation(project(":domain"))
    implementation(project(":application"))
    implementation(project(":adapter"))
    implementation(project(":infrastructure"))
    //runtimeOnly("com.h2database:h2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation(kotlin("test"))
}

allOpen {
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}