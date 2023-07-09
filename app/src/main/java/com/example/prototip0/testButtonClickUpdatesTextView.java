package com.example.prototip0;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;

public class testButtonClickUpdatesTextView {
    @Test
    public void buttonClickUpdatesTextView() {
        MainActivity activity = new MainActivity();
        Button button = activity.findViewById(R.id.button2);
        TextView textView = activity.findViewById(R.id.mojTimer);

        assertNotNull(button);
        assertNotNull(textView);

        button.performClick();

        String currentTime = textView.getText().toString();
        assertNotNull(currentTime);
        assertNotEquals("00:00", currentTime);
    }
}
