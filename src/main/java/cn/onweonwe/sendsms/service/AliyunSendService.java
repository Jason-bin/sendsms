package cn.onweonwe.sendsms.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

/**
 * @author wangShaoBin
 * @date 2020/6/17
 */
public interface AliyunSendService {


    SendSmsResponse SendVerificationCode(String phone) throws ClientException;

    SendSmsResponse SendVerification(String phone, String name,String store) throws ClientException ;
}
