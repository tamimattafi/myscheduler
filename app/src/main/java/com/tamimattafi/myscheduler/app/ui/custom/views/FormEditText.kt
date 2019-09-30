package com.tamimattafi.myscheduler.app.ui.custom.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.utils.AppUtils

class FormEditText(context: Context, attributeSet: AttributeSet) :
    TextInputEditText(context, attributeSet) {
    override fun getBackground(): Drawable =
        AppUtils.getDrawable(context, R.drawable.background_edit_text_field)
            ?: super.getBackground()
}