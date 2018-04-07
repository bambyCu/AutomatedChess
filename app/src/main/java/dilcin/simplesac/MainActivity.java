package dilcin.simplesac;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    Context context;
    MovementAdmin admin;
    Button speech;
    final ArrayList<ImageButton> buttonList = new ArrayList<ImageButton>();
    final ArrayList<TextView> textList = new ArrayList<TextView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        queue = Volley.newRequestQueue(this);
        Button undo =(Button)findViewById(R.id.Button2);
        ImageButton reset =(ImageButton)findViewById(R.id.imageButton);
        final GridLayout gl =(GridLayout)findViewById(R.id.gridLayout);
        final GridLayout gl2 =(GridLayout)findViewById(R.id.gridLayout2);
        buttonList.add((ImageButton) findViewById(R.id.iButton1));
        buttonList.add((ImageButton) findViewById(R.id.iButton2));
        buttonList.add((ImageButton) findViewById(R.id.iButton3));
        buttonList.add((ImageButton) findViewById(R.id.iButton4));
        buttonList.add((ImageButton) findViewById(R.id.iButton5));
        buttonList.add((ImageButton) findViewById(R.id.iButton6));
        buttonList.add((ImageButton) findViewById(R.id.iButton7));
        buttonList.add((ImageButton) findViewById(R.id.iButton8));
        buttonList.add((ImageButton) findViewById(R.id.iButton9));
        buttonList.add((ImageButton) findViewById(R.id.iButton10));
        buttonList.add((ImageButton) findViewById(R.id.iButton11));
        buttonList.add((ImageButton) findViewById(R.id.iButton12));
        buttonList.add((ImageButton) findViewById(R.id.iButton13));
        buttonList.add((ImageButton) findViewById(R.id.iButton14));
        buttonList.add((ImageButton) findViewById(R.id.iButton15));
        buttonList.add((ImageButton) findViewById(R.id.iButton16));
        buttonList.add((ImageButton) findViewById(R.id.iButton17));
        buttonList.add((ImageButton) findViewById(R.id.iButton18));
        buttonList.add((ImageButton) findViewById(R.id.iButton19));
        buttonList.add((ImageButton) findViewById(R.id.iButton20));
        buttonList.add((ImageButton) findViewById(R.id.iButton21));
        buttonList.add((ImageButton) findViewById(R.id.iButton22));
        buttonList.add((ImageButton) findViewById(R.id.iButton23));
        buttonList.add((ImageButton) findViewById(R.id.iButton24));
        buttonList.add((ImageButton) findViewById(R.id.iButton25));
        buttonList.add((ImageButton) findViewById(R.id.iButton26));
        buttonList.add((ImageButton) findViewById(R.id.iButton27));
        buttonList.add((ImageButton) findViewById(R.id.iButton28));
        buttonList.add((ImageButton) findViewById(R.id.iButton29));
        buttonList.add((ImageButton) findViewById(R.id.iButton30));
        buttonList.add((ImageButton) findViewById(R.id.iButton31));
        buttonList.add((ImageButton) findViewById(R.id.iButton32));
        buttonList.add((ImageButton) findViewById(R.id.iButton33));
        buttonList.add((ImageButton) findViewById(R.id.iButton34));
        buttonList.add((ImageButton) findViewById(R.id.iButton35));
        buttonList.add((ImageButton) findViewById(R.id.iButton36));
        buttonList.add((ImageButton) findViewById(R.id.iButton37));
        buttonList.add((ImageButton) findViewById(R.id.iButton38));
        buttonList.add((ImageButton) findViewById(R.id.iButton39));
        buttonList.add((ImageButton) findViewById(R.id.iButton40));
        buttonList.add((ImageButton) findViewById(R.id.iButton41));
        buttonList.add((ImageButton) findViewById(R.id.iButton42));
        buttonList.add((ImageButton) findViewById(R.id.iButton43));
        buttonList.add((ImageButton) findViewById(R.id.iButton44));
        buttonList.add((ImageButton) findViewById(R.id.iButton45));
        buttonList.add((ImageButton) findViewById(R.id.iButton46));
        buttonList.add((ImageButton) findViewById(R.id.iButton47));
        buttonList.add((ImageButton) findViewById(R.id.iButton48));
        buttonList.add((ImageButton) findViewById(R.id.iButton49));
        buttonList.add((ImageButton) findViewById(R.id.iButton50));
        buttonList.add((ImageButton) findViewById(R.id.iButton51));
        buttonList.add((ImageButton) findViewById(R.id.iButton52));
        buttonList.add((ImageButton) findViewById(R.id.iButton53));
        buttonList.add((ImageButton) findViewById(R.id.iButton54));
        buttonList.add((ImageButton) findViewById(R.id.iButton55));
        buttonList.add((ImageButton) findViewById(R.id.iButton56));
        buttonList.add((ImageButton) findViewById(R.id.iButton57));
        buttonList.add((ImageButton) findViewById(R.id.iButton58));
        buttonList.add((ImageButton) findViewById(R.id.iButton59));
        buttonList.add((ImageButton) findViewById(R.id.iButton60));
        buttonList.add((ImageButton) findViewById(R.id.iButton61));
        buttonList.add((ImageButton) findViewById(R.id.iButton62));
        buttonList.add((ImageButton) findViewById(R.id.iButton63));
        buttonList.add((ImageButton) findViewById(R.id.iButton64));
        textList.add((TextView) findViewById(R.id.textView));
        textList.add((TextView) findViewById(R.id.textView2));
        textList.add((TextView) findViewById(R.id.textView3));
        textList.add((TextView) findViewById(R.id.textView4));
        textList.add((TextView) findViewById(R.id.textView5));
        textList.add((TextView) findViewById(R.id.textView6));
        textList.add((TextView) findViewById(R.id.textView7));
        textList.add((TextView) findViewById(R.id.textView8));
        textList.add((TextView) findViewById(R.id.textView9));
        textList.add((TextView) findViewById(R.id.textView10));
        textList.add((TextView) findViewById(R.id.textView11));
        textList.add((TextView) findViewById(R.id.textView12));
        textList.add((TextView) findViewById(R.id.textView13));
        textList.add((TextView) findViewById(R.id.textView14));
        textList.add((TextView) findViewById(R.id.textView15));
        textList.add((TextView) findViewById(R.id.textView16));

        speech = (Button)findViewById(R.id.button2);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admin.setDefault();
            }
        });
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admin.undo();
            }
        });
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "talk bitch");
                try {
                    startActivityForResult(intent, 1);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),"speech not suported", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewTreeObserver observer = gl .getViewTreeObserver();

        final RelativeLayout rl = (RelativeLayout)findViewById(R.id.relativeLayout);
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int width= rl.getWidth()-100;
                int height= rl.getHeight();
                RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(width,height);
                param.height = width;
                gl.setLayoutParams(param);
                GridLayout.LayoutParams params;
                for (int a = 0; a < 64; a++) {
                    params = new GridLayout.LayoutParams();
                    params.height = width/8 ;
                    params.width = width/8;
                    buttonList.get(a).setLayoutParams(params);
                }
                for (int a = 0; a < 8; a++) {
                    params = new GridLayout.LayoutParams();
                    params.height = width/8 ;
                    params.width = 60;
                    //textList.get(a).setTextSize();
                    textList.get(a).setLayoutParams(params);
                }
                for (int a = 8; a < 16; a++) {
                    params = new GridLayout.LayoutParams();
                    params.height = 60 ;
                    params.width = width/8;
                    //textList.get(a).setTextSize();
                    textList.get(a).setLayoutParams(params);
                }
                gl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        for (int a = 0; a < 64; a++)
        {
            buttonList.get(a).setOnClickListener(new Akcioner(a));
        }
        admin = new MovementAdmin(buttonList,this);
    }
    class Akcioner implements View.OnClickListener
    {
        int mem;//number for button, all should be unique
        Akcioner(int memIn)
        {
            mem = memIn;
        }

        public void onClick(View view) {
            //Toast.makeText(getApplicationContext(), buttonList.get(63).getTooltipText(), Toast.LENGTH_SHORT).show();

            //System.out.println(mem);
            if (!admin.isSelected())
            {

                admin.select(mem);
            }
            else if (admin.isSelected()) // after we have chosen legal place with piece, after we touch it again it returns to basic form
            {
                admin.selectMove(mem,queue);
            }
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case 1: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    System.out.println(result);
                    speech.setText(result.get(0));
                    int[] move = {0,0,0,0};
                    try
                    {   int a = 0;
                        int b = 0;
                        while (move[3]==0)
                        {
                            if(result.get(0).charAt(a)-'0'>=0&&result.get(0).charAt(a)-'0'<=7)
                            {
                                move[b] = result.get(0).charAt(a)-'0';
                                b++;

                            }a++;
                        }
                    }
                    catch (Exception e)
                    {
                    }
                    System.out.println(move[0] +" dddd " + move[1]);
                    System.out.println(move[2] +" dddd " + move[3]);
                    if (admin.forceMove(move[0],move[1],move[2],move[3]))
                    {
                        System.out.println("wrong cordinates");
                    }
                }
                /*if (resultCode == RESULT_CANCELED) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    System.out.println(result);
                    speech.setText(result.get(0));
                    int row = result.get(0).charAt(0)-'0';
                    int col = result.get(0).charAt(1)-'0';
                    movement.legalMoves(row,col,board[row][col].charAt(0),board[row][col].charAt(1),board);
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
                }*/
                break;
            }
        }
    }
}
