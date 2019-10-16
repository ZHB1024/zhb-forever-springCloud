package com.forever.zhb.server.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forever.zhb.ms.api.IMsgApi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController()
@RequestMapping("/server")
public class MsgController {
    
    @Autowired
    private IMsgApi msgApi;
    
    @GetMapping("/sendmail")
    public void sendMail() {
        String result = msgApi.sendMail("开会通知");
        System.out.println(result);
    }

}
