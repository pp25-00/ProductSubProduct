CRUD based project for product and subproduct 

1 product will have one to many mapping and subproduct will have many to 1 mapping 
2 create Spring Starter project > add pom.xml add starter dependencies > Create application.properties
3 Create multiple packages such as Controller, Service ,JPA, Entity
4 Create methods with response entity to display output on Postman and Swagger
5 Autowire all the layers to each other for smooth functioning
6 use swagger/postman for cheching out created rest api 
7 use @ restcontroller on ctrl layer @ service for service layer 
extend JPa repo to interface for direct database entries
8 @ requestmapping should be added to all the methods with path varaibles/request body based on the data to be inputed