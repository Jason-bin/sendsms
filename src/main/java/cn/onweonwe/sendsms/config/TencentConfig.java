package cn.onweonwe.sendsms.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangShaoBin
 * @date 2020/6/18
 */
@Data
@Component
@ConfigurationProperties(prefix = "tencent")
public class TencentConfig {
    /**
     * 腾讯短信平台的签名
     */
    @Value("${tencent.signname}")
    private String signname;

    /**
     * 腾讯短信平台的模板code
     */
    @Value("${tencent.templatecode}")
    private String templatecode;

    /**
     * 腾讯短信平台的AK
     */
    @Value("${tencent.smsSdkAppId}")
    private String smsSdkAppId;

    /**
     *  腾讯云账户密钥对 secretId 和 secretKey
     */

    @Value("${tencent.secretId}")
    private String secretId;

    @Value("${tencent.secretKey}")
    private String secretKey;
}
