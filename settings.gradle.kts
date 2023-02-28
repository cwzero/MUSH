pluginManagement {
    val kotlinVersion: String by settings
    val versionsVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        id("com.github.ben-manes.versions") version versionsVersion
    }
}

rootProject.name = "MUSH"
