package cn.lulutan.club;

import cn.lulutan.club.domain.Customer;
import cn.lulutan.club.mapper.CustomerMapper;
import cn.lulutan.club.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class MyTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        //Customer customer = mapper.selectCustomerWithId(5,"亚索");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","鲁班");
        //Customer customer = mapper.selectCustomerWithId(map);

        Customer customer = new Customer();
        customer.setCustId(1);
        customer.setCustName("鲁班");
        Customer customer1 = mapper.selectCustomerWithId(customer);
        System.out.println(customer1);
        sqlSession.close();
    }
}
