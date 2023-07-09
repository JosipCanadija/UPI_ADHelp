package com.example.prototip0;

import static org.junit.Assert.assertNotNull;

import android.widget.Button;

import org.junit.Test;

public class testButtonClickListener {
    @Test
    public void buttonClickListener() {
        MainActivity activity = new MainActivity();
        Button button = new Button(activity);
        assertNotNull(button);

        button.performClick();

    }
}
