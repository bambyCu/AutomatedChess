package dilcin.simplesac;

import java.util.ArrayList;

/**
 * Created by dilcin on 17. 2. 2018.
 */

public class chessPieceMovement {
    boolean boardCollor[][] = new boolean [8][8];
    boolean boardMovable[][] = new boolean [8][8];
    ArrayList<Integer> worker = new ArrayList();
    String pieceValues[][] = {
            {"br","bk","bb","bq","bK","bb","bk","br"},
            {"bp","bp","bp","bp","bp","bp","bp","bp"},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {"wp","wp","wp","wp","wp","wp","wp","wp"},
            {"wr","wk","wb","wK","wq","wb","wk","wr"}};
    chessPieceMovement()
    {
        for (int a = 0; a < 8; a++)
        {
            for(int b =0;b<8;b++)
            {
                if((a+b)%2==1)
                {
                    boardCollor[a][b] = true;
                }
                else
                {
                    boardCollor[a][b] = false;
                }
                boardMovable[a][b] = false;
            }
        }
    }

    int getPiece(String in) {
        if (in == "wp") {
            return R.drawable.wpawn;
        } else if (in == "wr") {
            return R.drawable.wrook;
        } else if (in == "wb") {
            return R.drawable.wbishop;
        } else if (in == "wk") {
            return R.drawable.wknight;
        } else if (in == "wq") {
            return R.drawable.wqueen;
        } else if (in == "wK") {
            return R.drawable.wking;
        } else if (in == "bp") {
            return R.drawable.bpawn;
        }else if (in == "br") {
            return R.drawable.brook;
        } else if (in == "bb") {
            return R.drawable.bbishop;
        } else if (in == "bk") {
            return R.drawable.bknight;
        } else if (in == "bq") {
            return R.drawable.bqueen;
        } else if (in == "bK") {
            return R.drawable.bking;
        }
        return 0;
    }

    int getPieceValue(String in) {
        int val = 0;
        char piece = 0;
        char color = 0;
        if (in != " ")
        {
            color = in.charAt(0);
            piece = in.charAt(1);
        }
        if (piece == 'p') {
            val=10;
        } else if (piece == 'r') {
            val = 50;
        } else if (piece == 'b') {
            val = 30;
        } else if (piece == 'k') {
            val = 30;
        } else if (piece == 'q') {
            val = 90;
        } else if (piece == 'K') {
            val = 900;
        }
        if (color == 'b')
        {
            val = val * (-1);
        }
        return val;
    }

