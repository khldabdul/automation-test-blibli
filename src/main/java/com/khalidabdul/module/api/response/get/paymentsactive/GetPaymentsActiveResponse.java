package com.khalidabdul.module.api.response.get.paymentsactive;

import lombok.Data;

@Data
public class GetPaymentsActiveResponse {
    private String code;
    private String status;
    private GetPaymentsActiveResponseData[] data;
}
