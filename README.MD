## Springboot Demo

You need to have the following tools installed.

- java8 
- maven3
- docker  
- docker-compose

### Services
- user service
- notification service
- Fake SMTP Server

### Howto Run

Clone the project 
```
git clone https://github.com/sswguo/springboot-um.git
```

Build projects

```
mvn clean install
```

Run docker-compose to build images and start containers
```
docker-compose up --build
```

Check the started containers 

```
docker-compose ps
            Name                           Command                State           Ports
---------------------------------------------------------------------------------------------------------------------------
springboot-um_notification_1       java -jar notification-0.0 ...   Up      0.0.0.0:8087->8080/tcp
springboot-um_springboot-um_1      java -jar springboot-um-0. ...   Up      0.0.0.0:8080->8080/tcp
springboot-um_fake_mail_server_1   sh -c java $JAVA_OPTS -Dja ...   Up      0.0.0.0:5025->5025/tcp, 0.0.0.0:5080->5080/tcp, 0.0.0.0:5081->5081/tcp
```

### Rest Test
```
cd springboot-um
curl -d "@data/users_req.json" -H "Content-Type: application/json" -X POST http://localhost:8080/user/bulkregister
```

Check the users:
```
http://localhost:8080/user/all
```

And check the emails in the fake mail server
```
http://localhost:5080/
```
