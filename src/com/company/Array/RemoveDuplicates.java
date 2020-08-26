package com.company.Array;

/**
 * 移除重复数字
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int length=1;
        int flag=nums[0];
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(flag!=nums[i]){
                flag=nums[i];
                nums[index]=flag;
                index++;
                length++;
            }
        }
        return length;
    }
}
