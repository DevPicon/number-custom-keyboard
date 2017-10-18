package com.devpicon.android.numerickeyboardlib

import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.text.TextUtils
import android.util.Log
import android.widget.EditText

/**
 * Created by devpicon on 10/18/17.
 */
public class NumberPadKeyboardActionListener(val editText: EditText) : KeyboardView.OnKeyboardActionListener {

    private val TAG = "NumberPadKeyboard"

    override fun swipeRight() {
    }

    override fun onPress(p0: Int) {
    }

    override fun onRelease(p0: Int) {
    }

    override fun swipeLeft() {
    }

    override fun swipeUp() {
    }

    override fun swipeDown() {
    }

    val KEYCODE_DOT: Int = 46

    override fun onKey(primaryCode: Int, keyCodes: IntArray) {

        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> {
                val selectedText: CharSequence = editText.text
                Log.d(TAG, "selected={$selectedText}")
                if (TextUtils.isEmpty(selectedText)) {
                    editText.setText("")
                } else {
                    editText.requestFocus()
                    editText.setText("")
                    editText.append(selectedText.subSequence(0, selectedText.length - 1))

                }
            }
            else -> {
                val code: Char = primaryCode.toChar()
                val selectedText: CharSequence = editText.text
                if (code.equals('.') && selectedText.contains(code)) {
                    return
                }
                editText.append(code.toString())
            }
        }

    }

    override fun onText(p0: CharSequence?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}