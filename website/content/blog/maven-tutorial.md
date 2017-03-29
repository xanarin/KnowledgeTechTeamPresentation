+++
title = "Maven Tutorial"
date = 2017-03-28T08:03:00Z
blogimport = true 
type = "post"
[author]
	name = "Tech Group 1"
	uri = "https://plus.google.com/115818189328363361527"
+++
## Your First Maven Project
- In a fresh directory run:

```java 
mvn archetype:generate -DgroupId=com.5914maven.app1 -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
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

- You can see the resulting directory structure contains two source files `App.java` and `AppTest.java`. Opening them shoes that this is your standard Java Hello World! project. 

- In `AppTest.java` you see it imports JUnit libraries. You realize you don't have those downloaded, so you cannot just run javac. How would you go out and download them? Enter Maven and the other file you generated: `pom.xml`.

## The Project Object Model
- Every Maven project requires a `pom.xml` file. This file contains everything Maven needs to know about your project. Here is an example of a POM file:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"   
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0   
  http://maven.apache.org/xsd/maven-4.0.0.xsd">  
    
    <modelVersion>4.0.0</modelVersion>  
        
    <groupId>com.5914maven.app1</groupId>  
    <artifactId>my-application1</artifactId>  
    <version>1.0</version>  
    <packaging>jar</packaging
    
    <name>Maven Quick Start Archetype</name>  
    <url>http://maven.apache.org</url
    
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

- `project` - Mandatory root element.
- `groupId` - Name of the group the project belongs to. Collection of artifacts.
- `artifactId` - Unit of inidivdual project under a group.
- `packaging` - Format of how to package project when `mvn package` is run.
- `dependencies` - Root for list of depenencies.
- `dependency` - Individual unit of a project dependency. Needs a `groupId`, `artifactId`, and a `version`.
- `scope` - Scope level for a project or dependency. Can be `compile`, `runtime`, `test`, and `system`.

- Maven parses `pom.xml` when most `mvn` commands are run. For example, when you run `mvn clean compile` for the first time on the above file, Maven goes out to the local, central, and remote repositories looking for a `groupId` of `junit` that has an `artifactId` of `junit` with a `version` of `4.8.2`. When it finds the correct dependency, it downloads it to the proper scope and manages it for you for subsequent runs of the project.

## Running Your First Maven Project
- At the top level of the your project (where `pom.xml` lives), run ``mvn clean compile``. You will see some output from downloading libraries the first time.
- Then, run `java com.5914maven.app1.App` to see `Hello World!` appear!!!
- You can also package the app into your desired format (we are using jar, defined in the POM) by running `mvn package`.
- And then run with `java -cp target/my-app-1.0-SNAPSHOT.jar com.5914maven.app1.App`

