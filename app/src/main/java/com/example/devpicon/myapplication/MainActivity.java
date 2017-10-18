package com.example.devpicon.myapplication;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.devpicon.android.numerickeyboardlib.NumberPadKeyboardActionListener;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    RelativeLayout relativeLayout;
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("UnTAG", "brbrbrbr");

        edtText = (EditText) findViewById(R.id.edt_input);
        relativeLayout = (RelativeLayout) findViewById(R.id.my_relative_layout);
        edtText.setOnTouchListener(this);

    }

    private void createKeyboard() {
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(new NumberPadKeyboardActionListener(edtText));
        relativeLayout.addView(keyboardView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.edt_input:
                createKeyboard();
                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(android.content.Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromInputMethod(getWindow().getDecorView().getRootView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                edtText.requestFocus();
                relativeLayout.setVisibility(View.VISIBLE);
                break;
        }
        return true;
    }
}
