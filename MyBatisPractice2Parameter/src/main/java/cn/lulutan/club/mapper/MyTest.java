package cn.lulutan.club.mapper;

import cn.lulutan.club.domain.Customer;
import org.apache.ibatis.annotations.Param;


public interface MyTest {

    public void insertCustomer(@Param("customer") Customer customer);

    public Customer getCustomer(@Param("id") Integer id);

}
