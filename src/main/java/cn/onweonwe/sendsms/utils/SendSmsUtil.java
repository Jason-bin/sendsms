package cn.onweonwe.sendsms.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;


/**
 * @author wangShaoBin
 * @date 2020/6/17
 */
public class SendSmsUtil {

    public static void sendSms(String phonenumber , String signname , String templatecode , String templateparam, String accessKeyId, String accessSecret) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        /** 电话号码 */
        request.putQueryParameter("PhoneNumbers", phonenumber);
        /** 短信签名名称 */
        request.putQueryParameter("SignName", signname);
        /** 短信模板ID */
        request.putQueryParameter("TemplateCode", templatecode);
        /** 短信模板变量对应的实际值，JSON格式 */
        request.putQueryParameter("TemplateParam", templateparam);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据name获取templateparam
     * @param name
     * @return
     */
    public static String getTemplateparam(String name) {

        return "{\"name\":\" "+ name +"\"}";
    }

}

