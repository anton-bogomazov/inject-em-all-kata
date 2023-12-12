plugins {
    id("java")
}

group = "com.abogomazov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:5.6.3")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")

    implementation("org.springframework:spring-core:6.1.1")
    implementation("org.springframework:spring-beans:6.1.1")
    implementation("org.springframework:spring-context:6.1.1")


    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
