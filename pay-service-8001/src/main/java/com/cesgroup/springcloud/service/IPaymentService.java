package com.cesgroup.springcloud.service;

import com.cesgroup.springcloud.entity.Payment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Duan.jw
 * @since 2020-03-16
 */
public interface IPaymentService extends IService<Payment> {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
