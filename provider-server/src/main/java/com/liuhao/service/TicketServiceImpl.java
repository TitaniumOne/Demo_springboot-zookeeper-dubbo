package com.liuhao.service;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


// zookeeper：服务注册与发现
@Service  // dubbo的Service注解
@Component
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "得到了Ticket";
    }
}
