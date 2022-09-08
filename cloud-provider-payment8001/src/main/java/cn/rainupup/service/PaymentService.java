package cn.rainupup.service;

import cn.rainupup.emtities.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    public int create(Payment payment);
    public Payment getById(Long i);
}
