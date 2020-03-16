package com.cesgroup.springcloud.service.impl;

import com.cesgroup.springcloud.entity.Payment;
import com.cesgroup.springcloud.mapper.PaymentMapper;
import com.cesgroup.springcloud.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Duan.jw
 * @since 2020-03-16
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {

}
