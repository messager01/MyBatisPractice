package club.lulutan.test;

import club.lulutan.domain.Customer;
import club.lulutan.domain.Order;
import club.lulutan.mapper.CustomerMapper;
import club.lulutan.mapper.OrderMapper;
import club.lulutan.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.tools.ant.taskdefs.condition.Or;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //Integer account = mapper.getAccount();
        //System.out.println(account);
       // System.out.println(mapper.getCustomerWithId(2));
       // System.out.println(mapper.getCustomerWithId(2));
       // System.out.println(mapper.getAllCustomer());
       // System.out.println(mapper.getCustomer(2));
    }


    // 多表连接
    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allOrders = mapper.getAllOrders();
        for (Order allOrder : allOrders) {
            System.out.println(allOrder);
        }
        sqlSession.close();
    }


    /// 分步查询
    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.getOrder(1);
        System.out.println(order.getOrder_name());
        System.out.println(order.getCustomer().getCust_name());
    }


    // 添加客户和订单
    @Test
    public void test3(){

        //  先添加客户  再添加订单
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setCust_name("新客户1");
        customer.setCust_phone("110");
        customer.setCust_profession("新职业1");
        customer.setEmail("@163");
        customerMapper.insertCustomer(customer);

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        order.setOrder_name("新订单1");
        order.setOrder_num("10005");
        //  维护关系
        order.setCustomer(customer);
        orderMapper.insertOrder(order);

        sqlSession.commit();
    }

    // 测试 一对多  即 某domain中的属性有一个list集合
    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allCustomers = mapper.getAllCustomers();
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer);
        }
        sqlSession.close();
    }


    @Test
    public void test5(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Customer customer = new Customer();
        customer.setCust_name("新客户");

        Order order1 = new Order();
        order1.setOrder_name("订单1111");

        Order order2 = new Order();
        order2.setOrder_name("订单222");

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        customerMapper.insertCustomer(customer);

        orderMapper.insertOrder(order1);
        orderMapper.insertOrder(order2);

        orderMapper.updateCust_id(order1.getOrder_id(),customer.getCust_id());
        orderMapper.updateCust_id(order2.getOrder_id(),customer.getCust_id());
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    //  根据id 删除客户
    public void test6(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        orderMapper.updateRelation(26);
        customerMapper.deleteCustomerById(26);
        sqlSession.commit();
        sqlSession.close();
    }
}
