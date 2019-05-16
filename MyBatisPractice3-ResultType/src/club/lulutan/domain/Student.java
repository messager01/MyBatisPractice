package club.lulutan.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private Integer stu_id;
    private String stu_name;
    private List<Teacher> teachers = new ArrayList<>();
}
