package cn.wfc.book.controller;

import cn.wfc.book.bean.JsonResult;
import cn.wfc.book.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/notebook")
@Controller
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonResult list(String userId) {
        List<Map<String, Object>> list =
                notebookService.listNotebooks(userId);
        return new JsonResult(list);
    }

    @RequestMapping("/page.do")
    @ResponseBody
    public JsonResult page(String userId,
                           Integer page) {
        List<Map<String, Object>> list =
                notebookService.listNotebooks(
                        userId, page);
        return new JsonResult(list);
    }

}







