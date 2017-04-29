# Simple address book web application

## Frameworks, Libraries and Tools

* Spring Framework
* Hibernate
* JavaServer Faces
* Primefaces UI Framework
* Maven

___

### Installations

Install the required packages.

```bash
$ sudo apt-get update
$ sudo apt-get install git mysql-client mysql-server maven
```

___

### Cloning of files

Copy this repository with the git version control system to get a copy of the project

```bash
$ git clone https://github.com/erdemsahin/AddressBook.git
$ cd AddressBook/
```
___

### Database configuration

Run the `database.sql` script to create the database, tables, and sample data. Do not forget to enter your own MySQL username in the username!

```bash
$ mysql -u username -p < database.sql
```
___

### Database connection settings

To connect to the database, set the `$PROJECT_DIR/main/resources/application.properties` file according to your database user name and password.

```properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/addressbook
jdbc.username=root
jdbc.password=123456

hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
___

### Setting up Tomcat user

Add the following user information to your Tomcat server's `$TOMCAT_DIR/conf/tomcat-users.xml` file. If you do not have a tomcat server, you can download [it here](https://tomcat.apache.org/download-80.cgi).


```xml
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<role rolename="manager-script"/>
<role rolename="manager-jmx"/>
<role rolename="manager-status"/>
<role rolename="admin-gui"/>
<role rolename="admin-script"/>

<user username="admin" password="password" 
  roles="standard,manager,admin,manager-gui,manager-script,tomcat" />
```
___

### Running Tomcat server

After configuring the configuration files, you need to run the `startup.sh` script to run the tomcat server.

```bash
$ cd $TOMCAT_DIR/bin
$ ./startup.sh
```
___

### Deploying the project to the server

You only need to enter the `mvn tomcat7:deploy` command to deploy the project. If a problem occurs, run the `mvn clean` command and then run the `mvn tomcat7:redeploy` command to redeploy the project.

```bash
$ mvn clean
$ mvn tomcat7:deploy
$ mvn tomcat7:redeploy
```
___

### Completed

The AddressBook application is now running. Open the `http://localhost:8080/AddressBook` page from your web browser. You will have access to the persons list.
