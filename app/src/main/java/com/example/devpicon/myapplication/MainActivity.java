package com.example.devpicon.myapplication;

import android.app.Activity;
import android.content.Context;
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
import android.widget.Toast;

import com.devpicon.android.numerickeyboardlib.CustomeEditText;
import com.devpicon.android.numerickeyboardlib.DoneActionListener;
import com.devpicon.android.numerickeyboardlib.NumberKeyboard;
import com.devpicon.android.numerickeyboardlib.NumberPadKeyboardActionListener;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, DoneActionListener {

    RelativeLayout relativeLayout;
    CustomeEditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtText = (CustomeEditText) findViewById(R.id.edt_input);
        relativeLayout = (RelativeLayout) findViewById(R.id.my_relative_layout);
        edtText.setOnTouchListener(this);
        edtText.setContainer(relativeLayout);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.edt_input:
                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromInputMethod(edtText.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(edtText.getWindowToken(), 0);

                relativeLayout.addView(NumberKeyboard.INSTANCE.createKeyboard(this, getLayoutInflater(), edtText, relativeLayout, null));
                edtText.requestFocus();
                relativeLayout.setVisibility(View.VISIBLE);
                break;
        }
        return true;
    }

    @Override
    public void done() {
        Toast.makeText(this, "Hice done!", Toast.LENGTH_SHORT).show();
    }
}
