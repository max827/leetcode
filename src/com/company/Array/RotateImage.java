package com.company.Array;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int start=0;
        int len=matrix.length-1;
        int end=len;
        while (true){
            if(end-start<1){
                break;
            }
            for(int i=start;i<end;i++){
                //顺时针进行覆盖
                //右
                int temp1=matrix[i][end];
                matrix[i][end]=matrix[start][i];
                //下
                int temp2=matrix[end][len-i];
                matrix[end][len-i]=temp1;
                //左
                temp1=matrix[len-i][start];
                matrix[len-i][start]=temp2;
                //上
                matrix[start][i]=temp1;
            }
            start++;
            end--;
        }

    }
}
