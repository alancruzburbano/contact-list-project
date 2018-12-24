# contact-list-project
Sample project to read information from database or file

**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 

## Getting Started

To install server apllication, run the following commands:

```bash
git clone https://github.com/alancruzburbano/contact-list-project-server.git
cd contact-list-project-server
```
In application.properties you can find some important configurations over the CSV file to read and the database connection. By default the application use a H2 database, but, if you want to use another database, you need edit the group of properties spring.datasource with the  requiered values, in fact, the application already has ojdbc7 driver to connect with a Oracle database.

```ruby
    app.contact.list.file.headers=Y                 # validate if incoming file contains headers line
    app.contact.list.file.path=C:\\tmp\\people.csv  # put here the path of file in your machine
    app.contact.list.file.token.separator=,         # separator token configurable in csv
    
    # H2 database settings
    #spring.h2.console.enabled=true
    #spring.datasource.url=jdbc:h2:mem:testdb
    #spring.datasource.driverClassName=org.h2.Driver
    #spring.datasource.username=sa
    #spring.datasource.password=
    #spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

To run the server application, just execute the following command:
 
```bash
./gradlew bootRun
```

## Help

Please email alancruzburbano@gmail.com.
