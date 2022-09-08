package cn.rainupup.service;

import cn.rainupup.dao.PaymentDao;
import cn.rainupup.emtities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Service
public class PaymentServiceImp implements PaymentService{
    @Resource
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(Long i) {
        return paymentDao.getById(i);

    }
}
