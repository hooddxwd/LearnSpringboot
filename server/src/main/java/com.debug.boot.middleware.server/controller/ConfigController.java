package com.debug.boot.middleware.server.controller;

import com.debug.boot.middleware.api.response.BaseResponse;
import com.debug.boot.middleware.api.response.StatusCode;
import com.debug.boot.middleware.server.dto.WxAuthTokenDto;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 读取配置文件Controller
 */
@RestController
@RequestMapping("config")
public class ConfigController extends AbstractController{

    @Autowired
    private Environment env;

    //读取配置文件中变量的相关信息
    @RequestMapping(value = "info/v1", method = RequestMethod.GET)
    public BaseResponse getInfo(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        Map<String, Object> dataMap = Maps.newHashMap();
        try{
            String appId = env.getProperty("wx.auth.token.appId");
            String appSecrect = env.getProperty("wx.auth.token.appSecrect");
            String appRandom = env.getProperty("wx.auth.token.appRandom");
            Integer appVersion = env.getProperty("wx.auth.token.appVersion", Integer.class);
            dataMap.put("appId",appId);
            dataMap.put("appSecrect",appSecrect);
            dataMap.put("appRandom",appRandom);
            dataMap.put("appVersion",appVersion);
        }catch (Exception e){
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        response.setData(dataMap);
        return response;
    }

    @Value("${wx.auth.token.appId}")
    private String appId;
    @Value("${wx.auth.token.appSecrect}")
    private String appSecrect;
    @Value("${wx.auth.token.appRandom}")
    private String appRandom;
    @Value("${wx.auth.token.appVersion}")
    private Integer appVersion;


    //读取配置文件中变量的相关信息
    @RequestMapping(value = "info/v2", method = RequestMethod.GET)
    public BaseResponse getInfoV2(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        Map<String, Object> dataMap = Maps.newHashMap();
        try{
            dataMap.put("appId",appId);
            dataMap.put("appSecrect",appSecrect);
            dataMap.put("appRandom",appRandom);
            dataMap.put("appVersion",appVersion);
        }catch (Exception e){
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        response.setData(dataMap);
        return response;
    }

    @Autowired
    private WxAuthTokenDto tokenDto;

    //读取配置文件中变量的相关信息
    @RequestMapping(value = "info/v3", method = RequestMethod.GET)
    public BaseResponse getInfoV3(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        Map<String, Object> dataMap = Maps.newHashMap();
        try{
            dataMap.put("appId",tokenDto.getAppId());
            dataMap.put("appSecrect",tokenDto.getAppSecrect());
            dataMap.put("appRandom",tokenDto.getAppRandom());
        }catch (Exception e){
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        response.setData(dataMap);
        return response;
    }
}
