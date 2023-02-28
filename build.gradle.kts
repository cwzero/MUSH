import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.github.ben-manes.versions")
	kotlin("jvm")
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

val kotlinxCoroutineVersion: String by project
val kotlinxImmutableVersion: String by project

val kotestVersion: String by project
val mockkVersion: String by project

dependencies {
    implementation(platform(kotlin("bom")))
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:$kotlinxImmutableVersion")
                
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))

    testImplementation(platform("io.kotest:kotest-bom:$kotestVersion"))
    testImplementation("io.kotest:kotest-assertions-core")
    testImplementation("io.kotest:kotest-runner-junit5")
    testImplementation("io.kotest:kotest-property")
    testImplementation("io.mockk:mockk:$mockkVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

val javaVersion = JavaVersion.VERSION_19
java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = javaVersion.toString()
}