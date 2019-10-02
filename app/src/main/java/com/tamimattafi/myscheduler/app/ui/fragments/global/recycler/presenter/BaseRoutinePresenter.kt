package com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.presenter

import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract.View
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerPresenter
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.HoldersContract.RoutineHolder
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.Base

abstract class BaseRoutinePresenter<VIEW : View<RoutineHolder>, REPOSITORY : Base<Routine>>(view: VIEW) :
    MvpRecyclerPresenter<Routine, VIEW, RoutineHolder, REPOSITORY>(view) {

    override fun bindViewHolder(holder: RoutineHolder) {
        with(holder) {
            dataList[listPosition].apply {
                setName(name)
                setDescription(description)
                setActive(isActive)
            }
        }
    }

    override fun onDataListChanged() {
        view.getRecyclerAdapter().setDataCount(dataList.size)
        super.onDataListChanged()
    }
}