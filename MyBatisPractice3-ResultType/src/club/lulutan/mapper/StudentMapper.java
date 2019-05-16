package club.lulutan.mapper;

import club.lulutan.domain.Student;
import club.lulutan.domain.Teacher;

import java.util.List;

public interface StudentMapper {

    // 根据老师id  teacher_id  查询指定学生
    List<Student> getStudentByTeacherId(Integer teacher_id);

    // 添加新学生
    void insertStudent(Student student);
}
