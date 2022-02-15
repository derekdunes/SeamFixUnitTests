package com.example.junitTest.dto.SeamFix;

public class BvnResponse {
    private String message;
    private String code;
    private String bvn;
    private String imageDetail;
    private String basicDetail;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(String imageDetail) {
        this.imageDetail = imageDetail;
    }

    public String getBasicDetail() {
        return basicDetail;
    }

    public void setBasicDetail(String basicDetail) {
        this.basicDetail = basicDetail;
    }

    @Override
    public String toString() {
        return "BvnResponse{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", bvn='" + bvn + '\'' +
                ", imageDetail='" + imageDetail + '\'' +
                ", basicDetail='" + basicDetail + '\'' +
                '}';
    }

}
