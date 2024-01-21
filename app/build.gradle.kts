plugins {
    id("my-application")
}

application {
    mainClass.set("com.example.MyApplication")
}

dependencies {
    // Could use the platform we created to use centralized versions
    //    implementation(platform("com.example:platform"))

    implementation(project(":data-model"))
    implementation(project(":business-logic"))

    // This uses libs.versions.toml for centralized dependency declarations
    runtimeOnly(libs.slf4j.simple)
}