# Simple Framework
This is a very simple testing framework to test Institutional Client Registration page on https://exchange.sandbox.gemini.com/register/institution <br/> After each test running the framework will create test-output folder where you can see screenshots of target pages

## Clone repo
clone repository using
```shell
git clone https://github.com/dmitriisemm/GeminiSandBox.git
```

## How to run
1. Install JDK or JVM from https://www.oracle.com/java/technologies/downloads/ <br/>
Set JAVA_HOME path.
2. To run tests use Maven. (https://maven.apache.org/) <br/>
Maven should be installed on target computer, and maven executable files should be added to MAVEN_HOME path <br/>

### To run in Chrome Browser
Chrome should be installed
```shell
mvn clean test -Dbrowser=chrome
```

### To run in Firefox Browser
Firefox should be installed
```shell
mvn clean test -Dbrowser=firefox
```

