package com.company.Array;

/**
 * 只出现一次的数字
 * 时间复杂度为线性
 * 不能使用额外空间
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            //使用异或，相同数字异或之后为0，任何数字与0异或为其本身
            //主要对异或不熟啊，想不到啊
            num=num^nums[i];
        }
        return num;
    }
}
