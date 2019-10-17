package com.forever.zhb.ms.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="http://localhost:8012",name = "MsApi")
public interface MsApi {

    @GetMapping("/msg/sendmail")
    String sendMail(@RequestParam("content") String content);
}
