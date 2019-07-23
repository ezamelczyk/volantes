plugins {
    java
    kotlin("jvm")
    application
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":login-api"))
    implementation("io.grpc:grpc-netty:1.22.1")
}

application {
    mainClassName = "volantes.login.LoginServer"
}