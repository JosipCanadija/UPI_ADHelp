package com.example.prototip0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import static java.util.regex.Pattern.matches;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.runner.AndroidJUnit4;

import com.google.firebase.firestore.util.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DecimalFormat;
import java.text.NumberFormat;



public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    EditText task;
    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById (R.id.mojTimer);
        button= (Button) findViewById(R.id.button2);
        task = (EditText) findViewById(R.id.task);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(1200000, 1000){
                    public void onTick(long millisUntilFinished){
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        textView.setText(f.format(min) + ":" + f.format(sec));
                    }
                    public  void onFinish(){
                        textView.setText("00:00");
                    }
                }.start();
            }
        });
    }
}