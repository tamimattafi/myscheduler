package com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.empty

import android.content.Context
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.Actions

object EmptyHolderList {

    const val DATA = 0
    const val SEARCH = 1


    private fun getList(context: Context): ArrayList<EmptyHolderData> = with(context.resources) {
        ArrayList<EmptyHolderData>()
            .apply {
                add(
                    EmptyHolderData(
                        DATA,
                        R.drawable.ic_snowflake,
                        getString(R.string.no_data),
                        getString(R.string.no_data_yet),
                        Actions.ACTION_CREATE,
                        getString(R.string.create),
                        R.drawable.ic_add
                    )
                )

                add(
                    EmptyHolderData(
                        SEARCH,
                        R.drawable.ic_binoculars,
                        getString(R.string.search),
                        getString(R.string.start_searching_now),
                        Actions.ACTION_SEARCH,
                        getString(R.string.find),
                        R.drawable.ic_search
                    )
                )
            }
    }

    fun getItem(context: Context, itemId: Int): EmptyHolderData =
        getList(context)[itemId]
}