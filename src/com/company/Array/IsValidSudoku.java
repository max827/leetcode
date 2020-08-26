package com.company.Array;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++){
            int[] row = new int[9];
            int[] col = new int[9];
            int[] cube = new int[9];
            for(int j=0;j<9;j++){
                //判断行有没有重复
                if(board[i][j]!='.'){
                    int num=board[i][j]-'1';
                    if(row[num]==0){
                        row[num]=1;
                    }else{
                        return false;
                    }
                }


                //判断列有没有重复
                if(board[j][i]!='.'){
                    int num1=board[j][i]-'1';
                    if(col[num1]==0){
                        col[num1]=1;
                    }else{
                        return false;
                    }
                }

                //判断九宫格
                int cubeX = 3 * (i/3) + j/3;
                int cubeY = 3 * (i%3) + j%3;
                if(board[cubeX][cubeY]!='.'){
                    int num2=board[cubeX][cubeY]-'1';
                    if(cube[num2]==0){
                        cube[num2]=1;
                    }else {
                        return false;
                    }
                }

            }


        }

        return true;
    }
    public boolean judge(int startRow,int startCol,int endRow,int endCol,char[][] board){
        for (int i=startRow;i<=endRow;i++){
            for(int j=startCol;j<=endCol;j++){
                if(board[i][j]=='.')
                    continue;
                char temp=board[i][j];
                for (int x=i;x<=endRow;x++){
                    for(int y=j+1;y<=endCol;y++){
                        if(temp==board[x][y]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
