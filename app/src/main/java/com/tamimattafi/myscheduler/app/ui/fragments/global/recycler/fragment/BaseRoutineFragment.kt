package com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.fragment

import com.tamimattafi.myscheduler.app.mvp.fragments.MvpRecyclerFragment
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract.Presenter
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.adapters.BaseRoutineAdapter
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.HoldersContract.RoutineHolder


abstract class BaseRoutineFragment<PRESENTER : Presenter<RoutineHolder>, ADAPTER : BaseRoutineAdapter>
    : MvpRecyclerFragment<RoutineHolder, PRESENTER, ADAPTER>() {

    override fun onHolderClick(listPosition: Int, adapterPosition: Int) {

    }

    override fun onHolderLongClick(listPosition: Int, adapterPosition: Int) {

    }

    override fun onHolderAction(listPosition: Int, adapterPosition: Int, action: Int) {

    }
}