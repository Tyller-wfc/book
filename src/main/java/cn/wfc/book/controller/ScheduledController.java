package cn.wfc.book.controller;

import cn.wfc.book.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduledController {
    @Autowired
    private ScheduledService service;
    @GetMapping("/scheduled")
    public String doScheduled(){
        service.reportCurrentTime();
        return "看控制台";
    }
}
