package com.example.prototip0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import static java.util.regex.Pattern.matches;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
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
    Button add;
    AlertDialog dialog;
    LinearLayout layout;

    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.mojTimer);
        button = (Button) findViewById(R.id.button2);
        button.bringToFront();
        add = findViewById(R.id.addButton);
        layout = findViewById(R.id.container);

        buildDialog();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(1200000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;
                        textView.setText(f.format(min) + ":" + f.format(sec));
                    }

                    public void onFinish() {
                        textView.setText("00:00");
                    }
                }.start();
            }
        });
    }


        private void buildDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = getLayoutInflater().inflate(R.layout.dialog, null);

            EditText task = view.findViewById(R.id.taskEdit);

            builder.setView(view);
            builder.setTitle("Enter Task")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            addCard(task.getText().toString());
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            dialog = builder.create();
        }




    private void addCard(String task) {
        View view = getLayoutInflater().inflate(R.layout.card, null);
        TextView taskView = view.findViewById(R.id.task);
        Button delete = view.findViewById(R.id.delete);

        taskView.setText(task);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(view);
            }
        });
        layout.addView(view);
    }


}