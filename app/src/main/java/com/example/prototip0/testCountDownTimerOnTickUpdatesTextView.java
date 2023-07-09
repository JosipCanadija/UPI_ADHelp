package com.example.prototip0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.os.CountDownTimer;
import android.widget.TextView;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class testCountDownTimerOnTickUpdatesTextView {
    @Test
    public void countDownTimerOnTickUpdatesTextView() {
        MainActivity activity = new MainActivity();
        TextView textView = activity.findViewById(R.id.mojTimer);
        assertNotNull(textView);

        CountDownTimer timer = new CountDownTimer(1200000, 1000) {
            public void onTick(long millisUntilFinished) {
                NumberFormat f = new DecimalFormat("00");
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText(f.format(min) + ":" + f.format(sec));
            }

            public void onFinish() {
                textView.setText("00:00");
            }
        };
        assertNotNull(timer);

        timer.onTick(60000);

        String updatedTime = textView.getText().toString();
        assertEquals("00:00", updatedTime);
    }
}
