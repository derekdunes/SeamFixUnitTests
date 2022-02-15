package com.example.junitTest;

import com.example.junitTest.misc.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.junitTest.JunitTestApplication.getRequiredDataRange;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NotificationCalculationAlgorithmTests {
    Utils util = null;

    @BeforeEach
    void setup(){
        util = new Utils();
    }
    @Test
    public void MedianFunctionTest(){
        int[] oddArray = new int[]{2,3,4};
        int[] evenArray = new int[]{2,2,2,5};

        int oddMedian = util.getMedian(oddArray);
        int evenMedian = util.getMedian(evenArray);

        assertEquals(3, oddMedian);
        assertEquals(2, evenMedian);
    }

    @Test
    public void DataRangeFunctionTest(){
        int[] array = new int[]{2,2,2,5,6,1,7,1};

        int[] croppedData = util.getRequiredDataRange(1, 6, array);

        assertEquals(6, croppedData.length);

    }

    @Test
    public void NotificationAlgoTest(){
		int[] dataArray = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
		int dataCheckRange = 5;

		int notifications = util.noOfNotifications(dataArray.length, dataCheckRange, dataArray);

		assertEquals(2, notifications);
    }
}
