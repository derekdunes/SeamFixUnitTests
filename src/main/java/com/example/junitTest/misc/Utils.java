package com.example.junitTest.misc;


import com.example.junitTest.dto.SeamFix.BvnRequest;
import com.example.junitTest.dto.SeamFix.BvnResponse;

import java.util.Arrays;

public class Utils {

    public BvnResponse validateRequest(BvnRequest validationRequest) {
        //aim to detect null
        //to detect invalid confirmationCode
        //to detect invalid phoneNumber
        String bvn = validationRequest.getBvn().trim();

        if (bvn.isEmpty()){
            BvnResponse validationResponse = new BvnResponse();
            validationResponse.setCode("400");
            validationResponse.setMessage("One or more of your request parameters failed validation. Please retry");
            validationResponse.setBvn(bvn);
            return validationResponse;
        }

        if (bvn.length() != 11) {
            System.out.println("Wrong length");
            BvnResponse validationResponse = new BvnResponse();
            validationResponse.setCode("02");
            validationResponse.setMessage("The searched BVN is invalid");
            validationResponse.setBvn(bvn);
            return validationResponse;
        }

        if (!bvn.matches("^[0-9]+")) {
            System.out.println("contains non number");
            BvnResponse validationResponse = new BvnResponse();
            validationResponse.setCode("400");
            validationResponse.setMessage("The searched BVN is invalid");
            validationResponse.setBvn(bvn);
            return validationResponse;
        }


        BvnResponse validationResponse = new BvnResponse();
        validationResponse.setCode("00");
        return validationResponse;
    }

    public int noOfNotifications(int dataLength, int dataCheckRange, int[] dataArray){
        //[2 3 4 2 3 6 8 4 5]
        //loop through the array and check whether the previous items are = dataCheckRange
        //7 => 5
        //5 0 - 4 (range is ((n-range - n-1) eg index 6 (((6-1) - 5) - 6-1)
        // 6(7-1) 1 - 5 for 7 eg (((7-1) - 5) - 7-1)
        //pick the items starting from the 0 index to the  datacheckrange-1
        //[2 3 4 2 3]
        //sort the array
        //[2,2,3,3,4]
        //get the median = 3
        //then compare it to the index indexrange
        //number with the dataset >= 2 * median

        int notification =  0;

        for (int x = 0; x < dataArray.length; x++) {
            if(x >= dataCheckRange){
                int comparedValue = dataArray[x];
                //pick the range
                int[] croppedData = getRequiredDataRange(x-dataCheckRange, dataCheckRange, dataArray);
                //sort the data
                Arrays.sort(croppedData);
                //get the median
                int median = getMedian(croppedData);

                if(comparedValue >= (2 * median)) {
                    notification++;
                }
            }
        }

        return notification;
    }

    public int[] getRequiredDataRange(int startCropIndex, int dataRange, int[] dataArrayToBeCropped){
        int[] newData = new int[dataRange];

        int count = startCropIndex;
        for (int x = 0; x < newData.length; x++){
            newData[x] = dataArrayToBeCropped[count];
            count++;
        }

        return newData;
    }

    public int getMedian(int[] dataArray) {
        int median = 0;

        if (dataArray.length % 2 == 1){//odd
            median = dataArray[((dataArray.length+1)/2) - 1];
        } else {
            median = (dataArray[(dataArray.length/2)-1] + dataArray[dataArray.length/2]) / 2;
        }

        return median;
    }
}
