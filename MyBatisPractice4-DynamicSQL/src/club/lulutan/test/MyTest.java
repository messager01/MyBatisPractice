package club.lulutan.test;


import club.lulutan.domain.Customer;
import club.lulutan.mapper.CustomerMapper;
import club.lulutan.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class MyTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customer = customerMapper.getCustomer("李白", "刺客");
        System.out.println(customer);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setCust_id(2);
        customer.setCust_name("超级李白");
        customer.setCust_profession("全能");
        customerMapper.updateCustomer(customer);
    }


    @Test
    public void test3(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
       /* List<Customer> customers = customerMapper.getCustomers(new Integer[] {2,3,4,5});*/
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        List<Customer> customers = customerMapper.getCustomers(integers);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }


    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customerWithId = customerMapper.getCustomerWithId(5);
        System.out.println(customerWithId);
    }
}
