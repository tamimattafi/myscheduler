package com.tamimattafi.myscheduler.app.ui.custom.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.utils.AppUtils

class FormInput(context: Context, attributeSet: AttributeSet) :
    TextInputEditText(context, attributeSet) {
    override fun getBackground(): Drawable =
        AppUtils.getDrawable(context, R.drawable.background_edit_text_field)
            ?: super.getBackground()

    fun addTextListener(onTextChange: (text: String?) -> Unit) {
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onTextChange.invoke(if (s.isNullOrEmpty()) null else s.toString())
            }
        })
    }
}