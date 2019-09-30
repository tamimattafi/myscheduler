package com.tamimattafi.myscheduler.app.ui.custom.dialogs.sub

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.custom.dialogs.base.SelectionAdapter
import com.tamimattafi.myscheduler.app.ui.custom.dialogs.base.SelectionDialog
import com.tamimattafi.myscheduler.app.ui.custom.holders.dialog.SimpleStringItemHolder

class StringSelectionDialog(context: Context?) :
    SelectionDialog<String, SimpleStringItemHolder>(context, 1) {
    override fun getSelectionAdapter(
        data: ArrayList<String>,
        listener: (item: String) -> Unit
    ): SelectionAdapter<String, SimpleStringItemHolder> = StringSelectionAdapter(data, listener)

    inner class StringSelectionAdapter(
        data: ArrayList<String>, listener: (item: String) -> Unit
    ) : SelectionAdapter<String, SimpleStringItemHolder>(data, listener) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            SimpleStringItemHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_view_holder_simple_string,
                    parent,
                    false
                )
            )

    }

}