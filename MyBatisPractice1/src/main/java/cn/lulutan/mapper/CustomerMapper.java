package cn.lulutan.mapper;

import cn.lulutan.domain.Customer;

import java.util.List;

public interface CustomerMapper {

    Customer queryCustomerById(Integer id);

    List<Customer> queryAll();

    void insertCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
