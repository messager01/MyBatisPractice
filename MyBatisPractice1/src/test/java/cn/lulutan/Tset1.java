package cn.lulutan;

import cn.lulutan.domain.Customer;
import cn.lulutan.mapper.CustomerMapper;
import cn.lulutan.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Tset1 {

    @Test
    public void test() throws IOException {
        //  sqlsessionFactoryBuilder  加载配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");
        // 获取session工厂
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        // 获取会话
        SqlSession sqlSession = sessionFactory.openSession();

        // 执行sql
        Customer customer = sqlSession.selectOne("queryCustomerById", 1);

        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        List<Customer> queryAll = sqlSession.selectList("queryAll");
        for (Customer customer : queryAll) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    //模糊查询
    @Test
    public void test3(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        List<Object> list = sqlSession.selectList("queryCustomerByName","%李%");
        System.out.println(list);
        sqlSession.close();
    }



    // 添加客户
    @Test
    public void test4(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        Customer customer = new Customer();
        customer.setCust_name("后裔2");
        customer.setCust_phone("110");
        sqlSession.insert("insertCustomer",customer);
        sqlSession.commit();
        System.out.println(customer.getCust_id());
        sqlSession.close();
    }

    //更新客户
    @Test
    public void test5(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        Customer customer = sqlSession.selectOne("queryCustomerById",20);
        customer.setCust_name("超级大后裔");
        sqlSession.update("updateCustomer",customer);
        sqlSession.commit();
        sqlSession.selectOne("queryCustomerById",20);
    }


    @Test
    public void delete(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        Object customer = sqlSession.selectOne("queryCustomerById", 20);
        sqlSession.delete("deleteCustomer",customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);  //  动态创建实现类
        Customer customer = mapper.queryCustomerById(10);
        System.out.println(customer
        );


        List<Customer> customers = mapper.queryAll();
        for (Customer customer1 : customers) {
            System.out.println(customer1);
        }
        sqlSession.close();


    }
}
