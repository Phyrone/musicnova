plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.4.10"
}

group = "eu.musicnova"


repositories {
    mavenCentral()
}
val ser_version = "1.2.0"
kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                api("org.jetbrains.kotlinx:kotlinx-serialization-core:$ser_version")
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:$ser_version")
                api("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:$ser_version")
            }
        }
        val commonTest by getting {
            repositories{
                maven("https://kotlinlang.org/")
            }
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(kotlin("test"))

            }
        }
    }
    js {
        browser()
        compilations["main"].defaultSourceSet {
            repositories {
                mavenCentral()
            }
            dependencies {
                implementation(kotlin("stdlib-js"))
                //api("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$ser_version")
                //api("org.jetbrains.kotlinx:kotlinx-serialization-protobuf-js:$ser_version")
            }
        }
        compilations["test"].defaultSourceSet {
            repositories {
                mavenCentral()
            }
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation(kotlin("test-js"))
            }
        }
    }
    jvm {
        compilations["main"].defaultSourceSet {
            repositories {
                mavenCentral()
            }
            dependencies {
                implementation(kotlin("stdlib-jdk8"))

                //api("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$ser_version")
                //api("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:$ser_version")
            }
        }
        compilations["test"].defaultSourceSet {
            repositories {
                mavenCentral()
            }
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(kotlin("test-junit"))
                implementation(kotlin("test-junit"))
            }
        }
    }
}