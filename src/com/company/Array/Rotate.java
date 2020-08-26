package com.company.Array;

/**
 * 旋转数组
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        for(int i=0;i<k;i++){
            int temp=nums[nums.length-1];
            for(int j=nums.length-1;j>=1;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
    }
}
