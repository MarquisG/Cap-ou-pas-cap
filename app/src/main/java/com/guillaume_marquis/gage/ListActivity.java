package com.guillaume_marquis.gage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1 = null;
    private Button b2 = null;
    private String[] participants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent0 = getIntent();
        participants = intent0.getStringArrayExtra("participants");

        b1 = (Button)findViewById(R.id.button7);
        b2 = (Button)findViewById(R.id.button6);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button7:
                Intent intent1 = new Intent(this, GameActivity.class);
                intent1.putExtra("participants", participants);
                intent1.putExtra("mode", 1);
                startActivity(intent1);
                break;

            case R.id.button6:
                Intent intent2 = new Intent(this, GameActivity.class);
                intent2.putExtra("participants", participants);
                intent2.putExtra("mode", 2);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
