package com.example.prototip0;

import static org.junit.Assert.assertNotNull;

import android.widget.TextView;

import org.junit.Test;

public class testTextViewInitialization {
    @Test
    public void textViewInitialization() {
        MainActivity activity = new MainActivity();
        TextView textView = new TextView(activity);
        assertNotNull(textView);
    }
}
