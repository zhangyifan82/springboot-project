package co.zhangyihaha.springbootproject.provider;

import co.zhangyihaha.springbootproject.dto.AccessTokenDTO;
import co.zhangyihaha.springbootproject.dto.User;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @BelongsProject: springboot-project
 * @BelongsPackage: co.zhangyihaha.springbootproject.provider
 * @Author: haha
 * @CreateTime: 2022-07-22  17:55
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class GitHubProvider {
public String getAccessToken(AccessTokenDTO accessTokenDTO){
    MediaType mediaType = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String s = string.split("&")[0].split("=")[1];
            return s;
        } catch (IOException e) {
           e.printStackTrace();
        }
        return null;
}
    public User getUser(String token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+token)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            User user = JSON.parseObject(string, User.class);
            return user;
        } catch (IOException e) {
        }
        return null;
    }
}
