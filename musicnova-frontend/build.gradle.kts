
plugins {
    id("org.jetbrains.kotlin.js")
    idea
}

group = "eu.musicnova"

repositories {
    mavenCentral()
    jcenter()
    maven("https://kotlin.bintray.com/kotlinx")
    maven("https://dl.bintray.com/kotlin/kotlin-eap/")
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":musicnova-shared"))
    implementation(npm("sweetalert2", "9.17.1", false))
    implementation(npm("@vizuaalog/bulmajs", "0.11.0", false))
    implementation(npm("cleave.js", "1.6.0", false))
    implementation(npm("@types/cleave.js", "1.4.3", false))
    implementation(npm("chart.js", "2.9.3"))
    implementation(npm("dropzone", "5.7.2"))
    implementation(npm("@types/dropzone", "5.7.1", false))
    implementation(npm("@types/chart.js","2.9.24",false))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.4.3")
}

kotlin {

    js {
        browser {
            dceTask {
                dceOptions {
                    devMode = false
                }
            }
            distribution {}
            runTask {
                cssSupport.enabled = true
            }
            webpackTask {
                cssSupport.enabled = true
                outputFileName = "musicnova.js"
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                    useSafari()
                    useOpera()
                }
            }
        }
    }
}