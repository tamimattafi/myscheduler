package com.tamimattafi.myscheduler.app.ui.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.custom.holders.empty.EmptyHolderList
import  com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.Adapter
import  com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.View
import javax.inject.Inject

class MainAdapter @Inject constructor(view: View) : Adapter(view) {

    override fun getItemHolder(parent: ViewGroup): RecyclerView.ViewHolder = MainRoutineHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_view_holder_main_routine,
            parent,
            false
        )
    )


    override fun getNoDataHolderType(): Int = EmptyHolderList.EMPTY_LIST


}