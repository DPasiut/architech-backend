# ArchitechBackend

## Run postgres database in docker - rquired Docker

#### IMPORTANT 
If port 5432 is already in use, just kill that proccess or change proxy in step 2, e.g.  ```-p free_port:5432``` but remember to change properties in ```application.properties```  -> ```architech.exercise\src\main\resources```
 ```spring.datasource.url=jdbc:postgresql://localhost:free_port/postgres```

### 1. Install docker on your PC 

[install docker](https://www.docker.com/get-started/)

### 2. Open terminal and enter command 

```docker run --name architechDb -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres``` 

![image](https://user-images.githubusercontent.com/48771917/166106717-a922a937-2bb9-4357-a5e7-aaa00a26ce75.png) 


#### enter command ```docker-ps``` for check if your postgres container is running 

![image](https://user-images.githubusercontent.com/48771917/166106742-f1d2f245-bf6c-4345-86f8-0144a920aa60.png) 

## Run server - required java 11 and Maven 

### IMPORTANT 

Server in default is running on port ```8080``` if port is already in use, kill that proccess or add ```server.port=free_port``` properties  in ```application.properties```  -> ```architech.exercise\src\main\resources```. But then you have also change properties in frontend application ```ArchitechFrontend```. In file ```proxy.config.json``` change to ```"target": "http://localhost:free_port",```

[java 11 install instruction](https://java.tutorials24x7.com/blog/how-to-install-java-11-on-windows)

### 1. Clon repository 

### 2. In project root directory run command 
```mvn clean install```

```mvn spring-boot:run```

