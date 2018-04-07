package dilcin.simplesac;

/**
 * Created by dilcin on 17. 2. 2018.
 */

public class chessPieceMovement {
    boolean boardCollor[][] = new boolean [8][8];
    boolean boardMovable[][] = new boolean [8][8];
    String board[][] = {
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

    boolean[][] legalMoves(int row, int col, char color, char piece,String board[][])
    {
       /* for(int a = 0;a < 8; a++)
        {
            for(int b = 0;b < 8; b++)
            {
                System.out.print(board[a][b]);
            }
            System.out.println();
        }*/
        for (int a = 0; a < 8; a++)
        {
            for(int b =0;b<8;b++)
            {
                boardMovable[a][b] = false;
            }
        }
        char color1;
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
            if(col+1 < 8 && board[row][col+1].charAt(0) != color)
            {
                boardMovable[row][col+1] = true;
            }
            if(col-1 >= 0 && board[row][col-1].charAt(0) != color)
            {
                boardMovable[row][col-1] = true;
            }
            if(row+1 < 8 && board[row+1][col].charAt(0) != color)//1*
            {
                boardMovable[row+1][col] = true;
            }
            if(row-1 < 8 && board[row-1][col].charAt(0) != color)//1* a toto yu musi byt lebo inac sa prekresluju aj priatelske jednotky
            {
                boardMovable[row-1][col] = true;
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
            if(board[row + 1][col].charAt(0) != color1 && board[row + 1][col].charAt(0) != color)
            {
                boardMovable[row + 1][col] = true;
                if (row == 1)
                {
                    boardMovable[row + 2][col] = true;
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
}
