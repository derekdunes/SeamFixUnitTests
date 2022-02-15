package com.example.junitTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JunitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitTestApplication.class, args);

		//Toptal algo test
		//find the number of cars used by a group of passenger after filling the free seats
//		int[] p = new int[]{3,4,2,2};
//		int[] s = new int[]{5,7,2,2};
//
//		int noOfCars = numberOfCars(p, s);
//
//		System.out.println(noOfCars);

		//SeamFix Algo test
		//n param is the length of data we have/
		//d param is no of data to be checked per check session
		//array of data to be checked

//		int[] dataArray = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
//		int dataCheckRange = 3;
//
//		int notifications = noOfNotifications(dataArray.length, dataCheckRange, dataArray);
//
//		System.out.println(notifications);
	}






	static int noOfNotifications(int dataLength, int dataCheckRange, int[] dataArray){
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

	static int[] getRequiredDataRange(int startCropIndex, int dataRange, int[] dataArrayToBeCropped){
		int[] newData = new int[dataRange];

		int count = startCropIndex;
		for (int x = 0; x < newData.length; x++){
			newData[x] = dataArrayToBeCropped[count];
			count++;
		}

		return newData;
	}

	static int getMedian(int[] dataArray) {
		int median = 0;

		if (dataArray.length % 2 == 1){//odd
			median = dataArray[((dataArray.length+1)/2) - 1];
		} else {
			median = (dataArray[(dataArray.length/2)-1] + dataArray[dataArray.length/2]) / 2;
		}

		return median;
	}







	//for different algorithm




	static int numberOfCars(int[] P, int[] S) {
		int numberOfCars = 0;

		//[1,4,1]
		//[1,5,1]
		//[0,5,1]
		List<Integer> modifiedIndexes = new ArrayList<Integer>();

		for (int x = 0; x < P.length; x++) {
			if (P[x] != S[x]) {
				for (int y = 0; y < P.length; y++) {
					if(x != y){
						if (P[y] == S[y] && doesNotExistInModifiedList(y, modifiedIndexes)) {
							if((S[x] - P[x]) >= P[y]){
								//check if it less than P[x]
								int increment = P[x] + P[y];
								P[x] = increment;
								P[y] = 0;
								S[y] = 0;
								modifiedIndexes.add(x);
								modifiedIndexes.add(y);
								break;
							}

							if(P[y] > (S[x] - P[x])){
								//its greater then reduce it by the difference of S[x] and P[x]
								System.out.println("in here");
								int increment = P[x] + (S[x] - P[x]);
								System.out.println("in here" + increment);
								P[y] = P[y] - (S[x] - P[x]);
								S[y] = S[y] - (S[x] - P[x]);
								P[x] = increment;
								modifiedIndexes.add(x);
								break;
							}
						}
					}
				}
			}
		}

		int count = 0;
		for(int s : P){
			if (s != 0){
				count++;
			}
		}

		return count;

		//check if p in car equal to the seat in the car
		//if there is a difference save it and save the position of the difference
		//now check the cars with equal seats and compare with the free seat in the other car
		//if its equal or less than the free space then increment the free seat position by the new passenger
		//and then set the prev passenger position to zero
		//and repeat this process for all that is equal to the number of seats

		//finally loop through the array and count the nos that are not equal to zero

//		List equalNos = new ArrayList<Integer>();
//		List equalNosIndex = new ArrayList<Integer>();
//
//		List unEqualNosDifference = new ArrayList<Integer>();
//		List unEqualNosIndex = new ArrayList<Integer>();
//
//		for (int x = 0; x < P.length; x++) {
//			if (P[x] == S[x]) {
//				equalNos.add(P[x]);
//				equalNosIndex.add(x);
//			} else {
//				unEqualNosDifference.add(S[x] - P[x]);
//				unEqualNosIndex.add(x);
//			}
//		}
//
//		for (int x = 0; x < unEqualNosDifference.size(); x++) {
//			for (int y = 0; y < equalNos.size(); y++) {
//				Integer equalNumber = (Integer) equalNos.get(y);
//				Integer unEqualDifference = (Integer) unEqualNosDifference.get(x);
//
//				if(equalNumber <= unEqualDifference){
//					//modify p index
//					Integer unEqualIndex = (Integer) unEqualNosIndex.get(x);
//					Integer equalIndex = (Integer) equalNosIndex.get(y);
//
//					P[unEqualIndex] = P[unEqualIndex] + equalNumber;//increment
//					P[equalIndex] = P[equalIndex] - equalNumber;//decrement
//
//					//update the difference
//
//					//check if s and p equal
//					if (S[x] == P[x]) {
//						break;
//					}
//				} else {
//
//				}
//			}
//		}
//
//
//		return numberOfCars;

	}

	static boolean doesNotExistInModifiedList(int yIndex, List<Integer> modifiedIndexes){
		boolean doesitExist = true;

		for (int x = 0; x < modifiedIndexes.size(); x++){
			if (yIndex == modifiedIndexes.get(x)){
				doesitExist = false;
			}
		}

		return doesitExist;
	}

}
