plugins {
    id("java")
    id("com.diffplug.spotless")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

sourceSets.create("integrationTest")
tasks.register<Test>("integrationTest") {
    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath

    useJUnitPlatform()
}

tasks.test {
    useJUnitPlatform {
        excludeTags("slow")
    }

    maxParallelForks = 4
    maxHeapSize = "1g"
}

// One way to split up test sources
tasks.register<Test>("slowTests") {
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath

    useJUnitPlatform {
        includeTags("slow")
    }
}

tasks.check {
    dependsOn(tasks.named("slowTests"))
}