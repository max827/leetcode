package com.company.Array;

public class AddOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
                if(i==0){
                    int[] newArray=new int[digits.length+1];
                    newArray[0]=1;
                    return newArray;
                }
            }else {
                digits[i]=digits[i]+1;
                return digits;
            }
        }
        return digits;
    }
}
