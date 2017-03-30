+++
title = "Maven Tutorial"
date = 2017-03-28T08:03:00Z
blogimport = true
type = "post"
[author]
	name = "Tech Group 1"
+++

# What is Maven?
#### *TL;DR: Maven is a project management tool based on the Project Object Model (POM)*

Maven is a build automation tool built by Apache primarily used for Java projects.
It is used for:

-	building projects
- dependency management
- documentation/logging

This is all done through the POM, which is basically an XML config file.
The POM file contains information of project and configuration information for
maven to build the project such as

- dependencies
- build directory
- source directory
- test source directory
- plugin
- goals
- etc.

### Why Use Maven?

If you've ever created a Java project manually, you may already know the struggles
of dependency management. With Maven, the hardest parts are automated, including:

- Adding jars for each dependency
- Creating local directory structure
- Building and deploying the project

## Maven Repositories

Maven handles project dependencies by searching and linking them from several
repositories (stores for .jar files). There are three different types:

1. Local
2. Central
3. Remote

### Local Repositories

A local repository is located in your local system. It is created by the maven when you run any maven command. This is the location that maven looks for first when looking for dependencies your project needs.

### Central Repositories

A central repository is located on the internet and is the second stop maven searches for dependencies that you specified. It has been created by the Apache Maven community itself, so there's nothing you need to do to set it up. You can locate the repo at http://repo1.maven.org/maven2/.
The central repository contains a lot of common libraries that can be viewed at http://search.maven.org/#browse.

### Remote Repositories

A remote repository is located on the web as well, but is missing from the central repo. This is the third and last location maven will search for dependencies. Most libraries may be missing from the central repo, such as the JBoss library, so we need to define a remote repository in our project if we wish to use these dependencies.

Now that we know the basics of what maven is, how do we actually use it to define dependencies? The next part of this tutorial will take your through this process step by step.

# Installing Maven
If you have Java, you can get Maven with little trouble.

## Installation Procedure
1. Download release from [Apache Maven](https://maven.apache.org/download.cgi) website
2. Extract archive
3. Add the Maven `/bin` directory to PATH
4. Run `mvn -v`, and you should see something similar to this:

```bash
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T11:41:47-05:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_73, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.3", arch: "x86_64", family: "mac"
```

## IDE Integration
If you're using [IntelliJ](https://www.jetbrains.com/idea/), then Maven is already built in for you!

If you're using [Eclipse](https://eclipse.org/), you can install [M2Eclipse](https://eclipse.org/m2e/) to enable first-class support for Maven.

### Add Maven to New Project - IntelliJ

Maven can be added to a project on project creation. To create a
Maven project, go to **File > New > Project**. A dialog will appear.
Select **Maven** in the menu on the left, then select desired project
JDK. Click **Next**.
<img src="https://www.jetbrains.com/help/img/idea/2017.1/creat_maven_project.png"/>

If you want, specify properties for your Maven project. If your work is
not intended for public use, you can use placeholder strings for GroupId
and ArtifactId.
<img src="https://www.jetbrains.com/help/img/idea/2017.1/new_maven_proj.png"/>

Specify project name and location, and click **Finish**.
<img src="https://www.jetbrains.com/help/img/idea/2017.1/new_maven_proj_page2.png"/>

_Above images are from https://www.jetbrains.com/help/idea/2017.1/getting-started-with-maven.html_.

### Add Maven to Existing Project - IntelliJ

To convert an existing Java project to a Maven project, simply add a POM
file to the project root directory, then reload the project. IntelliJ
will detect the POM file and display a dialog that allows you to add
a Maven facet to the project.


# Your First Maven Project

In a fresh directory run:

```bash
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

You can see the resulting directory structure contains two source files `App.java` and `AppTest.java`. Opening them reveals that this is your standard Java Hello World! project.

In `AppTest.java` you see it imports JUnit libraries. You realize you don't have those downloaded, so you cannot just run `javac`. How would you go out and download them? Enter Maven and the other file you generated: `pom.xml`.

## The Project Object Model
Every Maven project requires a `pom.xml` file. This file contains everything Maven needs to know about your project. Here is an example of a POM file:

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
### POM elements
- `project` - Mandatory root element.
- `groupId` - Name of the group the project belongs to. Collection of artifacts.
- `artifactId` - Unit of individual project under a group.
- `packaging` - Format of how to package project when `mvn package` is run.
- `dependencies` - Root for list of dependencies.
- `dependency` - Individual unit of a project dependency. Needs a `groupId`, `artifactId`, and a `version`.
- `scope` - Scope level for a project or dependency. Can be `compile`, `runtime`, `test`, and `system`.

Maven parses `pom.xml` when most `mvn` commands are run. For example, when you run `mvn clean compile` for the first time on the above file, Maven goes out to the local, central, and remote repositories looking for a `groupId` of `junit` that has an `artifactId` of `junit` with a `version` of `4.8.2`. When it finds the correct dependency, it downloads it to the proper scope and manages it for you for subsequent runs of the project.

## Running Your First Maven Project
At the top level of the your project (where `pom.xml` lives), run ``mvn clean compile``. You will see some output from downloading libraries the first time. The first run will be slower than most consecutive runs due to downloading libraries for the first time.  
Run `java com.5914maven.app1.App` to see the message _"Hello World!"_ appear! 

You can also package the app into your desired format (we are using jar, defined in the POM) by running `mvn package`. You can run the newly-packaged app with `java -cp target/my-app-1.0-SNAPSHOT.jar com.5914maven.app1.App`.  
