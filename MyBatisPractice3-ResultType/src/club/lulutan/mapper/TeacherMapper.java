package club.lulutan.mapper;

import club.lulutan.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    /*
    *   查询所有老师  把相应的学生也查出来
    * */

     List<Teacher> getAllTeachers();


    //根据id查老师
    Teacher getTeacherByIDd(Integer id);

        // 添加老师
    void insertTeacher(Teacher teacher);

    // 维护关系
    void updateRel(@Param("teacherId") Integer teacherId, @Param("studentId") Integer studentId);
}
