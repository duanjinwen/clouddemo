package com.cesgroup.springcloud.controller;

import com.cesgroup.springcloud.entity.Payment;
import com.cesgroup.springcloud.entity.Result;
import com.cesgroup.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Duan.jw
 * @create: 2020/3/18 14:30
 **/
@RestController
@Slf4j
public class PamentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping(value = "/payment/create")
    public Result create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new Result(200, "插入数据成功", result);
        } else {
            return new Result(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果：" + payment);
        if (payment != null) {
            return new Result(200, "查询成功", payment);
        } else {
            return new Result(444, "没有对应记录,查询ID：" + id, null);
        }
    }
}
