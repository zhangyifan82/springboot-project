package co.zhangyihaha.springbootproject.controller;

import co.zhangyihaha.springbootproject.dto.AccessTokenDTO;
import co.zhangyihaha.springbootproject.dto.User;
import co.zhangyihaha.springbootproject.provider.GitHubProvider;
import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * @BelongsProject: springboot-project
 * @BelongsPackage: co.zhangyihaha.springbootproject.controller
 * @Author: haha
 * @CreateTime: 2022-07-22  19:13
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvider gitHubProvider;
    @GetMapping("/callback")
    public String authorization(@RequestParam(value = "code")String code,
                                @RequestParam(value = "state" )String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("e4c84cbb10d4ef79646d");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_secret("f1e588716691c65dc31255bca2dbcf14c46cd6a9");
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        User user = gitHubProvider.getUser(accessToken);
        System.out.println(user);
        return "index";
    }

}
