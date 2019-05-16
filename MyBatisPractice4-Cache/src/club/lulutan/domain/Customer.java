package club.lulutan.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.core.config.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class Customer implements Serializable {   //  二级缓存  pojo类实现序列化接口
    private Integer cust_id;
    private String  cust_name;
    private String  cust_profession;
    private String  cust_phone;
    private String email;
}
