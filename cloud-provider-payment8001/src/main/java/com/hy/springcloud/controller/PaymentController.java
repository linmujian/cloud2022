package com.hy.springcloud.controller;

import com.hy.springcloud.entities.CommonResult;
import com.hy.springcloud.entities.Payment;
import com.hy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入的结果："+result);
        if (result>0){
            return new CommonResult(200,"添加数据成功",payment);
        }else{
            return new CommonResult(444,"添加数据失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询的结果："+payment);
        log.info("******查询的结果："+payment);
        if (payment!=null){
            return new CommonResult(200,"查询数据成功",payment);
        }else{
            return new CommonResult(444,"查询数据失败",null);
        }
    }

}
