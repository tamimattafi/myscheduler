package com.tamimattafi.myscheduler.app.ui.custom.views

import android.content.Context
import android.util.AttributeSet
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar

class SimpleSeekBar(context: Context, attributeSet: AttributeSet) :
    AppCompatSeekBar(context, attributeSet) {


    fun setOnProgressChangeListener(onProgressChange: (progress: Int) -> Unit) {
        onProgressChange.invoke(progress)
        setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                onProgressChange.invoke(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}