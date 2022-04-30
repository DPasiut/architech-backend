# Run instruction </br>

## Run postgres database in docker - rquired Docker

### 1. Install docker on your PC 

[install docker](https://www.docker.com/get-started/)

### 2. Open terminal and enter command 

```docker run --name architechDb -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres``` 

![image](https://user-images.githubusercontent.com/48771917/166106717-a922a937-2bb9-4357-a5e7-aaa00a26ce75.png) 

#### enter command ```docker-ps``` for check if your postgres container is running 

![image](https://user-images.githubusercontent.com/48771917/166106742-f1d2f245-bf6c-4345-86f8-0144a920aa60.png) 

## Run server - required java 11 and Maven 
[java 11 install instruction](https://java.tutorials24x7.com/blog/how-to-install-java-11-on-windows)

### 3. Clon repository 

### 4. In project root directory run command 
```mvn clean install```

```mvn spring-boot:run```

