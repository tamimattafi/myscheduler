package com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerAdapter
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.HoldersContract
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.MainRoutineHolder

abstract class BaseRoutineAdapter(view: MvpRecyclerContract.View<HoldersContract.RoutineHolder>) :
    MvpRecyclerAdapter<HoldersContract.RoutineHolder>(view) {

    override fun getItemHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        MainRoutineHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view_holder_main_routine,
                parent,
                false
            )
        )

}