    boolean[][] legalMoves(int rowIn, int colIn,String board[][])
    {
       /* for(int a = 0;a < 8; a++)
        {
            for(int b = 0;b < 8; b++)
            {
                System.out.print(board[a][b]);
            }
            System.out.println();
        }*/
        int row = rowIn ;
        int col = colIn ;
        for(int a = 0;a < 8; a++)
        {
            for(int b = 0;b < 8; b++)
            {
                System.out.print(board[a][b]);
            }
            System.out.println();
        }
        for (int a = 0; a < 8; a++)
        {
            for(int b =0;b<8;b++)
            {
                boardMovable[a][b] = false;
            }
        }
        if (board[row][col].length() <=1)
        {
            return boardMovable;
        }
        char color = board[row][col].charAt(0);
        char piece = board[row][col].charAt(1);
        char color1;
        System.out.println(color);
        System.out.println(piece);
        if(color == 'w')
        {
            color1 = 'b';
        }
        else
        {
            color1 = 'w';
        }
        if(piece == 'b' || piece=='q')
        {
            for (int a = row; a >= 0; a--) {
                if (col + a - row > 0 && board[a][(col) + a - row].charAt(0) == color && a != row) {
                    a = -1;
                } else if (col + a - row > 0 && board[a][(col) + a - row].charAt(0) == color1 && a != row) {
                    boardMovable[a][col + a - row] = true;
                    a = -1;
                } else if (col + a - row >= 0) {
                    System.out.println("a: " + a + "b: " + (col + a - row));
                    System.out.println(board[a][col + a - row]);
                    boardMovable[a][col + a - row] = true;
                }
            }
            int a = 0;
            while (row + a < 8 && col - a >= 0) {
                if (board[row + a][col - a].charAt(0) == color && a != 0) {
                    a = 100;
                } else if (board[row + a][col - a].charAt(0) == color1 && a != 0) {
                    //System.out.println("sss"+ (row - a) + ".col = " + (col + a));
                    boardMovable[row + a][col - a] = true;
                    a = 100;
                } else {
                    boardMovable[row + a][col - a] = true;
                    a++;
                }
            }
            a = 0;
            while (row - a >= 0 && col + a < 8) {
                if (board[row - a][col + a].charAt(0) == color && a != 0) {
                    //System.out.println("sss"+ (row - a) + ".col = " + (col + a));
                    a = 100;
                } else if (board[row - a][col + a].charAt(0) == color1 && a != 0) {
                    //System.out.println("sss"+ (row - a) + ".col = " + (col + a));
                    boardMovable[row - a][col + a] = true;
                    a = 100;
                } else {
                    boardMovable[row - a][col + a] = true;
                    a++;
                }
            }
            a = 0;
            while (row + a < 8 && col + a < 8) {
                if (board[row + a][col + a].charAt(0) == color && a != 0) {
                    //System.out.println("sss"+ (row - a) + ".col = " + (col + a));
                    a = 100;
                } else if (board[row + a][col + a].charAt(0) == color1 && a != 0) {
                    //System.out.println("sss"+ (row - a) + ".col = " + (col + a));
                    boardMovable[row + a][col + a] = true;
                    a = 100;
                } else {
                    boardMovable[row + a][col + a] = true;
                    a++;
                }
            }
        }
        if (piece=='r' || piece=='q')
        {
            int a = 0;


            while (col + a < 8) {
                if (board[row][col + a].charAt(0) == color && a != 0) {
                    a = 100;
                } else if (board[row][col + a].charAt(0) == color1 && a != 0) {
                    boardMovable[row][col + a] = true;
                    a = 100;
                } else {
                    boardMovable[row][col + a] = true;
                    a++;
                }
            }
            a = 0;
            while (col - a >= 0) {
                if (board[row][col - a].charAt(0) == color && a != 0) {
                    a = 100;
                } else if (board[row][col - a].charAt(0) == color1 && a != 0) {
                    boardMovable[row][col - a] = true;
                    a = 100;
                } else {
                    boardMovable[row][col - a] = true;
                    a++;
                }
            }
            a = 0;
            while (row + a < 8) {
                if (board[row + a][col].charAt(0) == color && a != 0) {
                    a = 100;
                } else if (board[row + a][col].charAt(0) == color1 && a != 0) {
                    boardMovable[row + a][col] = true;
                    a = 100;
                } else {
                    boardMovable[row + a][col] = true;
                    a++;
                }
            }
            a = 0;
            while (row - a >= 0) {
                if (board[row - a][col].charAt(0) == color && a != 0) {
                    //System.out.println("sss"+ (row - a) + ".col = " + (col + a));
                    a = 100;
                } else if (board[row - a][col].charAt(0) == color1 && a != 0) {
                    //System.out.println("sss"+ (row - a) + ".col = " + (col + a));
                    boardMovable[row - a][col] = true;
                    a = 100;
                } else {
                    boardMovable[row - a][col] = true;
                    a++;
                }
            }
        }
        if(piece == 'k')
        {
            boardMovable[row][col] = true;
            if(row+2<8) {

                if(col+1<8 && board[row + 2][col + 1].charAt(0)!=color)
                {
                    boardMovable[row + 2][col + 1] = true;
                }
                if(col-1>=0 && board[row + 2][col - 1].charAt(0)!=color)
                {
                    boardMovable[row + 2][col - 1] = true;
                }
            }
            if(row-2>=0) {

                if(col+1<8 && board[row - 2][col + 1].charAt(0)!=color)
                {
                    boardMovable[row - 2][col + 1] = true;
                }
                if(col-1>=0 && board[row - 2][col - 1].charAt(0)!=color)
                {
                    boardMovable[row - 2][col - 1] = true;
                }
            }
            if(col-2>=0) {

                if(row+1<8 && board[row + 1][col - 2].charAt(0)!=color)
                {
                    boardMovable[row + 1][col - 2] = true;
                }
                if(row-1>=0 && board[row - 1][col - 2].charAt(0)!=color)
                {
                    boardMovable[row - 1][col - 2] = true;
                }
            }
            if(col+2<8) {

                if(row+1<8 && board[row + 1][col + 2].charAt(0)!=color)
                {
                    boardMovable[row + 1][col + 2] = true;
                }
                if(row-1>=0 && board[row - 1][col + 2].charAt(0)!=color)
                {
                    boardMovable[row - 1][col + 2] = true;
                }
            }
        }
        if(piece == 'K')
        {
            boardMovable[row][col] = true;
            if(col+1 < 8)
            {
                if (board[row][col+1].charAt(0) != color)
                {
                    boardMovable[row][col+1] = true;
                }
            }
            if(col-1 >= 0)
            {
                if ( board[row][col-1].charAt(0) != color)
                {
                    boardMovable[row][col-1] = true;
                }
            }
            if(row+1 < 8)//1*
            {
                if (board[row+1][col].charAt(0) != color)
                {
                    boardMovable[row+1][col] = true;
                }
            }
            if(row-1 >= 0)//1* a toto yu musi byt lebo inac sa prekresluju aj priatelske jednotky
            {
                if (board[row-1][col].charAt(0) != color)
                {
                    boardMovable[row-1][col] = true;
                }
            }
            if(row+1 < 8 )
            {

                if(col+1 < 8 && board[row+1][col+1].charAt(0) != color)
                {
                    boardMovable[row+1][col+1] = true;
                }
                if(col-1 >=0 && board[row+1][col-1].charAt(0) != color)
                {
                    boardMovable[row+1][col-1] = true;
                }
            }
            if(row-1 >=0 )
            {
                if(col+1 < 8 && board[row-1][col+1].charAt(0) != color)
                {
                    boardMovable[row-1][col+1] = true;

                }
                if(col-1 < 8 && board[row-1][col-1].charAt(0) != color)
                {
                    boardMovable[row-1][col-1] = true;
                }
            }
        }
        if(piece == 'p' && board[row][col].charAt(0) == 'w')
        {
            boardMovable[row][col] = true;
            if(board[row-1][col].charAt(0) != color1 && board[row - 1][col].charAt(0) != color)
            {
                boardMovable[row - 1][col] = true;
                if (row == 6)
                {
                    boardMovable[row - 2][col] = true;
                }
            }
            if(col+1 < 8 && board[row-1][col+1].charAt(0) == color1)
            {
                boardMovable[row-1][col+1] = true;
            }
            if(col-1>=0 && board[row-1][col-1].charAt(0) == color1)
            {
                boardMovable[row-1][col-1] = true;
            }
        }
        else if(piece == 'p')
        {
            boardMovable[row][col] = true;
            if (row + 1 < 8)
            {
                if(board[row + 1][col].charAt(0) != color1 && board[row + 1][col].charAt(0) != color)
                {
                    boardMovable[row + 1][col] = true;
                    if (row == 1)
                    {
                        boardMovable[row + 2][col] = true;
                    }
                }
            }

            if (col + 1 < 8 && board[row + 1][col + 1].charAt(0) == color1)
            {
                boardMovable[row + 1][col + 1] = true;
            }
            if (col - 1 >= 0 && board[row + 1][col - 1].charAt(0) == color1)
            {
                boardMovable[row + 1][col - 1] = true;
            }
        }
        return boardMovable;
    }

