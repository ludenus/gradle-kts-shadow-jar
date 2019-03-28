    import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
    import org.gradle.api.tasks.testing.logging.TestLogEvent
    
    plugins {
    
        kotlin("jvm") version "1.3.20"
        id("com.github.johnrengelman.shadow") version "4.0.4"
    
        application
    }
    
    
    group = "com.example"
    version = "0.0.1"
    
    repositories {
        jcenter()
        mavenCentral()
    }
    
    val junitVersion = "5.4.0"
    
    dependencies {
        implementation(kotlin("stdlib", "1.3.20"))
        implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.20")
    
        compileClasspath("com.github.jengelman.gradle.plugins:shadow:4.0.4")
    
        implementation("org.slf4j:slf4j-api:1.7.21")
        implementation("ch.qos.logback:logback-core:1.2.3")
        implementation("ch.qos.logback:logback-classic:1.2.3")
    
        testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.1")
        testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
        testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
        runtime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    
    }
    
    application {
        mainClassName = "com.example.App"
    }
    
    
    val test by tasks.getting(Test::class) {
        useJUnitPlatform()
        testLogging.showStandardStreams = true
        testLogging.events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED, TestLogEvent.STANDARD_OUT, TestLogEvent.STANDARD_ERROR)
    }
    
    tasks.withType<ShadowJar> {
        manifest {
            attributes["Implementation-Title"] = "Shadow Jar"
            attributes["Implementation-Version"] = version
            attributes["Main-Class"] = "com.example.App"
        }
        classifier = "jar-with-dependencies"
    }
    
