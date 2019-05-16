package club.lulutan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    public static final SqlSessionFactory sessionFactory;
    static{
        //1.SqlSessionFactoryBuilder   加载配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //2.读取配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.获取session工厂
         sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }
    public static SqlSession openSession(){
        SqlSession sqlSession = sessionFactory.openSession();
        return sqlSession;
    }
}
