package club.lulutan.mapper;


import club.lulutan.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    //  根据客户名称和职业来查询
    List<Customer> getCustomer(@Param("name") String name, @Param("profession") String profession);


    //更新客户
    void updateCustomer(Customer customer);

    //  根据id查询指定的客户  多个客户

    List<Customer> getCustomers(List<Integer> ids);

    Customer getCustomerWithId(@Param("id") Integer id);

}
