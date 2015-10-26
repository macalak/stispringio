# STI Spring workshop sessions
## Environment preparation
1. First use the 'GIT' client to checkout this repository. If you are not familiar with GIT, just download the repository [ZIP](https://github.com/macalak/stispringio/archive/master.zip) and unzip it on your disk.
2. You need the JDK distribution. Download the latest one and install it from the [Oracle site](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Do not forget to set '*JAVA_HOME*' environment variable pointing to JDK installation folder.
3. You can use any text editor to edit source code, but the Java IDE is better option. If you do not have one yet, download and install the [STS](https://spring.io/tools/sts/all) for instance.
4. Take the Tomcat AS distribution with integrated Derby database from this repository 'server/apache-tomcat-8.0.27.zip'. Unzip it into 'server/runtime' folder.
## Generate Eclipse project files and import projects into STS
Go to project root folder ('projects/spring-mvc-01' for instance), and execute 'gradlew eclipse' command. It generates Eclipse project files for you. Then open the STS, and use the 'Import existing project into workspace...' feature. Do this for all available projects. First execution will download and install the Gradle build tool. You need to be connected to the internet.

  
