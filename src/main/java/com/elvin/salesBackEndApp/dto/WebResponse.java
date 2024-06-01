package com.elvin.salesBackEndApp.dto;


import org.springframework.http.HttpStatusCode;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WebResponse<T> {

    private T data;
    private HttpStatusCode StatusCode;
    private String errMessage;
    
}
