# Movie Listing Application

This project uses Gradle for building and testing Java code. This README provides instructions on how to run 
and test the project.

## Prerequisites
**JDK 21**: You can verify your Java version by running `java -version` in your terminal.

**Apache Gradle**: You can download Gradle from the official website

## Building the Project
The default Gradle task (build) will download dependencies, compile your Java code, and package it into a distributable 
format (e.g., JAR file). To build the project, run the following command in your terminal from the project root 
directory:

```bash
./gradlew build
```

## Testing the Project
Gradle automatically runs unit tests during the build process. To see the test results, run the build command:

```bash
.\gradlew test
```