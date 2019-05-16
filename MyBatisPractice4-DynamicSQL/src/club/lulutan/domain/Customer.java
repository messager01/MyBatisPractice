package club.lulutan.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.core.config.Order;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private Integer cust_id;
    private String  cust_name;
    private String  cust_profession;
    private String  cust_phone;
    private String email;

}
