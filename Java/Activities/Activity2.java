package activities;

import java.util.*;

public class Activity2 {
    public static void main(String[] args) {
        int[] arr = {10, 77, 10, 54, -11, 10};
    	System.out.println("Result: "+check(arr));
    }
    public static boolean check(int[] arr) {
    	int counter=0;
    	boolean result=false;
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]==10) {
        		counter=counter+10;
        	}
        }
        if(counter==30) {
        	result=true;
        }
    	return result;
    }
}