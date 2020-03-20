package com.cesgroup.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cesgroup.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Duan.jw
 * @since 2020-03-16
 */
public interface PaymentMapper extends BaseMapper<Payment> {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
