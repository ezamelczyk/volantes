plugins {
    java
    kotlin("jvm")
    application
}

dependencies {
    compile(kotlin("stdlib"))
    compile(project(":login-service"))
    implementation("io.grpc:grpc-netty:1.22.1")
}

application {
    mainClassName = "Server"
}