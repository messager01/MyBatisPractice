package club.lulutan.test;

import club.lulutan.domain.Customer;
import club.lulutan.mapper.CustomerMapper;
import club.lulutan.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class FirstCache {


    /*
    *  一级缓存默认是sqlsession级别的   默认是打开的
    * */
    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerWithId(2);
        System.out.println(customer);

        // 插入操作     增删改   会使缓存失效
      /*  Customer customer1 = new Customer();
        customer1.setCust_name("史沛鑫");
        mapper.insertCustomer(customer1);*/

        //   手动清空缓存  也会使缓存失效
        sqlSession.clearCache();

        // 不在同一个sqlsession当中   也会失效！！！

        Customer customer2 = mapper.getCustomerWithId(2);
        System.out.println(customer2);

        System.out.println(customer == customer2);
    }
}
