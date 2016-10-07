##GoEuro Assignment
The assignment is a command line program.
Based on the argument passed (CityName), it makes HTTP call to a remote server and writes the output in CSV format.
The output is also printed to the STDOUT.

##Structure
The program is a simple JAVA Application. 
I have resisted using Spring as in my opinion it would have been an overkill and bloated the executable for 
not good reason.

The solution is divided into multiple packages:

1. client - Contains classes related to HTTPClient. ThriftClient, ProtoBuf and other code will go here.
  * Would have used [Netflix's Hystrix](https://github.com/Netflix/hystrix) (for connection pooling), however for a command line program it is not very useful. 
2. exception - Custom exceptions are declared here.
3. mapper - I have used jackson for serialization and deserialization for json-pojo and csv-pojo
4. model - All data models go here, in separate packages for json and csv. It is also possible to create one model and build multiple views. Having multiple views on top of a datamodel will save a lot of code in a large project.
5. service - The interface LocationService gives an idea about the kind of APIs exposed by the service. All the version of LocationService will implement the interface. Each service should return an object with all potential common business logic enclosed.
  * It contains an abstract class "Service", which contains the common features of all service we will possibly integrate. In a micro service architecture, it becomes difficult to manage and debug and pin-point a fault. Basic sanity and hygiene practices will go here so that it is inherited by every service.
6. Configuration - Configuration management of the application.

##Execution

Since it a maven project
###BUILD
``mvn clean install``

###TEST
``mvn test``

###RUN
``java -jar goeuro.jar <CITY>``
``java -jar goeuro.jar Berlin``
