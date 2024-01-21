pluginManagement {
    repositories.gradlePluginPortal()
//    repositories.mavenCentral()
//    repositories.google()
//    repositories.maven("https://my.location/repo") {
//        credentials {
//            username = "..."
//            password = "..."
//        }
//    }

    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
//    repositories.google()
//    repositories.maven("https://my.location/repo") {
//        credentials {
//            username = "..."
//            password = "..."
//        }
//    }
//
//    includeBuild("../my-other-project")
    includeBuild("gradle/platform")
}

rootProject.name = "my-project"

include("app")
include("business-logic")
include("data-model")