     void chessAI(String[][] board)
    {
        int[][] chessBoardValues = new int [8][8];

        for (int a = 0;a<8;a++)
        {
            for (int b = 0;b<8;b++)
            {
                chessBoardValues[a][b] = getPieceValue(board[a][b]);
                //System.out.print(chessBoardValues[a][b]);
            }
            //System.out.println();
        }
        for (int a = 0;a<8;a++)
        {
            for (int b = 0;b<8;b++)
            {
                if (board[a][b] != " " && board[a][b].charAt(0) =='b' )
                {
                    System.out.println("worker");
                    int[] positions = AIWorker(a,b,board,1) ;
                    for(int i = 0 ; i<positions.length;i++)
                    {
                        System.out.print(positions[i] + ", ");
                    }
                    worker.clear();
                    System.out.println("worker end");
                }
            }
        }
    }
    int[] AIWorker(int row, int col, String[][] board, int deep)
    {
        int[][] chessBoardValues = new int [8][8];
        boolean[][]positions = legalMoves(row,col,board);
        for (int a = 0;a<8;a++)
        {
            for (int b = 0;b<8;b++)
            {
                chessBoardValues[a][b] = getPieceValue(board[a][b]);
                //System.out.print(chessBoardValues[a][b]);
            }
            //System.out.println();
        }
        if (deep <= 0)
        {
            int positive = 0 ,negative = 0;
            for (int a = 0;a<8;a++)
            {
                for (int b = 0;b<8;b++)
                {
                    if (chessBoardValues[a][b]< 0)
                    {
                        negative = negative + chessBoardValues[a][b];
                    }
                    if (chessBoardValues[a][b]> 0)
                    {
                        positive = positive + chessBoardValues[a][b];
                    }
                }
            }
            worker.add(9);
            worker.add(positive);
            worker.add(negative);
            return new int[1];
        }
        for (int a = 0;a<8;a++)
        {
            for (int b = 0;b<8;b++)
            {
                if (positions[a][b])
                {
                    if(a != row || b!=col)
                    {
                        worker.add(row);

                        worker.add(col);

                        worker.add(a);

                        worker.add(b);
                        String temp = board[row][col];
                        //System.out.println(worker);
                        board[row][col] = board [a][b];
                        //System.out.println("DEEP : " + deep);
                        /*for (int i = 0;i<8;i++)
                        {
                            for (int j = 0;j<8;j++)
                            {
                                System.out.print(board[i][j]);
                            }
                            System.out.println();
                        }*/
                        board[a][b] = temp;
                        deep--;
                        AIWorker(a,b,board,deep);
                        System.out.println(worker);
                    }
                }
            }
        }
        int temp[] = new int [50];
        int count = 0;
        for (int a = 0;a<worker.size()-2;a++)
        {
            if (worker.get(a)==9)
            {
                temp [count] = worker.get(a + 1);
                count++;
                temp [count] = worker.get(a + 2);
                count++;
            }
        }
        return temp;
    }

}
