# 流程
1. 启动Dubbo
    > 在cfg目录下配置zoo.cfg
    > 
    > 启动bin目录下的zkServer.cmd

2. 启动Dubbo-admin监测端口
    >在源码中的properties文件中设置端口为7001，将源码打包
    > 
    >运行dubbo-admin-0.3.0.jar
3. 启动服务提供者，把服务注册到注册中心（zookeeper）
    ```java
    // zookeeper：服务注册与发现
    @Service  // dubbo的Service注解
    @Component
    public class TicketServiceImpl implements TicketService {
    
        @Override
        public String getTicket() {
            return "得到了Ticket";
        }
    }

    ```
4. 消费者去注册中心消费服务
    > 远程访问的方式：
    > 
    > 将interface的目录与服务提供者保持一致,配合@Reference注解
    > 
    > 或者通过pom坐标
    ```java
    @Service  // 放到spring的容器中。注意不要用dubbo的注解
    public class UserService {
    // 拿到provider提供的ticket，去注册中心拿到服务
    // 远程引用
    @Reference  // 定义路径相同的接口名。也可以用pom坐标
    TicketService ticketService;
    
        public void buyTicket() {
            String ticket = ticketService.getTicket();
            System.out.println("在注册中心拿到票：" + ticket);
        }
    }
    ```