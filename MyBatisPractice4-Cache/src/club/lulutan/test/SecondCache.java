package club.lulutan.test;


import club.lulutan.domain.Customer;
import club.lulutan.mapper.CustomerMapper;
import club.lulutan.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
*
*           二级缓存  是一个mapper级别的缓存  也可以说是一个namespace的缓存
*           不同的namespace 查出的数据   会放到自己对应的缓存当中
*           默认也是打开的
*           如果会话关闭  一级缓存的数据 会放到自己的对应的缓存当中
*
* */
public class SecondCache {

    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerWithId(2);
        System.out.println(customer);
        sqlSession.close();


        /*
        *    注意：只有会话关闭时  即sqlsession关闭
        *    才会把一级缓存放进到二级缓存的当中
        * */
        SqlSession sqlSession2 = MyBatisUtils.openSession();
        CustomerMapper mapper2 = sqlSession2.getMapper(CustomerMapper.class);
        Customer customer2 = mapper2.getCustomerWithId(2);
        System.out.println(customer2);
        sqlSession2.close();

        /*
        *
        *    缓存的使用顺序
        *
        *    先使用二级缓存   再使用一级缓存
        *
        * */

    }
}
