package com.debug.boot.middleware.model.mapper;

import com.debug.boot.middleware.model.dto.UserOrderPageDto;
import com.debug.boot.middleware.model.entity.UserOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);

    UserOrder selectByOrderNo(@Param("orderNo") String orderNo);

    Integer deleteOrder(@Param("id") Integer id);

    List<UserOrder> pageSelectOrder(UserOrderPageDto dto);
}