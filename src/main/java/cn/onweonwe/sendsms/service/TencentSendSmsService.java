package cn.onweonwe.sendsms.service;

import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

/**
 * @author wangShaoBin
 * @date 2020/6/18
 */
public interface TencentSendSmsService {

    SendSmsResponse sendTencentSms(String phone);
}
