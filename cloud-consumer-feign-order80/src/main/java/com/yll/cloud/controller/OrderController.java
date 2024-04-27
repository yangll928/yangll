package com.yll.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.yll.cloud.apis.PayFeignApi;
import com.yll.cloud.entities.PayDTO;
import com.yll.cloud.resp.ResultData;
import com.yll.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *
 * Author: yll
 * date: 2024/4/19
 */
@RestController
public class OrderController
{

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping(value = "/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO)
    {
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping(value = "/feign/pay/get/{id}")
    public ResultData getPayById(@PathVariable("id") Integer id)
    {
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = null;
        try
        {
            //OpenFeign 默认超时时间60秒
            System.out.println("调用开始-----: "+ DateUtil.now());
            resultData = payFeignApi.getById(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("调用结束-----: "+ DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return resultData;
    }

    @GetMapping(value = "/feign/pay/getAll")
    public ResultData<List<PayDTO>> getAll(){
        System.out.println("-------支付微服务远程调用，查全部");

        ResultData resultData = payFeignApi.getAll();

        return resultData;
    }

    @GetMapping(value = "/feign/pay/mylb")
    public String mylb(){
        System.out.println("-------mylb 服务信息");
        return payFeignApi.mylb();
    }

}
