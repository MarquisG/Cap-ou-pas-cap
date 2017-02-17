package com.guillaume_marquis.gage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pers1 = null;
    private EditText pers2 = null;
    private EditText pers3 = null;
    private EditText pers4 = null;
    private EditText pers5 = null;
    private EditText pers6 = null;
    private EditText pers7 = null;
    private EditText pers8 = null;
    private Button b = null;
    private String[] name = new String[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar nb_participant = (SeekBar) findViewById(R.id.seekBar);
        int seekBarValue= nb_participant.getProgress() + 2;

        final TextView textView = (TextView) findViewById(R.id.textView);

        textView.setText(String.valueOf(seekBarValue));

        pers1 = (EditText) findViewById(R.id.pers1);
        pers2 = (EditText) findViewById(R.id.pers2);
        pers3 = (EditText) findViewById(R.id.pers3);
        pers4 = (EditText) findViewById(R.id.pers4);
        pers5 = (EditText) findViewById(R.id.pers5);
        pers6 = (EditText) findViewById(R.id.pers6);
        pers7 = (EditText) findViewById(R.id.pers7);
        pers8 = (EditText) findViewById(R.id.pers8);


        b = (Button)findViewById(R.id.button4);

        b.setOnClickListener(this);

        nb_participant.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                textView.setText(String.valueOf(nb_participant.getProgress()+2));

                for(int i=1; i<=nb_participant.getProgress()+2; i++) {

                    String edittext = "pers" + String.valueOf(i);


                }

                switch (nb_participant.getProgress()+2) {

                    case 2:
                        pers2.setVisibility(View.VISIBLE);
                        pers3.setVisibility(View.INVISIBLE);
                        pers4.setVisibility(View.INVISIBLE);
                        pers5.setVisibility(View.INVISIBLE);
                        pers6.setVisibility(View.INVISIBLE);
                        pers7.setVisibility(View.INVISIBLE);
                        pers8.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        pers2.setVisibility(View.VISIBLE);
                        pers3.setVisibility(View.VISIBLE);
                        pers4.setVisibility(View.INVISIBLE);
                        pers5.setVisibility(View.INVISIBLE);
                        pers6.setVisibility(View.INVISIBLE);
                        pers7.setVisibility(View.INVISIBLE);
                        pers8.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        pers2.setVisibility(View.VISIBLE);
                        pers3.setVisibility(View.VISIBLE);
                        pers4.setVisibility(View.VISIBLE);
                        pers5.setVisibility(View.INVISIBLE);
                        pers6.setVisibility(View.INVISIBLE);
                        pers7.setVisibility(View.INVISIBLE);
                        pers8.setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        pers2.setVisibility(View.VISIBLE);
                        pers3.setVisibility(View.VISIBLE);
                        pers4.setVisibility(View.VISIBLE);
                        pers5.setVisibility(View.VISIBLE);
                        pers6.setVisibility(View.INVISIBLE);
                        pers7.setVisibility(View.INVISIBLE);
                        pers8.setVisibility(View.INVISIBLE);
                        break;
                    case 6:
                        pers2.setVisibility(View.VISIBLE);
                        pers3.setVisibility(View.VISIBLE);
                        pers4.setVisibility(View.VISIBLE);
                        pers5.setVisibility(View.VISIBLE);
                        pers6.setVisibility(View.VISIBLE);
                        pers7.setVisibility(View.INVISIBLE);
                        pers8.setVisibility(View.INVISIBLE);
                        break;
                    case 7:
                        pers2.setVisibility(View.VISIBLE);
                        pers3.setVisibility(View.VISIBLE);
                        pers4.setVisibility(View.VISIBLE);
                        pers5.setVisibility(View.VISIBLE);
                        pers6.setVisibility(View.VISIBLE);
                        pers7.setVisibility(View.VISIBLE);
                        pers8.setVisibility(View.INVISIBLE);
                        break;
                    case 8:
                        pers2.setVisibility(View.VISIBLE);
                        pers3.setVisibility(View.VISIBLE);
                        pers4.setVisibility(View.VISIBLE);
                        pers5.setVisibility(View.VISIBLE);
                        pers6.setVisibility(View.VISIBLE);
                        pers7.setVisibility(View.VISIBLE);
                        pers8.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }


        });


    }


    @Override
    public void onClick(View v) {

        if(pers1.getText().toString().matches("") || pers2.getText().toString().matches(""))
        {
            Context context = getApplicationContext();
            CharSequence text = "Il faut au minimum 2 joueurs !";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        else {
            name[0] = pers1.getText().toString();
            name[1] = pers2.getText().toString();
            name[2] = pers3.getText().toString();
            name[3] = pers4.getText().toString();
            name[4] = pers5.getText().toString();
            name[5] = pers6.getText().toString();
            name[6] = pers7.getText().toString();
            name[7] = pers8.getText().toString();

            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("participants", name);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
    }
}

