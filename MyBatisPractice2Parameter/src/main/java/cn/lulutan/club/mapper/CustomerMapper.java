package cn.lulutan.club.mapper;

import cn.lulutan.club.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CustomerMapper {
    Customer selectCustomerWithId(@Param("id") Integer id,@Param("name") String name);
        // 可以传一个map进去  方法的重载   map的key值是什么  sql语句就必须写什么
    Customer selectCustomerWithId(Map<String,Object> map);
     //  当传一个对象时   sql语句的参数就必须写该对象的字段
    Customer selectCustomerWithId(Customer customer);
}
