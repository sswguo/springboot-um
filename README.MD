## Springboot Demo

### User Service


### Notification Service


### Howto Run

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
url -d "@/tmp/workdir/springboot-um/data/users_req.json" -H "Content-Type: application/json" -X POST http://localhost:8080/user/bulkregister
```

