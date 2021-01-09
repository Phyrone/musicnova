import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.moowork.gradle.node.npm.NpmTask
//import com.github.ksoichiro.build.info.BuildInfoExtension

plugins {
    idea
    java
    id("org.springframework.boot") version "2.4.0"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("com.github.node-gradle.node") version "2.2.4"
    id("org.jetbrains.dokka") version "1.4.20"
    //id("com.github.ksoichiro.build.info") version "0.2.0"
    id("com.gorylenko.gradle-git-properties" ) version "2.2.3"

    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    kotlin("plugin.spring") version "1.4.10"
    kotlin("plugin.jpa") version "1.4.10"
    kotlin("plugin.allopen") version "1.4.10"
}

group = "eu.musicnova"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {

}
allprojects {
    repositories {
        mavenCentral()
        jcenter()
        mavenLocal()
        maven("https://jitpack.io/")
        maven("https://repo.phyrone.de/repository/j2v8-mirror/")
        maven("https://libraries.minecraft.net")
        maven("https://dl.bintray.com/s1m0nw1/KtsRunner")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    //implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-quartz")
    //implementation("org.springframework.boot:spring-boot-starter-rsocket")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    //implementation("org.springframework.shell:spring-shell-starter:2.0.0.RELEASE")

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.boot:spring-boot-configuration-processor")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    //implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    implementation("com.github.lalyos:jfiglet:0.0.8")

    implementation(project(":musicnova-shared"))

    implementation("io.sentry:sentry-logback:3.2.0")
    /*implementation("io.sentry:sentry-spring-boot-starter:3.0.0"){
        exclude(module = "spring-web")
        exclude(module = "spring-webmvc")
    }*/
    //kapt("org.springframework.boot:spring-boot-configuration-processor")

    //implementation("org.casbin:casbin-spring-boot-starter:0.0.9")

    implementation("org.fusesource.jansi:jansi:2.0.1")

    compileOnly ("org.projectlombok:lombok")
    kapt("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    //implementation("org.apache.commons:commons-text:1.9")
    //implementation("com.moandjiezana.toml:toml4j:0.7.1")
    implementation(group = "com.uchuhimo", name = "konf", version = "0.23.0")
    /*
    listOf(
        "konf-core",
        "konf-hocon",
        "konf-toml",
        "konf-xml",
        "konf-yaml"
    ).forEach { name ->
        implementation("com.github.Cybermaxke.konf:$name:449becc276")
    }
    */


    runtimeOnly("com.h2database:h2")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.batch:spring-batch-test")


    implementation("info.picocli:picocli:4.6.1")
    //kapt("info.picocli:picocli-codegen:4.4.0")

    implementation("com.github.oshi:oshi-core:5.3.6")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.12.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.+")
    implementation("com.google.zxing:core:3.4.1")
    implementation("org.greenrobot:eventbus:3.2.0")
    //implementation("com.github.pemistahl:lingua:1.0.1")
    implementation("de.sfuhrm:radiobrowser4j:2.0.3")
    implementation("me.tongfei:progressbar:0.9.0")
    implementation("com.sedmelluq:lavaplayer:1.3.64")
    implementation("com.github.theholywaffle:teamspeak3-api:1.2.0")
    implementation("com.github.manevolent:ts3j:1.0.2")
    implementation("net.dv8tion:JDA:4.2.0_222")
    implementation("com.github.Phyrone:brigardier-kotlin:1.4.0")
    implementation("com.zaxxer:HikariCP:3.4.5")
    implementation("org.xeustechnologies:jcl-core:2.8")
    implementation("de.vandermeer:asciitable:0.3.2")
    implementation("com.github.excitement-engineer:ktor-graphql:2.0.0") {
        exclude("org.apache.logging.log4j", "log4j-slf4j-impl")
    }
    implementation("com.tgirard12:graphql-kotlin-dsl:1.2.0") {
        exclude("org.apache.logging.log4j", "log4j-slf4j-impl")
    }
    implementation("com.github.papsign:Ktor-OpenAPI-Generator:0.2-beta.13")

    listOf(
        "ktor-server-netty",
        "ktor-html-builder",
        "ktor-websockets",
        "ktor-jackson",
        "ktor-auth"
    ).forEach { name ->
        implementation("io.ktor", name, "1.4.0")
    }

    listOf("exposed-core", "exposed-dao", "exposed-jdbc", "exposed-jodatime", "exposed-java-time").forEach { name ->
        implementation("org.jetbrains.exposed", name, "0.27.1")
    }

    //kapt("org.inferred:freebuilder:2.7.0")
    implementation("org.inferred:freebuilder:2.6.1")

    implementation("org.jline:jline:3.17.1")
    implementation("net.java.dev.jna:jna:5.6.0")

    implementation("com.eclipsesource.j2v8:j2v8_linux_x86_64:6.2.0")
    implementation("com.eclipsesource.j2v8:j2v8_win32_x86_64:4.6.0")
    implementation("com.eclipsesource.j2v8:j2v8_macosx_x86_64:4.6.0")
    implementation("com.eclipsesource.j2v8:j2v8_win32_x86:4.6.0")

    //TODO
    implementation("org.python:jython:2.7.2")
    implementation("org.luaj:luaj-jse:3.0.1")
    implementation("de.swirtz:ktsRunner:0.0.9")
    implementation("com.zaxxer:nuprocess:2.0.1")

    implementation("com.github.marceloaguiarr:valkyrie:1.2.0")

    implementation("org.greenrobot:eventbus:3.2.0")
    implementation("com.google.guava:guava:30.0-jre")
    implementation("org.jgrapht:jgrapht-core:1.5.0")
    implementation("com.jcabi:jcabi-manifests:1.1")
    implementation("com.google.jimfs:jimfs:1.1")
    implementation("com.google.auto.factory:auto-factory:1.0-beta8")
    //kapt("com.google.auto.factory:auto-factory:1.0-beta8")
    implementation("com.google.auto.service:auto-service:1.0-rc7")
    //kapt("com.google.auto.service:auto-service:1.0-rc7")

}
tasks {


    withType<Test> {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
    val copyResName = "copy-resource-files"
    val preCopyResName = "pre-copy-resource-files"
    create(copyResName) {
        dependsOn(preCopyResName, "copy-kotlin-js", "copy-assets")
    }
    create(preCopyResName) {
        dependsOn(JavaPlugin.PROCESS_RESOURCES_TASK_NAME)
    }
    create<NpmTask>("build-webpack") {
        dependsOn("npmInstall", preCopyResName)
        setArgs(listOf("run", "webpack"))
    }
    create<Copy>("copy-assets") {
        dependsOn(preCopyResName, "build-webpack")
        from("${buildDir.path}/webpack/assets/")
        into("${buildDir.path}/resources/main/web/assets/")
    }
    create<Copy>("copy-kotlin-js") {
        val frontendProject = project(":musicnova-frontend")
        dependsOn(":musicnova-frontend:browserProductionWebpack", preCopyResName)
        from("${frontendProject.buildDir.path}/distributions/")
        into("${buildDir.path}/resources/main/web/assets/js/")
    }
    classes {
        dependsOn("copy-resource-files")
    }
    clean {
        delete("src/main/web/node_modules")
    }
    springBoot {
        buildInfo()
    }

    bootJar {
        manifest {
            attributes["BootJAR"] = true
            attributes["Title"] = "Musicnova"
            attributes["Implementation-Version"] = project.version.toString()
        }
    }
}

node {
    version = "12.18.3"

    download = true

    // Set the work directory for unpacking node
    workDir = file("${project.buildDir}/nodejs")

    nodeModulesDir = file("src/main/web")
}
/*
buildInfo {
    manifestEnabled = true
    gitPropertiesEnabled = false
    gitInfoMode = BuildInfoExtension.MODE_DEFAULT
}
*/

idea {

}
gitProperties{
    gitPropertiesName = "git.properties"
}