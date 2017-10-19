package com.devpicon.android.numerickeyboardlib

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by devpicon on 10/19/17.
 */
class CustomeEditText(val ownContext: Context, val attrs: AttributeSet) : EditText(ownContext, attrs) {

    private var TAG = CustomeEditText::class.java.simpleName

     var container: View? = null


    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            val mgr = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            mgr.hideSoftInputFromWindow(this.windowToken, 0)

            if (container != null) {
                Log.d(TAG, "container is not null")
                return if (container?.visibility == View.GONE) {
                    false
                } else {
                    container?.visibility = View.GONE
                    true
                }
            } else {
                Log.d(TAG, "No se seteó el container")
            }
        }
        return false
    }
}