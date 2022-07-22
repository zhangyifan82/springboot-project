package co.zhangyihaha.springbootproject.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springboot-project
 * @BelongsPackage: co.zhangyihaha.springbootproject.dto
 * @Author: haha
 * @CreateTime: 2022-07-22  19:24
 * @Description: 授权对象
 * @Version: 1.0
 */
@Data
public class AccessTokenDTO {
  private String client_id;
  private String client_secret;
  private String code;
  private String redirect_uri;
}
