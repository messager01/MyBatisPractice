package cn.lulutan.domain;


import lombok.Data;

@Data
public class Customer {
    private Integer cust_id;
    private String cust_name;
    private String cust_profession;
    private String cust_phone;
    private String email;
}
