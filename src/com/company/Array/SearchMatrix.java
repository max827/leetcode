package com.company.Array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchMatrix {
    /**
     * 暴力搜索法
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二分法
     */
    private static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length-1 : matrix.length-1;

        while (hi >= lo) {
            int mid = (lo + hi)/2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            //所谓的按照对角线搜索，不过是先按列搜索，再按行搜索而已，
            // 这样可能确实可以避免某一个刚好出现在最后一行或一列的情况吧
            //说实话如果最后都没有找到的话，其实是将空间搜索了两倍诶（行一遍，列一遍），这不是更加浪费吗……

            //先按列搜索
            boolean verticalFound = binarySearch(matrix, target, i, true);
            //再按行搜索
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }


    /**
     * 递归法
     * 内部其实还是二分法，只不过换了一个壳子而已
     */
    private static int[][] matrix;
    private static int target;

    /**
     * 找目标
     * @param left 矩阵的最左边索引
     * @param up 矩阵的最上面索引
     * @param right 矩阵的最右边索引
     * @param down 矩阵的最下面索引
     * @return 存不存在目标
     */
    private static boolean searchRec(int left, int up, int right, int down) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
            // `target` is already larger than the largest element or smaller
            // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right-left)/2;

        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }

    public static boolean searchMatrix3(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }

    /**
     * 走迷宫法……对这个矩阵"排序"的特性利用到了极致,牛逼
     */
    public static boolean searchMatrix4(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        //起始点只能选定左下角或者右上角，因为这样才能让行列一增一减，防止matrix={{-5}}，target=-10判断错误的情况出现
        int row = matrix.length-1;
        int col = 0;

        while (row >=0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix={{-5}};
        boolean a=searchMatrix4(matrix,-10);
        System.out.println(a);;
    }

}
