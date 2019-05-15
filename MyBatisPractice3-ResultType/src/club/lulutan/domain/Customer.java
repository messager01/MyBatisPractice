package club.lulutan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Customer {
    private Integer cust_id;
    private String  cust_name;
    private String  cust_profession;
    private String  cust_phone;
    private String email;

}
