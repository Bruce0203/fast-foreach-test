plugins {
    kotlin("jvm") version "1.8.0"
    application
}


application {
    mainClass.set("io.github.bruce0203.foreachtest.PerformanceTest")
}

val kotlinVersion = "1.6.10"

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    testApi("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

}