package com.liuhao.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service  // 放到spring的容器中。注意不要用dubbo的注解
public class UserService {
    // 拿到provider提供的ticket，去注册中心拿到服务
    // 远程引用
    @Reference  // 定义路径相同的接口名。也可以用pom坐标
    TicketService ticketService;

    public void buyTicket() {
        String ticket = ticketService.getTicket();
        System.out.println("在注册中序拿到票：" + ticket);
    }
}
