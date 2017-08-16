package com.example.xyzskylake.extend;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtlogin,txtsign;
    LinearLayout sign,login;
    ImageView RegisterCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtlogin = (TextView) findViewById(R.id.txtlogin);
        txtsign = (TextView) findViewById(R.id.txtsign);
        login = (LinearLayout)findViewById(R.id.login) ;
        sign = (LinearLayout)findViewById(R.id.sign);
        View Button = findViewById(R.id.btnlogin);
        RegisterCompany = (ImageView)findViewById(R.id.company);

        Button.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(),HomeActivity.class);
                        startActivity(myIntent);
                    }
                }
        );


        RegisterCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });


        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setVisibility(View.VISIBLE);
                if (login.getVisibility() == View.VISIBLE) {
                    sign.setVisibility(View.GONE);
                    txtlogin.setTextColor(Color.parseColor("#000000"));
                    txtsign.setTextColor(Color.parseColor("#BDBDBD"));
                    }
                }
        });

        txtsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign.setVisibility(View.VISIBLE);
                if (sign.getVisibility() == View.VISIBLE) {
                    login.setVisibility(View.GONE);
                    txtsign.setTextColor(Color.parseColor("#000000"));
                    txtlogin.setTextColor(Color.parseColor("#BDBDBD"));
                }
            }
        });
    }
}
