pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
/*gradle.beforeProject {
    val localPropertiesFile = rootDir.resolve("app.properties")
    if (localPropertiesFile.exists()) {
        val localProperties = java.util.Properties()
        localProperties.load(localPropertiesFile.inputStream())

            .forEach { (k, v) -> if (k is String) project.extra.set(k, v) }
    }
}*/

rootProject.name = "Fruity"
include(":app")
 