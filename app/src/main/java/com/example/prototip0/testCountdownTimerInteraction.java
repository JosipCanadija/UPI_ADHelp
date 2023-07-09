package com.example.prototip0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;

public class testCountdownTimerInteraction {
    @Test
    public void countdownTimerInteraction() throws InterruptedException {
        MainActivity activity = new MainActivity();

        activity.onCreate(new Bundle());

        TextView textView = activity.findViewById(R.id.mojTimer);
        Button button = activity.findViewById(R.id.button2);

        assertNotNull(textView);
        assertNotNull(button);

        button.performClick();

        Thread.sleep(1200000);

        String timeAfterCountdown = textView.getText().toString();
        assertEquals("00:01", timeAfterCountdown);

        Thread.sleep(1000);

        String finalTime = textView.getText().toString();
        assertEquals("00:00", finalTime);
    }
}
