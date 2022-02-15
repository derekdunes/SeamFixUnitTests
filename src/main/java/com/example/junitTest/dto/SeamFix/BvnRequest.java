package com.example.junitTest.dto.SeamFix;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BvnRequest {

    @JsonProperty("bvn")
    private String bvn;

    public BvnRequest() {

    }

    public BvnRequest(String bvn) {
        this.bvn = bvn;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    @Override
    public String toString() {
        return "BvnRequest{" +
                "bvn=" + bvn +
                '}';
    }
}
