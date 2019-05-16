package club.lulutan.domain;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Teacher {
    private Integer teacher_id;
    private String teacher_name;
    private List<Student> students = new ArrayList<>();
}
