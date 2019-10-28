package com.xunity.xunitycorporate.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer extends User {

    private Integer customerId;
    private String customerName;
    private String customerLastName;
    private String phone;
    private String dni;
    private String address;
    private String zipCode;
    private Integer parentId;
    private Integer status;
    private Integer customerType;
    private Integer marketId;

    public Customer(Integer userId, String username, String password, String loginStatus, LocalDate registerDate, Integer customerId, String customerName, String customerLastName, String phone, String dni, String address, String zipCode, Integer parentId, Integer status, Integer customerType, Integer marketId) {
        super(userId, username, password, loginStatus, registerDate);
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.phone = phone;
        this.dni = dni;
        this.address = address;
        this.zipCode = zipCode;
        this.parentId = parentId;
        this.status = status;
        this.customerType = customerType;
        this.marketId = marketId;
    }

}
