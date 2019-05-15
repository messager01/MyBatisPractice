package cn.lulutan.dao;

import cn.lulutan.domain.Customer;

import java.util.List;

public interface CustomerDao {

    Customer getCustomerWithId(Integer id);

    List<Customer> getAllCustomer();

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);
}
