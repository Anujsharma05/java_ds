package arrays;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args){
        
    	Scanner sc = new Scanner(System.in);
    	
    	byte testCases = sc.nextByte();
    	
    	for(byte t = 0; t<testCases; t++) {
    		byte n = sc.nextByte();
        	byte[] arr = new byte[n];
        	
        	for(byte i = 0 ; i<n; i++) {
        		arr[i] = sc.nextByte();
        	}
        	
        	//reverse array
        	
        	for(byte i = 0 ; i<n/2; i++) {
        		byte temp = arr[i];
        		arr[i] = arr[n-i-1];
        		arr[n-i-1] = temp;
        	}
        	
        	for(byte i = 0 ; i<n; i++) {
        		System.err.print(arr[i] + " ");
        	}
    	}
    	sc.close();
    }
}
