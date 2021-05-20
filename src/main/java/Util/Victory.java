package Util;

import Entity.Checkerboard;
import Entity.Position;

import java.util.ArrayList;
import java.util.List;

public class Victory {
    int[][] chead = new int[5][4];

    List<Position> positions = new  ArrayList<Position>();
    public boolean victory(Checkerboard checkerboard, String color){
        for (int i = 0; i < chead.length; i++) {
            for (int j = 0; j < chead[0].length; j++) {
                chead[i][j] = 0;
            }
        }

        for (int i = 0; i < checkerboard.getPieceCount(); i++) {
            String colornow = String.valueOf(checkerboard.getPieceType(i));
            if (color.equals(colornow)) {
                Position position = checkerboard.getPiecePosition(i);
                positions.add(position);
                chead[position.getRow()][position.getCol()] = 1;
            }
        }
        for (int i = 0; i < positions.size(); i++) {
            if (winOrLoseCheck(chead,positions.get(i).getRow(),positions.get(i).getCol())==true) {
                return true;
            }
        }

        return false;
    }

    private static boolean winCol(int[][] board, final int row, final int col) {
        int rowCount = 1;
        /* * 向上查找 * col - i >= 0 是为了防止越界的条件 * board[row][col - i] == board[row][col] 由中心向外判断棋子是否相连的条件 */
        for (int i = 1; i <= 2; i++) {
            if (col - i >= 0 && board[row][col - i] == board[row][col]) {
                rowCount++;	//若是相连，该方向上的棋子数加一
            } else {
                break;	//若是遇到第一个空位或非己方棋子退出循环
            }
        }
        //向下查找
        //col + i < BOARD_SIZE 一样为了防止越界
        for (int i = 1; i <= 2; i++) {
            if (col + i < 4 && board[row][col + i]
                    == board[row][col]) {
                rowCount++;
            } else {
                break;
            }
        }
        //若是上下两个方向上相连的棋子相加大于等于5，返回true，不然返回false
        return rowCount >= 3 ? true : false;
    }
    private static boolean winRow(int[][] board, final int row, final int col) {
        int colCount = 1;
        //向左查找
        for (int i = 1; i <= 2; i++) {
            if (row - i >= 0 && board[row - i][col] == board[row][col]) {
                colCount++;
            } else {
                break;
            }
        }
        //向右查找
        for (int i = 1; i <= 2; i++) {
            if (row + i < 5 &&
                    board[row + i][col] == board[row][col]) {
                colCount++;
            } else {
                break;
            }
        }
        return colCount >= 3 ? true : false;
    }
    private static boolean winLeftLea(int[][] board, final int row, final int col) {
        int leftLeaCount = 1;
        //向左上查找
        for (int i = 1; i <= 2; i++) {
            if (row - i >= 0 && col - i >= 0 && board[row - i][col - i]
                    == board[row][col]) {
                leftLeaCount++;
            } else {
                break;
            }
        }
        //向右下查找
        for (int i = 1; i <= 2; i++) {
            if (row + i < 5 && col + i < 4 &&
                    board[row + i][col + i] == board[row][col]) {
                leftLeaCount++;
            } else {
                break;
            }
        }
        return leftLeaCount >= 3 ? true : false;
    }
    private static boolean winRightLea(int[][] board, final int row, final int col) {
        int rightLeaCount = 1;
        //向左下查找
        for (int i = 1; i <= 2; i++) {
            if (row + i < 5 && col - i >= 0 &&
                    board[row + i][col - i] == board[row][col]) {
                rightLeaCount++;
            } else {
                break;
            }
        }
        //向右上查找
        for (int i = 1; i <= 2; i++) {
            if (row - i >= 0 && col + i < 4 &&
                    board[row - i][col + i] == board[row][col]) {
                rightLeaCount++;
            } else {
                break;
            }
        }
        return rightLeaCount >= 3 ? true : false;
    }
    /** * 该方法调用了其余判断四个方向的方法做为判断条件 * 其中之一知足则表明出现赢棋，返回true，不然返回false * */
    public static boolean winOrLoseCheck(int[][] board, final int row, final int col) {
        if (winCol(board, row, col) || winRow(board, row, col)
                || winLeftLea(board, row, col) || winRightLea(board, row, col)) {
            return true;
        } else {
            return false;
        }
    }

}
