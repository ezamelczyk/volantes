plugins {
    java
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    api(project(":grpc-apis:login-api"))
    implementation("org.jetbrains.exposed:exposed:0.17.7")
    implementation("org.mindrot:jbcrypt:0.4")
}