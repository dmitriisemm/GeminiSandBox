# Simple Framework
This is very simple testing framework to test Institutional Client Registration page on https://exchange.sandbox.gemini.com/register/institution

## Clone repo
clone repository using
```shell
git clone https://github.com/dmitriisemm/GeminiSandBox.git
```

## How to run
to run tests use Maven. (https://maven.apache.org/)
Maven should be installed on target computer and maven executable files should be added to MAVEN_HOME path

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
