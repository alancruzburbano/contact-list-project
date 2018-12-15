# contact-list-project
Sample project to read information from database or file

**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 

## Getting Started

To install server apllication, run the following commands:

```bash
git clone https://github.com/alancruzburbano/contact-list-project-server.git
cd contact-list-project-server
```
If you want to configure application properties edit the file application.properties in the path (/src/main/resources/application.properties) there you can set the incoming file properties and connection to database properties.

```ruby
    app.contact.list.file.headers=Y                 # validate if incoming file contains headers line
    app.contact.list.file.path=C:\\tmp\\people.csv  # put here the path of file in your machine
    app.contact.list.file.token.separator=,         # separator token configurable in csv
    
    spring.datasource.url=jdbc:oracle:thin:workbrain@//localhost:1521/EE.oracle.docker
    spring.datasource.username=workbrain
    spring.datasource.password=workbrain
    spring.datasource.driver.class-name=oracle.jdbc.driver.OracleDriver
```

 If you want to use a database conection is also necesary configure the table and columns names in the entity \src\main\java\com\kuenag\app\contacts\entity\Contact.java using your table name and columns (remember that this table must have an ID attribute to be used for JPA). Once configurations were done, save changes.

To run the serverapplication, just execute the following command:
 
```bash
./mvnw spring-boot:run
```

## Help

Please email alancruzburbano@gmail.com.
