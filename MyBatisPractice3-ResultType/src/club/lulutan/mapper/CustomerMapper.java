package club.lulutan.mapper;


import club.lulutan.domain.Customer;

import java.util.List;

public interface CustomerMapper {

     Customer getCustomerWithId(Integer id);

     void insertCustomer(Customer customer);

     List<Customer> getAllCustomers();

     // 根据id删除客户
     void deleteCustomerById(Integer id);

}
