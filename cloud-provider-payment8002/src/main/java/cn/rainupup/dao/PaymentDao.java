package cn.rainupup.dao;

import cn.rainupup.emtities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getById(Long i);
}
