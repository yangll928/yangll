package com.yll.cloud.serivce;

import com.yll.cloud.entities.Order;

/**
 * @auther zzyy
 * @create 2024-01-06 15:39
 */
public interface OrderService
{
    /**
     * 创建订单
     */
    void create(Order order);
}
