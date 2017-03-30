+++
title = "Maven Tutorial"
date = 2017-03-28T08:03:00Z
blogimport = true 
type = "post"
[author]
	name = "Tech Group 1"
	uri = "https://plus.google.com/115818189328363361527"
+++
## Assumptions

This tutorial assumes you are using IntelliJ IDEA. Instructions on how
to get IDEA can be found on the JetBrains website, and is beyond the
scope of this tutorial. Since Maven comes with IDEA, this tutorial will
not cover Maven installation. For installation instructions, see
https://www.tutorialspoint.com/maven/maven_environment_setup.htm.

## Integrating Maven

Maven can be added to a project only on project creation. To create a
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

Above images are from
https://www.jetbrains.com/help/idea/2017.1/getting-started-with-maven.html.

To convert an existing Java project to a Maven project, simply add a POM
file to the project root directory, then reload the project. IntelliJ
will detect the POM file and display a dialog that allows you to add
a Maven facet to the project.