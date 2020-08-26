package com.company.Array;

import java.util.ArrayList;

public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        boolean[] bl=new boolean[len2];
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<len1;i++) {
            for(int j=0;j<len2;j++) {
                if(nums1[i]==nums2[j] && bl[j]==false) {
                    al.add(nums1[i]);
                    bl[j]=true;
                    break;
                }
            }
        }
        int[] in = new int[al.size()];
        int e=0;
        for(int i:al)
            in[e++] = i;


        return in;

    }
}
