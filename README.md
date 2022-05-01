# ArchitechBackend

## Run postgres database in docker - rquired Docker

#### IMPORTANT 
If port 5432 is already in use, just kill that proccess or change proxy in step 1, e.g.  ```-p free_port:5432``` but remember to change properties in ```application.properties```  -> ```architech.exercise\src\main\resources```
 ```spring.datasource.url=jdbc:postgresql://localhost:free_port/postgres```


### 1. Open terminal and enter command 

```docker run --name architechDb -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres```

## Run server - required Java 11 and Maven 

### IMPORTANT 

Server in default is running on port ```8080``` if port is already in use, kill that proccess or add ```server.port=free_port``` properties  in ```application.properties```  -> ```architech.exercise\src\main\resources```. But then you have also change properties in frontend application ```ArchitechFrontend```. In file ```proxy.config.json``` change to ```"target":``` to ``` "http://localhost:free_port",```

### 1. Clon repository 

### 2. In project root directory run command 
```mvn clean install```

```mvn spring-boot:run```

