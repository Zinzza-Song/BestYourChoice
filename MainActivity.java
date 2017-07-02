package com.example.goople4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.Button1);
        btn.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       Intent intent = new Intent(MainActivity.this, MarkerDemoActivity.class);
                                       startActivity(intent);
                                   }

                               }
        );
        Button btn2 = (Button) findViewById(R.id.Button2);
        btn2.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       Intent intent = new Intent(MainActivity.this, selfrandom6.class);
                                       startActivity(intent);
                                   }

                               }
        );

        Button btn3 = (Button) findViewById(R.id.Button3);
        btn3.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        Intent intent = new Intent(MainActivity.this, notice8.class);
                                        startActivity(intent);
                                    }

                                }
        );

        Button btn4 = (Button) findViewById(R.id.Button4);
        btn4.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        Intent intent = new Intent(MainActivity.this, version9.class);
                                        startActivity(intent);
                                    }

                                }
        );
    }

}
