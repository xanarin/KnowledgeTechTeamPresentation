## Maven Tutorial
###A Tutorial by Ben Oberhaus, Maggie Gilbert, Reid Fu, Tyler Zeller, and Will Sloan

---

## Overview
<br>
### 1. What is Maven?
### 2. How do I use Maven?
### 3. What do I need to use Maven?
### 4. Your first Maven project

<br><br>
_TL;DR: Maven is a project management tool based on the Project Object Model (POM)_

---

## What is Maven?

- Build automation tool for Java. 
- Java's version of **make**.
- Dynamically downloads Java libraries and plug-ins 

---

## How does it work?

Handles project dependencies by searching and linking from several
repositories:

1. Local
2. Central
3. Remote

---

## Local Repositories

- Located in your local system.
- Created by maven when you run any maven command
- Maven looks here first when looking for dependencies

---

## Central Repositories

- Located on the internet
- Second location maven searches for dependencies
- Created by the apache maven community 
- Listing of common libraries can be viewed at [search.maven.org](http://search.maven.org/#browse)

---

## Remote Repositories

- Located on the web 
- Includes packages missing from the central repo
- Third and last location maven will search for dependencies

---

## Tooling for Maven

- To use Maven, you need:
	- Java
	- Basic command line knowledge

---

## Installing Maven

- Download release from [Apache Maven](https://maven.apache.org/download.cgi) website
- Extract archive
- Add `bin` directory to PATH
- Run `mvn -v`, and you should see:
```bash
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T11:41:47-05:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_73, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.3", arch: "x86_64", family: "mac"
```

---

## IDE Integration

- What if I want Maven integrated with my IDE?
	- IDEs for Java are very common
	- IDE wrappers can make complex tools easier to use

- Prebuilt: IntelliJ
<img src="https://pbs.twimg.com/profile_images/803204448675856388/6eqoPNuy.jpg" style="margin-right=10%; float: right; position=relative" width=20% />
<img src="https://devcentral.f5.com/Portals/0/images/metapost/News-Articles/Joe/2010/Sep/WLW-GettingStartedWithiControlAndJavaSetting_8C5F-eclipse_2.png" style="margin-right=10%; float: right; position=relative" width=20% />

- Plugin: Eclipse

---

## Your First Maven Project

In a fresh directory run:

```bash
mvn archetype:generate -DgroupId=com.5914maven.app
 -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart
 -DinteractiveMode=false
```

```
my-app
| -- pom.xml
` -- src
     | -- main
     | ...  -- App.java
     | -- test
     ` ... -- AppTest.java
```

---

### Maven in a New Project continued

- `AppTest.java` imports JUnit libraries
  - You  don't have those downloaded, so you cannot just run javac!
  - How would you go out and download them?  
  - Enter Maven and the other file you generated: `pom.xml`.

---

## The Project Object Model (pom.xml)

This file contains everything Maven needs to know about your project.
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"   
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0   
  http://maven.apache.org/xsd/maven-4.0.0.xsd">  

    <modelVersion>4.0.0</modelVersion>  

    <groupId>com.5914maven.app1</groupId>  
    <artifactId>my-application1</artifactId>  
    <version>1.0</version>  
    <packaging>jar</packaging>

    <name>Maven Quick Start Archetype</name>  
    <url>http://maven.apache.org</url>

    <dependencies>  
        <dependency>  
            <groupId>junit</groupId>  
            <artifactId>junit</artifactId>  
            <version>4.8.2</version>  
            <scope>test</scope>  
        </dependency>  
    </dependencies>  

</project>  
```

---

## POM elements

- **project** - Mandatory root element.
  - **groupId** - Name of the group the project belongs to. Collection of artifacts.
  - **artifactId** - Unit of inidivdual project under a group.
  - **packaging** - Format of how to package project when `mvn package` is run.
  - **dependencies** - Root for list of depenencies.
    - **dependency** - Individual unit of a project dependency. Needs a `groupId`, `artifactId`, and a `version`.
    - **scope** - Scope level for a project or dependency. Can be `compile`, `runtime`, `test`, and `system`.

---

### The Project Object Model continued

- Maven parses `pom.xml` when most **mvn** commands are run
- On running `mvn clean compile` for the first time:
  - Maven goes out to the local, central, and remote repositories 
  - Looking for:
    - **groupId** ==  _**junit**_  
    - **artifactId** == _**junit**_ 
    - **version** == _**4.8.2**_

---

## Running Your First Maven Project

- At the top level of the your project, run: 
```bash
mvn clean compile
```
- You will see some output from downloading libraries the first time.  
  - The first run will be slower than most consecutive runs 

---

### Running Your First Maven Project continued
Finally, we are ready!
```bash
java com.5914maven.app1.App # prints "Hello World!"
```

---

### Running Your First Maven Project continued

- Can also package the app by running 
```bash
mvn package
```
- Run with: 
```bash
java -cp target/my-app-1.0-SNAPSHOT.jar com.5914maven.app1.App
```

---

## Questions?
