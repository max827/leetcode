package com.company.Array;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int start=0;
        int end=nums1.length-1;


        for(int i=0;i< nums2.length;i++){
            int target=nums2[i];
            while (start>end){
                int mid=(start+end)/2;
                if(target>mid){
                    start = mid+1;
                }else if(target<mid){
                    end= mid-1;
                }else{
                    
                }
            }
        }
    }
}
