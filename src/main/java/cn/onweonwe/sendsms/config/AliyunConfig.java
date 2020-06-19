package cn.onweonwe.sendsms.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 基础配置类
 *
 * @author wangShaoBin
 * @date 2020/6/17
 */
@Data
@Component
@ConfigurationProperties(prefix = "alibaba")
public class AliyunConfig {

    /**
     * 阿里短信平台的签名
     */
    @Value("${alibaba.signname}")
    private String signname;

    /**
     * 阿里短信平台的模板code
     */
    @Value("${alibaba.templatecode}")
    private String templatecode;

    /**
     * 阿里短信平台的AK
     */
    @Value("${alibaba.accessKeyId}")
    private String accessKeyId;

    /**
     * 阿里短信平台的AK秘钥
     */
    @Value("{alibaba.accesssSecret}")
    private String accessSecret;



}
