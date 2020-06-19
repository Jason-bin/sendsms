package cn.onweonwe.sendsms.controller;



import cn.onweonwe.sendsms.service.AliyunSendService;

import cn.onweonwe.sendsms.service.TencentSendSmsService;
import com.alibaba.fastjson.JSONObject;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信发送接口
 * @author wangShaoBin
 * @date 2020/6/17
 */
@RestController
@RequestMapping(value = "/send")
public class SendSmsController {

    @Autowired
    private AliyunSendService aliyunSendService;


    /**
     * 阿里云短信验证码
     * @param phonenumber
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/alisms/code" , method = RequestMethod.POST)
    public String SendVerificationCode(String phonenumber) throws ClientException {
        JSONObject jsonObject =new JSONObject();
        if (StringUtils.isNotBlank(phonenumber) ) {
//                String templateparam = SendSmsUtil.getTemplateparam(reName);
            SendSmsResponse sendSmsResponse = aliyunSendService.SendVerificationCode(phonenumber);
            if (sendSmsResponse.getCode()!=null&&sendSmsResponse.getCode().equals("OK")){

                jsonObject.put("code","0");
                jsonObject.put("msg","短信验证码发送成功！！！");
                return jsonObject.toJSONString();
            }

            jsonObject.put("code","1");
            jsonObject.put("msg","短信验证码发送失败！！！");
            return jsonObject.toJSONString();
        }
        jsonObject.put("code","1");
        jsonObject.put("msg","电话号码不能为空");
        return jsonObject.toJSONString();
    }

    /**
     * 阿里云短信通知
     * @param phonenumber
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/alisms" , method = RequestMethod.POST)
    public String SendVerification(String phonenumber,String name,String store) throws ClientException {
        JSONObject jsonObject =new JSONObject();
        if (StringUtils.isNotBlank(phonenumber) ) {
//                String templateparam = SendSmsUtil.getTemplateparam(reName);
            SendSmsResponse sendSmsResponse = aliyunSendService.SendVerification(phonenumber,name,store);
            if (sendSmsResponse.getCode()!=null&&sendSmsResponse.getCode().equals("OK")){

                jsonObject.put("code","0");
                jsonObject.put("msg","短信通知发送成功！！！");
                return jsonObject.toJSONString();
            }

            jsonObject.put("code","1");
            jsonObject.put("msg","短信通知发送失败！！！");
            return jsonObject.toJSONString();
        }
        jsonObject.put("code","1");
        jsonObject.put("msg","电话号码不能为空");
        return jsonObject.toJSONString();
    }

}
