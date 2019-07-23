import com.google.protobuf.gradle.*

plugins {
    id("com.google.protobuf")
    kotlin("jvm")
    java
    idea
}

repositories {
    maven("https://plugins.gradle.org/m2/")
}

val protobufVersion = "3.7.1"
val grpcVersion = "1.21.0"
val grpcKotlinVersion = "0.1.1"

the<JavaPluginConvention>().sourceSets {

}

dependencies {
    compile("com.google.api.grpc:proto-google-common-protos:1.0.0")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.0")
    compile("io.grpc:grpc-netty:$grpcVersion")
    compile("io.grpc:grpc-protobuf:$grpcVersion")
    compile("io.grpc:grpc-stub:$grpcVersion")
    compile(kotlin("stdlib"))
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