package com.tamimattafi.myscheduler.app.ui.custom.holders.empty

import android.content.Context
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.custom.holders.Actions

object EmptyHolderList {

    const val EMPTY_LIST = 0


    private fun getList(context: Context): ArrayList<EmptyHolderData> = with(context.resources) {
        ArrayList<EmptyHolderData>()
            .apply {
                add(
                    EmptyHolderData(
                        EMPTY_LIST,
                        R.drawable.placeholder_empty,
                        getString(R.string.no_data),
                        getString(R.string.no_data_yet),
                        Actions.ACTION_CREATE,
                        getString(R.string.create)
                    )
                )
            }
    }

    fun getItem(context: Context, itemId: Int): EmptyHolderData =
        getList(context)[itemId]
}