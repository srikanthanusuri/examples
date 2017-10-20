# Grails Rest Project Example

### Initialize the database
You will need to create a database prior to running the application. Please run the file `src/test/db/init.sql` in your MySQL database as a `root` user.

```
$> mysql -h localhost -u root -p<your root password> < <path to the workspace>/src/test/db/init.sql
```

### Run the application
To run the application, open the command prompt and execute the following command.

```
$> gradlew clean bootRun
```

If the application has successfully started up, you should see a message in the command prompt as follows.

```
Grails application running at http://localhost:8080 in environment: development
```

Now you should be able to open your browser and navigate to the url posted above.

### Testing
The following REST endpoints are available with the application.

```/user```

### References
[Guide](http://guides.grails.org/rest-hibernate/guide/index.html) to generate REST ready project in Grails.