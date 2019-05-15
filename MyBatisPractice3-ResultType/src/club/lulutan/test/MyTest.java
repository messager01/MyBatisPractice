package club.lulutan.test;

import club.lulutan.domain.Order;
import club.lulutan.mapper.CustomerMapper;
import club.lulutan.mapper.OrderMapper;
import club.lulutan.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
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
}
