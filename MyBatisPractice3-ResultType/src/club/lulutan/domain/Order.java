package club.lulutan.domain;

import lombok.Data;

@Data
public class Order {
    private Integer order_id;
    private String order_name;
    private String order_num;
    private Customer customer;
}
