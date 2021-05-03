@file:Suppress("SpellCheckingInspection")

group = "cl.uchile.dcc.scrabble"
version = "0.1-ALPHA.1"


val javaFXVersion: String by project
val jbAnnotationsVersion: String by project
val junitVersion: String by project
val commonsLangVersion: String by project

plugins {
    java
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.8"
    id("jacoco")
}

application {
    mainClass.set("cl.uchile.dcc.scrabble.gui.Scrabble")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(
        group = "org.openjfx",
        name = "javafx",
        version = javaFXVersion,
        ext = "pom"
    )
    implementation(
        group = "org.jetbrains",
        name = "annotations",
        version = jbAnnotationsVersion
    )
    testImplementation(
        group = "org.junit.jupiter", name = "junit-jupiter-api",
        version = junitVersion
    )
    testRuntimeOnly(
        group = "org.junit.jupiter", name = "junit-jupiter-engine",
        version = junitVersion
    )
    implementation(
        group = "org.apache.commons",
        name = "commons-lang3",
        version = commonsLangVersion
    )
}

javafx {
    version = javaFXVersion
    modules = mutableListOf("javafx.controls")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}