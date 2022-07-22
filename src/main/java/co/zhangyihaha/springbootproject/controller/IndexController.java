package co.zhangyihaha.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @BelongsProject: springboot-project
 * @BelongsPackage: co.zhangyihaha.springbootproject.controller
 * @Author: haha
 * @CreateTime: 2022-07-20  11:42
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String indexPageName(){
         return "index";
    }
}
