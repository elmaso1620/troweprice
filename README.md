# Table of Contents

1. [Background](#background)
2. [Assumptions](#assumptions)
2. [Building the Project](#building-the-project)
2. [Executing Test's](#executing-tests)
## Background
This repository contains the solution for identifying the longest and shortest words for a given sentence.
## Assumptions
1. All characters aside from letters are excluded from calculating the word length e.g. punctuation like full stops, comma's, quotation marks etc.
2. A sentence may include more than one word with the same shortest/longest length. As such, the find methods return a Collection of Word objects. Word objects are used to encapsulate both the word value and length.
## Building the Project
The project can be built using [Maven 3.5.0+](https://maven.apache.org/run-maven/index.html) and requires [JDK 1.8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html). To build from the command line:
```
$ cd <project directory>
$ mvn clean install
```
## Executing Test's
You can also run the project Tests from the command line too:
```
$ cd <project directory>
$ mvn test
```
