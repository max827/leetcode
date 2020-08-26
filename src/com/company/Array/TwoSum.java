package com.company.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list=new ArrayList<Integer>();
        List<Integer> numslist= Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (Integer i:numslist){
            int temp=target-i;
            if(temp==i){
                List<Integer> newList = new ArrayList<>();
                for(Integer a:numslist){
                    newList.add(a);
                }
                newList.remove(i);
                if(newList.contains(temp)){
                    int index=numslist.indexOf(i);
                    int index1=newList.indexOf(temp);
                    list.add(index);
                    list.add(index1+1);
                    break;
                }
                continue;
            }
            if(numslist.contains(temp)){
                int index1=numslist.indexOf(i);
                int index2=numslist.indexOf(temp);
                list.add(index1);
                list.add(index2);
                break;
            }
        }

        int[] newnums=new int[list.size()];
        for(int i=0;i<newnums.length;i++){
            newnums[i]=list.get(i);
        }
        return newnums;
    }

    public  static void main(String[] args){
        int[] nums={3,2,4};
        int target=6;
        int[] newNums=twoSum(nums,target);
        for(int i=0;i<newNums.length;i++){
            System.out.println(newNums[i]);
        }
    }
}
