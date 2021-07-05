package struct;

public class SparseArr {
    public static void main(String[] args) {
//        1.创建一个原始的二维数组
//            0表示无棋子，1表示黑子，2表示白子
        int[][] chessArr = new int[10][10];
        chessArr[0][5] = 1;
        chessArr[3][7] = 2;
        chessArr[5][4] = 1;

        for (int[] row : chessArr) {
            for (int anInt : row) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr.length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

//        创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
//        给稀疏数组赋值
        sparseArr[0][0] = 10;
        sparseArr[0][1] = 10;
        sparseArr[0][2] = sum;

//        遍历二维数组，将非0的值放到稀疏数组
//
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr.length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("得到的稀疏数组如下：\n");
        System.out.println("行   " + "列   " + "值   ");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }



//        将稀疏数组恢复为原始的二维数组
        int[][] chesss2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chesss2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] ints : chesss2) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
