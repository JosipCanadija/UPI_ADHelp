package com.example.prototip0;

import static org.junit.Assert.assertNotNull;

import android.os.CountDownTimer;

import org.junit.Test;

public class testCountDownTimerCreation {
    @Test
    public void countDownTimerCreation() {
        MainActivity activity = new MainActivity();
        CountDownTimer timer = new CountDownTimer(1200000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
            }
        };
        assertNotNull(timer);
    }
}
