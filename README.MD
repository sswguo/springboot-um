## Springboot Demo

You need to have the following tools installed.

- java8 
- maven3
- docker  
- docker-compose

### Services
- user service
- notification service

### Howto Run

Build projects

```
cd users
./mvnw clean install
```

```
cd notification
./mvnw clean install
```

Run docker-compose to build images and start containers
```
docker-compose up --build
```

Check the started containers 

```
docker-compose ps
            Name                           Command               State           Ports
-----------------------------------------------------------------------------------------------
springboot-um_notification_1    java -jar notification-0.0 ...   Up      0.0.0.0:8087->8080/tcp
springboot-um_springboot-um_1   java -jar springboot-um-0. ...   Up      0.0.0.0:8080->8080/tcp
```

### Rest Test
```
curl -d "@/tmp/workdir/springboot-um/data/users_req.json" -H "Content-Type: application/json" -X POST http://localhost:8080/user/bulkregister
```

