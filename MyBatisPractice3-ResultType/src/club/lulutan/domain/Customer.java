package club.lulutan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.tools.ant.taskdefs.condition.Or;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class Customer {
    private Integer cust_id;
    private String  cust_name;
    private String  cust_profession;
    private String  cust_phone;
    private String email;
    private List<Order> orders = new ArrayList<>();

}
