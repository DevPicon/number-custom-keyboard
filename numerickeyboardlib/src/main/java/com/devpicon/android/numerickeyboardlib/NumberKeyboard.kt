package com.devpicon.android.numerickeyboardlib

import android.content.Context
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.LayoutInflater
import android.view.View

/**
 * Created by devpicon on 10/19/17.
 */
object NumberKeyboard {
    fun createKeyboard(
            context: Context,
            layoutInflater: LayoutInflater,
            customeEditText: CustomeEditText,
            container: View,
            listener: DoneActionListener? = null): KeyboardView {
        val keyboardView = layoutInflater.inflate(R.layout.keyboard_view, null) as KeyboardView
        val keyboard = Keyboard(context, R.xml.number_pad)
        keyboardView.keyboard = keyboard
        keyboardView.isPreviewEnabled = false
        keyboardView.setOnKeyboardActionListener(NumberPadKeyboardActionListener(listener, customeEditText, container))
        return keyboardView
    }
}