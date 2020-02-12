package com.khalidabdul.module.api.response.get.paymentsactive;

import lombok.Data;

@Data
public class GetPaymentsActiveResponseData {
    private String paymentMethod;
    private String paymentEngine;
    private String bankShortName;
    private String creditCard;
    private String installment;
}
