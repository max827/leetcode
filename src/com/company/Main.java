package com.company;

import com.company.Array.RotateImage;

public class Main {

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        RotateImage rotateImage=new RotateImage();
        rotateImage.rotate(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                System.out.println(matrix);
            }
        }
        System.out.println(123);
    }
}
