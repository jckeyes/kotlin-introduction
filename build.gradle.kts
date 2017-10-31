plugins{
	java
	kotlin("jvm") version "1.1.51"
}

repositories {
	mavenCentral()
}

dependencies {
	compile(kotlin("stdlib"))

	testCompile("junit:junit:4.12")
	testCompile("org.assertj:assertj-core:3.5.2")
}

