import com.example.gradle.JarCount

plugins {
    id("application")
    id("my-java-base")
}

// Use an existing task's implementation
tasks.register<Zip>("bundle") {
    group = "My Group"
    description = "package it all!"

    from(tasks.jar)
    from(configurations.runtimeClasspath)

    destinationDirectory.set(layout.buildDirectory.dir("distribution"))
}

// Make our own task from scratch
tasks.register<JarCount>("countJars") {
    group = "My Group"
    description = "Counts!"

    allJars.from(tasks.jar)
    allJars.from(configurations.runtimeClasspath)

    countFile.set(layout.buildDirectory.file("gen/count.txt"))
}

tasks.build {
    dependsOn(tasks.named("bundle"))
}

tasks.register("buildAll") {
    description = "Builds even more!"

    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}