package cn.lulutan.club.domain;


import lombok.Data;

@Data
public class Customer {
    private Integer custId;
    private String custName;
    private String custProfession;
    private String custPhone;
    private String email;
}
