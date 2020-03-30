package com.debug.boot.middleware.server.service;

import com.debug.boot.middleware.model.entity.UserOrder;
import com.debug.boot.middleware.model.mapper.UserOrderMapper;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户订单Service
 */
@Service
public class UserOrderService {
    private static final Logger log = LoggerFactory.getLogger(UserOrderService.class);

    @Autowired
    private UserOrderMapper userOrderMapper;

    //获取用户订单详情
    public UserOrder getInfo(final String orderNo) throws Exception{
        if(StringUtils.isNotBlank(orderNo)){
            return userOrderMapper.selectByOrderNo(orderNo);
        }
        return null;
    }
}
