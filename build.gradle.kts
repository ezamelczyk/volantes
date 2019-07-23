allprojects {
    repositories {
        jcenter()
    }
}

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.41"))
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.10")
    }
}