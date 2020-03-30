package com.debug.boot.middleware.server.service;

import com.debug.boot.middleware.server.dto.BaseDto;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    private static final Logger log = LoggerFactory.getLogger(BaseService.class);

    //获取对象列表
    public List<BaseDto> getList() throws Exception{
        List<BaseDto> dtos = Lists.newLinkedList();
        dtos.add(new BaseDto(1,"Java全程实战一"));
        dtos.add(new BaseDto(2,"Java全程实战二"));
        return dtos;
    }
}
