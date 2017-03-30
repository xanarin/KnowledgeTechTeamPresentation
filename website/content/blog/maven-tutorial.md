+++
title = "Maven Tutorial"
date = 2017-03-28T08:03:00Z
blogimport = true
type = "post"
[author]
	name = "Tech Group 1"
	uri = "https://plus.google.com/115818189328363361527"
+++
# Maven Introduction
## The What and the Why
### What is Maven?
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
