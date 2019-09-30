package com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine

import android.content.Context
import com.tamimattafi.myscheduler.R
import java.util.*

object AddRoutineValues {

    fun getImportanceList(context: Context): ArrayList<String> =
        ArrayList(context.resources.getStringArray(R.array.Importance).toList())

    fun getDaysList(context: Context): ArrayList<String> =
        ArrayList(context.resources.getStringArray(R.array.Days).toList())

    fun getMinDays(context: Context): Int = context.resources.getInteger(R.integer.min_days)

}