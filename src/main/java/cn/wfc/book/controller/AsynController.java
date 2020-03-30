package cn.wfc.book.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsynController {
    @GetMapping("/asyn")
    @Async
    public String asyn(){
        try {
            Thread.sleep(3000);
            System.out.println("睡了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "asyn";
    }
}
