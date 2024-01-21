import Build_gradle.Constants.SLF4J_VERSION

plugins {
    id("java-platform") // Similar to BOM
}

group = "com.example"

javaPlatform.allowDependencies()

object Constants {
    const val SLF4J_VERSION = "2.0.11"
}

dependencies {
    api(platform("com.fasterxml.jackson:jackson-bom:2.16.1"))
}

dependencies.constraints {
    api("org.apache.commons:commons-lang3:3.14.0")
    api("org.slf4j:slf4j-api:${SLF4J_VERSION}")
    api("org.slf4j:slf4j-simple:${SLF4J_VERSION}")
}