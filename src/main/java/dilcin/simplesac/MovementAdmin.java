package dilcin.simplesac;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

/**
 * Created by dilcin on 22. 3. 2018.
 */

public class MovementAdmin {
    public int a = 0;
    ArrayList<ImageButton> buttonList = new ArrayList<ImageButton>();
    boolean goingTo = false;
    String board[][] = {
            {"br","bk","bb","bq","bK","bb","bk","br"},
            {"bp","bp","bp","bp","bp","bp","bp","bp"},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {"wp","wp","wp","wp","wp","wp","wp","wp"},
            {"wr","wk","wb","wK","wq","wb","wk","wr"}};
    String memBoard[][] = {
            {"br","bk","bb","bq","bK","bb","bk","br"},
            {"bp","bp","bp","bp","bp","bp","bp","bp"},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {"wp","wp","wp","wp","wp","wp","wp","wp"},
            {"wr","wk","wb","wK","wq","wb","wk","wr"}};
    int[] fromWhere ={0,0};
    boolean boardCollor[][] = new boolean [8][8];
    boolean boardMovable[][] = new boolean [8][8];
    boolean chosen = false,revers = false;
    Context context;
    int from;
    ArrayList<Integer> movesMemRow = new ArrayList <Integer>();
    ArrayList<Integer> movesMemCol = new ArrayList <Integer>();
    chessPieceMovement movement = new chessPieceMovement();
    MovementAdmin(ArrayList<ImageButton> inputList,Context con)
    {
        context = con;
        buttonList = inputList;
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
    public void select(int num)//if choosen place is valid return true
    {
        int row = num / 8;
        int col = num % 8;
        from = num;
        if (board[row][col]!=" ")
        {
            //destroy comment if doesnt work    colorMem = buttonList.get(mem).getBackground();
            goingTo = true; //setting this to true means  legal chess piece has been selected to be moved from its original position
            fromWhere[0] = row;
            fromWhere[1] = col;//this information has to be saved for later, this info is send to arduino
            boardMovable = movement.legalMoves((row),(col),board[(row)][col].charAt(0),board[row][col].charAt(1),board);
            //boardMovable is variable in which are stored all legal moves for chosen piece at the moment
            for(int a = 0;a < 8; a++)
            {
                for(int b = 0;b < 8; b++)
                {
                    if (boardMovable[a][b])
                    {
                        buttonList.get(a*8+b).setBackgroundColor(new Color().RED);// every single legal place is colored red
                    }
                }
            }
            chosen = true;
            return;
        }
        chosen = false;
    }
    public void undoSelect()
    {
        for (int a = 0; a < 8; a++)
        {
            for(int b =0;b<8;b++)
            {
                if (boardCollor[a][b])
                {
                    buttonList.get(a*8+b).setBackgroundColor(context.getResources().getColor(R.color.white_square));
                }
                else
                {
                    buttonList.get(a*8+b).setBackgroundColor(context.getResources().getColor(R.color.black_square));
                }
                boardMovable[a][b] = false;
            }
        }
        chosen = false;
    }
    public void selectMove(int to, RequestQueue queue)
    {
        //System.out.println("from ; " + from + "to : " + to );
        int frow = from/8,fcol = from%8,trow = to/8,tcol = to % 8;
        if (from == to)
        {
            System.out.println();
            undoSelect();
            chosen = false;
        }
        else if (/*boardMovable[trow][tcol]==true&&*/  chosen == true)//
        {

            //buttonList.get(mem).setImageDrawable(getResources().getDrawable(R.drawable.wpawn));
            chosen = false;
            forceMove(frow,fcol,trow,tcol);
            for (int a = 0; a < 8; a++)
            {
                for(int b =0;b<8;b++)
                {
                    if (boardCollor[a][b])
                    {
                        buttonList.get(a*8+b).setBackgroundColor(context.getResources().getColor(R.color.white_square));
                    }
                    else
                    {
                        buttonList.get(a*8+b).setBackgroundColor(context.getResources().getColor(R.color.black_square));
                    }
                    boardMovable[a][b] = false;
                }
            }
            for(int a = 0;a < 8; a++)
            {
                for(int b = 0;b < 8; b++)
                {
                    if (boardMovable[a][b])
                    {
                        buttonList.get(a*8+b).setBackgroundColor(new Color().RED);
                    }
                }
            }
                /*System.out.println("fromWhere [ " + (fromWhere/8) + " ][" + (fromWhere%8)+"]");
                System.out.println("toWhere [ " + (mem/8) + " ][" + (mem%8)+"]");*/
            String url = "http://" + "192.168.10.50" + "/&" + "f1" + ((frow)+1) + "f2" + ((fcol)+1) + "t1" + (trow+1) +"t2" + (tcol+1);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response)
                        {
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    });
            queue.add(stringRequest);
        }
    }
    public boolean forceMove(int frow,int fcol,int trow,int tcol)
    {
        System.out.println("force mov" );
        System.out.println(frow +" "+fcol + " " + trow + " " + tcol);
        if (boardMovable[trow][tcol]==true ||boardMovable[trow][tcol]==false ) {
            try
            {
                buttonList.get(trow * 8 + tcol).setImageDrawable(context.getResources().getDrawable(movement.getPiece(board[frow][fcol])));
            }
            catch (Exception e)
            {

            }
            board[trow][tcol] = board[frow][fcol];
            board[frow][fcol] = " ";
            buttonList.get(frow*8+fcol).setImageDrawable(null);
            if (!revers)
            {
                movesMemRow.add(frow);
                movesMemCol.add(fcol);
                movesMemRow.add(trow);
                movesMemCol.add(tcol);
            }
            return true;
        }
        return false;
    }
    public boolean isSelected()
    {
        return chosen;
    }
    public void undo()
    {System.out.println("undo  enter: " + movesMemRow.size());

        if (movesMemRow.size() >= 1) {
            System.out.print("undo ");
            System.out.println(movesMemRow.get(movesMemRow.size() - 1) + " " + movesMemCol.get(movesMemCol.size() - 1) + " " + movesMemRow.get(movesMemRow.size() - 2)+ " " + movesMemCol.get(movesMemCol.size() - 2));
            buttonList.get((movesMemRow.get(movesMemRow.size() - 1) * 8) + movesMemCol.get(movesMemCol.size() - 1)).setBackgroundColor(new Color().BLUE);
            buttonList.get((movesMemRow.get(movesMemRow.size() - 2) * 8) + movesMemCol.get(movesMemCol.size() - 2)).setBackgroundColor(new Color().YELLOW);
            revers = true;
            forceMove(movesMemRow.get(movesMemRow.size() - 1), movesMemCol.get(movesMemCol.size() - 1), movesMemRow.get(movesMemRow.size()- 2), movesMemCol.get(movesMemCol.size() - 2));
            revers = false;
            if(movesMemRow.size()>0)
            {
                movesMemRow.remove(movesMemRow.size() - 1);
                movesMemCol.remove(movesMemCol.size() - 1);
            }
            if(movesMemRow.size()>0)
            {
                movesMemRow.remove(movesMemRow.size() - 1);
                movesMemCol.remove(movesMemCol.size() - 1);
            }
        }
    }
    public void setDefault()
    {
        for (int a = 0; a < 8; a++)
        {
            for(int b =0;b<8;b++)
            {
                boardMovable[a][b] = false;
                if (memBoard[a][b]!=" ")
                {
                    buttonList.get(a*8+b).setImageDrawable(context.getResources().getDrawable(movement.getPiece(memBoard[a][b])));
                }
                else
                {
                    buttonList.get(a*8+b).setImageDrawable(null);
                }
            }
        }
        movesMemCol.clear();
        movesMemRow.clear();
        undoSelect();
    }
}
