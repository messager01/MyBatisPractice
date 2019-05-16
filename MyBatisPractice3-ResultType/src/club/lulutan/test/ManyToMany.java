package club.lulutan.test;

import club.lulutan.domain.Student;
import club.lulutan.domain.Teacher;
import club.lulutan.mapper.StudentMapper;
import club.lulutan.mapper.TeacherMapper;
import club.lulutan.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ManyToMany {


    /* 多对多查询  */
    @Test
    public void test1(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeachers = mapper.getAllTeachers();
        for (Teacher allTeacher : allTeachers) {
            System.out.println(allTeacher);
        }
    }



    /*  多对多分步查询   支持懒加载*/
    @Test
    public void test2(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);


        Teacher teacher = teacherMapper.getTeacherByIDd(1);
        System.out.println(teacher);
    }


    /*  多对多添加*/
    @Test
    public void test3(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Teacher teacher = new Teacher();
        teacher.setTeacher_name("新老师");

        Student student1 = new Student();
        student1.setStu_name("新学生1");

        Student student2 = new Student();
        student2.setStu_name("新学生2");

        studentMapper.insertStudent(student1);
        studentMapper.insertStudent(student2);

        teacherMapper.insertTeacher(teacher);
        teacherMapper.updateRel(teacher.getTeacher_id(),student1.getStu_id());
        teacherMapper.updateRel(teacher.getTeacher_id(),student2.getStu_id());

        sqlSession.commit();
        sqlSession.close();


    }

}
