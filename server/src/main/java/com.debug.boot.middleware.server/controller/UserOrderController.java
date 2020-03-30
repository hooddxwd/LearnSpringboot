package com.debug.boot.middleware.server.controller;

import com.debug.boot.middleware.api.response.BaseResponse;
import com.debug.boot.middleware.api.response.StatusCode;
import com.debug.boot.middleware.server.service.UserOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 用户提交订单Controller
 */
@Controller
@RequestMapping("user/order")
public class UserOrderController extends AbstractController{

    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping(value = "info/page", method = RequestMethod.GET)
    public String pageInfo(@RequestParam String orderNo, ModelMap modelMap){
        modelMap.put("orderNo", orderNo);
        return "userOrder";
    }

    //订单详情
    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse info(@RequestParam String orderNo){
        if(StringUtils.isBlank(orderNo)){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try{
            response.setData(userOrderService.getInfo(orderNo));
        }catch (Exception e){
            log.error("用户提交订单controller-订单详情-发生异常：orderNo={}", orderNo, e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }
}
