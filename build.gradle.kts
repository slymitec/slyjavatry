plugins {
    java
    id("org.springframework.boot") version ("4.1.0")
    id("io.spring.dependency-management") version ("1.1.7")
}

allprojects {
    group = projectNameSpace
    version = projectVersion

    repositories {
        mavenCentral()
    }
}

subprojects {
    pluginManager.apply("java")
    pluginManager.apply("org.springframework.boot")
    pluginManager.apply("io.spring.dependency-management")

    tasks.bootJar {
        enabled = false
    }

    tasks.jar {
        enabled = true
    }

    tasks.test {
        useJUnitPlatform()
    }
}

dependencies {
    implementation("jakarta.inject:jakarta.inject-api:2.0.1")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("com.microsoft.sqlserver:mssql-jdbc:13.4.0.jre11")
//    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.springframework.ai:spring-ai-client-chat")
    implementation("org.springframework.ai:spring-ai-starter-model-deepseek:2.0.1")
    implementation("org.redisson:redisson-spring-boot-starter:4.8.0")
    implementation("org.apache.fory:fory-core:1.7.6")
    implementation("org.apache.fory:fory-json:1.7.6")
}

val versions = mapOf(
    "ScalaBinary" to "3"
)

//dependencies {
//    implementation(platform("org.apache.pekko:pekko-bom_${versions["ScalaBinary"]}:1.6.0"))
//    implementation("org.apache.pekko:pekko-actor-typed_${versions["ScalaBinary"]}")
//    testImplementation("org.apache.pekko:pekko-actor-testkit-typed_${versions["ScalaBinary"]}")
//}

dependencies {
    // Source: https://mvnrepository.com/artifact/io.dapr.spring/dapr-spring-boot-starter
    implementation("io.dapr.spring:dapr-spring-boot-starter:1.18.1")

//    implementation("io.dapr:dapr-sdk:1.18.1")
//    implementation("io.dapr:dapr-sdk-actors:1.18.1")
//    implementation("io.dapr:dapr-sdk-springboot:1.18.1")
}

var projectName = "SLY System"
var projectVersion = "1.0.0.0"
var projectNameSpace = "indi.sly.system"
var javaLanguageVersion = 25
var textEncoding = "UTF-8";

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaLanguageVersion)
    }
}

tasks.compileJava {
    options.encoding = textEncoding
    options.release.set(javaLanguageVersion)
}

tasks.compileTestJava {
    options.encoding = textEncoding
    options.release.set(javaLanguageVersion)
}

tasks.jar {
    enabled = true
    manifest {
        attributes(
            "Implementation-Title" to projectName, "Implementation-Version" to projectVersion
        )
    }
}

tasks.bootJar {
    enabled = true
    mainClass.set("indi.sly.system.boot.SystemBoot")
    manifest {
        attributes(
            "Implementation-Title" to projectName, "Implementation-Version" to projectVersion
        )
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
