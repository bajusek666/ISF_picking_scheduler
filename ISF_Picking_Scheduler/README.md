# ISF Picking Scheduler

## Building sources

Run: `mvn clean package` to build sources and prepare production ready *.jar file.

## Running the Application

To run the application, we need to pass directories to Json files with orders and store configuration as arguments.

The *.jar file is located in "target" folder.
Change directory to "target".
Run : `java -jar .\OcadoTechnology-1.0-SNAPSHOT-jar-with-dependencies.jar {store.json file dir} {orders.json file dir}`