package com.xunity.xunitycorporate.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer{

    private Integer customerId;
    private String customerName;
    private String customerLastName;
    private String username;
    private String password;
    private String phone;
    private String dni;
    private String address;
    private Integer enrollerId;
    private Integer status;
    private Integer customerType;
    private Integer marketId;

}
