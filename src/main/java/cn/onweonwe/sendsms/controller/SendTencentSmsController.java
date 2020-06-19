package cn.onweonwe.sendsms.controller;

/**
 * @author wangShaoBin
 * @date 2020/6/18
 */

import cn.onweonwe.sendsms.service.TencentSendSmsService;
import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信发送接口
 * @author wangShaoBin
 * @date 2020/6/18
 */
@RestController
@RequestMapping(value = "/send/tencent")
@Slf4j
public class SendTencentSmsController {


    @Autowired
    TencentSendSmsService tencentSendSmsService;

    /**
     * 腾讯云短信平台
     * @param phonenumber
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/tencent/sms" , method = RequestMethod.POST)
    public String SendTencentSms(String phonenumber) {
        JSONObject jsonObject =new JSONObject();
        if (StringUtils.isNotBlank(phonenumber) ) {
           SendSmsResponse sendSmsResponse = tencentSendSmsService.sendTencentSms(phonenumber);
           log.info("返回结果的====================："+sendSmsResponse.toString());
            jsonObject.put("code","0");
            jsonObject.put("msg","短信推送成功！！！！");
            jsonObject.put("返回结果",SendSmsResponse.toJsonString(sendSmsResponse));
            return jsonObject.toJSONString();
        }
        jsonObject.put("code","1");
        jsonObject.put("msg","电话号码不能为空");
        return jsonObject.toJSONString();
    }

}
