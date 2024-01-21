plugins {
    id("my-java-library")
}

dependencies {
    // Could use the platform we created to use centralized versions
//    implementation(platform("com.example:platform"))

    implementation(project(":data-model"))

    // This uses libs.versions.toml for centralized dependency declarations
    implementation(libs.commons.lang)
    implementation(libs.slf4j.api)
}