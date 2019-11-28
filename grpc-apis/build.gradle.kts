import com.google.protobuf.gradle.*

val protobufVersion = "3.7.1"
val grpcVersion = "1.21.0"
val grpcKotlinVersion = "0.1.1"

plugins {
    id("com.google.protobuf").apply(false)
    kotlin("jvm").apply(false)
}

subprojects {
    apply(plugin = "com.google.protobuf")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")
    apply(plugin = "idea")

    val implementation by configurations

    dependencies {

        implementation(kotlin("stdlib"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.0")
        implementation("io.grpc:grpc-protobuf:$grpcVersion")
        implementation("io.grpc:grpc-stub:$grpcVersion")
        implementation("javax.annotation:javax.annotation-api:1.3.1")
    }

    protobuf {
        protoc {
            // The artifact spec for the Protobuf Compiler
            artifact = "com.google.protobuf:protoc:$protobufVersion"
        }
        plugins {
            id("grpc") {
                artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
            }
            id("grpckotlin") {
                artifact = "io.rouz:grpc-kotlin-gen:$grpcKotlinVersion:jdk8@jar"
            }
        }
        generateProtoTasks {
            all().all {
                plugins {
                    id("grpc")
                    id("grpckotlin")
                }
            }
        }
    }
}