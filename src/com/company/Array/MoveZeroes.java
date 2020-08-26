package com.company.Array;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]==0){
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                nums[nums.length-1]=0;
            }
            if(nums[i]!=0){
                i++;
            }
            if (allZeroes(i,nums)){
                break;
            }
        }
    }
    private static boolean allZeroes(int index,int[] nums){
        for (int i=index;i<nums.length;i++){
            if(nums[i]!=0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums={0,0,1};
        moveZeroes(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
