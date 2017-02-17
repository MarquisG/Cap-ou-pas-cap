package com.guillaume_marquis.gage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text = null;
    private Button b1 = null;
    private Button b2 = null;
    private int ack = 0;
    private int fail = 0;
    private int random = 0;
    private int p1 = 0;
    private int p2 = 0;
    private int nb_participant = 0;
    private int mode;
    String[] participants;
    String[] defis_soft = {"chanter une chanson accapella",
                        "se faire prendre en photo dans une position définie par les autres",
                        "faire la macarena à l'envers",
                        "faire un discours présidentiel sans utiliser un lettre définie par les autres",
                        "faire du pole dance autour d'un lampadaire",
                        "boire un cocktail préparé par les autres",
                        "faire dix tours sur lui-même avec un balai",
                        "faire un moonwalk",
                        "manger une cuillère de cannelle",
                        "imiter un animal",
                        "faire une démonstration de air guitare",
                        "boire un cocktail préparé par les autres",
                        "appeler un numéro au hasard et tenir la conversation le plus longtemps possible",
                        "raconter une blague avec un accent chinoi",
                        "se renverser un verre d'eau sur la tête",
                        "boire son verre cul sec"
                        };
    String[] defis_hard = {"enlever un vêtement à ",
                        "faire une déclaration d’amour à ",
                        "faire une démonstration de sexe avec ",
                        "echanger ses vêtements avec ",
                        "faire un bisous sur l'oeil de ",
                        "toucher le ventre de ",
                        "lécher l'oreil de ",
                        "signer son autographe sur la fesse de ",
                        "twitter qu'il/elle aime ",
                        "embrasser sur la bouche ",
                        "mettre une fessée à ",
                        "se faire maquiller par ",
                        "se faire épiler un partie du corps par ",
                        "se faire masser l'entrecuisse par ",
                        "faire un strip-tease pour ",
                        "décrire en détail comment il/elle ferait l'amour avec "
                        };
    private int nb_defis = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        participants = intent.getStringArrayExtra("participants");
        mode = intent.getIntExtra("mode", 0);

        int i = 0;
        for(i=0; i<8; i++){
            if(participants[i].matches("")){
                break;
            }
        }

        nb_participant = i;


        Random r = new Random();

        if(mode == 1) {
            random = r.nextInt(defis_soft.length);
            p1 = r.nextInt(nb_participant);
            text = (TextView) findViewById(R.id.textView3);
            text.setText(String.valueOf(participants[p1]) + " doit " + String.valueOf(defis_soft[random]));
            defis_soft[random] = "";

        }
        else if(mode ==2) {
            random = r.nextInt(defis_hard.length);
            p1 = r.nextInt(nb_participant);
            while(true) {
                p2 = r.nextInt(nb_participant);
                if(p2!=p1){
                    break;
                }
            }
            text = (TextView) findViewById(R.id.textView3);
            text.setText(String.valueOf(participants[p1]) + " doit " + String.valueOf(defis_hard[random]) + String.valueOf(participants[p2]));
            defis_hard[random] = "";
        }


        b1 = (Button)findViewById(R.id.button3);
        b2 = (Button)findViewById(R.id.button5);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);


    }

    private void gage(){


        Random r = new Random();

        if(mode==1){

            while(true) {
                random = r.nextInt(defis_soft.length);
                if(defis_soft[random]!=""){
                    break;
                }
            }
            p1 = r.nextInt(nb_participant);
            text.setText(String.valueOf(participants[p1]) + " doit " + String.valueOf(defis_soft[random]));
            defis_soft[random]="";
        }
        else if(mode==2) {
            while(true) {
                random = r.nextInt(defis_hard.length);
                if(defis_hard[random]!=""){
                    break;
                }
            }
            p1 = r.nextInt(nb_participant);
            while(true) {
                p2 = r.nextInt(nb_participant);
                if(p2!=p1){
                    break;
                }
            }
            text.setText(String.valueOf(participants[p1]) + " doit " + String.valueOf(defis_hard[random]) + String.valueOf(participants[p2]));
            defis_hard[random]="";
        }





    }

    public void finish(){

        Intent intent = new Intent(this, EndActivity.class);
        intent.putExtra("ack", ack);
        intent.putExtra("fail", fail);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                ack++;
                if(ack+fail == defis_soft.length){
                    this.finish();
                }
                else {
                    this.gage();
                }
                break;

            case R.id.button5:
                fail++;
                if(ack+fail == defis_hard.length){
                    this.finish();
                }
                else {
                    this.gage();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
