package com.example.junitTest.controller;

import com.example.junitTest.dto.SeamFix.BvnRequest;
import com.example.junitTest.dto.SeamFix.BvnResponse;
import com.example.junitTest.misc.Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class BvnController {

    @PostMapping(value="/bv-service/svalidate/wrapper", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BvnResponse validate(@RequestBody BvnRequest request) {
        System.out.println(request);
        BvnResponse validationResponse = new Utils().validateRequest(request);

        if (!validationResponse.getCode().equals("00")){
            return validationResponse;
        }

        if (request.getBvn().equals("12345678901")){
            validationResponse.setBvn(request.getBvn());
            validationResponse.setImageDetail("TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCAuLi4=");
            validationResponse.setBasicDetail("TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCAuLi4=");
            validationResponse.setMessage("Success");
            validationResponse.setCode("00");
        } else {
            validationResponse.setBvn(request.getBvn());
            validationResponse.setMessage("The searched BVN does not exist");
            validationResponse.setCode("01");
        }


        return validationResponse;
    }

}
