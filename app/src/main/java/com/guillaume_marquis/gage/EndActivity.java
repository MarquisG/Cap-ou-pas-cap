package com.guillaume_marquis.gage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EndActivity extends AppCompatActivity implements View.OnClickListener {

    private Button text_ack = null;
    private Button text_fail = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Intent intent = getIntent();
        int ack = intent.getIntExtra("ack", 0);
        int fail = intent.getIntExtra("fail", 0);

        text_ack = (Button) findViewById(R.id.button8);
        text_fail = (Button) findViewById(R.id.button9);

        text_ack.setText("Nombre de réussite : " + String.valueOf(ack));
        text_fail.setText("Nombre de fails : " + String.valueOf(fail));

        text_ack.setOnClickListener(this);
        text_fail.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
