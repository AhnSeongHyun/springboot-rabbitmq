# springboot-rabbitmq test

### rabbitmq

```shell script
> docker pull rabbitmq:managemnet
> docker run -d --name rabbitmq -p 5672:5672 -p 8080:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:management
```

- exchange : `rb-exchange`
- routingkey - queue : 
    - `rb-user-drop` - `rb-user-drop-queue`
    - `rb-transfer` - `rb-transfer`
    
 