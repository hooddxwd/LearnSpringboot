package com.debug.boot.middleware.server.controller;

import com.debug.boot.middleware.api.response.BaseResponse;
import com.debug.boot.middleware.api.response.StatusCode;
import com.debug.boot.middleware.server.dto.BaseDto;
import com.debug.boot.middleware.server.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 *  基本功能Controller
 */
@RestController
@RequestMapping("base")
public class BaseController extends AbstractController{

    @Autowired
    private BaseService baseService;

    //基本信息请求方法
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public BaseResponse info(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try{
            response.setData("技术栈与分布式中间件实战系列");
        }catch (Exception e){
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    //列表-请求方法
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public BaseResponse list(){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try{
            List<BaseDto> list = baseService.getList();
            log.info("--列表-请求方法-得到的业务数据：{} ", list);
            response.setData(list);
        }catch (Exception e){
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }
}
