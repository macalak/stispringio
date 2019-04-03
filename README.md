# STI Spring workshop sessions
## Environment preparation
1. First use the *GIT* client to checkout this repository. If you are not familiar with *GIT*, just download the repository [ZIP](https://github.com/macalak/stispringio/archive/master.zip) and unzip it on your disk.
2. You need the JDK distribution. Download the latest one and install it from the [Oracle site](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Do not forget to set *JAVA_HOME* environment variable pointing to JDK installation folder.
3. You can use any text editor to edit source code, but the Java IDE is better option. If you do not have one yet, download and install the [STS](https://spring.io/tools/sts/all) for instance.
4. Take the Tomcat AS distribution with integrated Derby database from this repository [server/apache-tomcat-9.0.17.zip](https://raw.githubusercontent.com/macalak/stispringio/master/server/apache-tomcat-9.0.17.zip). Unzip it into *server/runtime* folder.
Alternatively use the Pivotal server which comes with STS distribution. Download and install [Derby](http://tux.rainside.sk/apache//db/derby/db-derby-10.14.2.0/db-derby-10.14.2.0-bin.zip) distribution
and start the Derby server `startNetworkServer.bat`. 
5. For examples which require SQL database, the JDBC datasource must be configured in Tomcat AS context.xml, or application META-INF/context.xml.
```
<Resource name="jdbc/LibraryMaster"
              type="javax.sql.DataSource"  auth="Container"
              description="Derby database for LibraryMaster"
			  global="jdbc/LibraryMaster"
              maxActive="20" maxIdle="10" maxWait="10000"
              username="library" password="library" 
              driverClassName="org.apache.derby.jdbc.ClientDriver"
              url="jdbc:derby://localhost:1527/LibraryMasterDB"/>
```



## How to imort examples into STS
- Generate Eclipse project files and import projects into STS. Go to project root folder (*projects/m01p01-container-solution* for instance), and execute *gradlew eclipse* command. It generates Eclipse project files for you. Then open the STS, and use the *Import existing project into workspace...* feature. Do this for all available projects. First execution will download and install the Gradle build tool. You need to be connected to the internet.
- Alternatively, you can import examples as *Existing Gradle Project* into STS

  
