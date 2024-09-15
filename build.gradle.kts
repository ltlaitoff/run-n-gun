plugins {
    kotlin("jvm") version "2.0.10"
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "org.gunnrun"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
//    implementation("com.github.almasb:fxgl:21.1")
}

javafx {
    version = "17"
    modules = listOf("javafx.controls", "javafx.graphics")
}


tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.gunnrun.MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
