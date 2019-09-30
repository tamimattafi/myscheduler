package com.tamimattafi.myscheduler.app.ui.fragments.main

import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerPresenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.*
import com.tamimattafi.myscheduler.model.Routine
import javax.inject.Inject

class MainPresenter @Inject constructor(view: View) :
    MvpRecyclerPresenter<Routine, View, RoutineHolder>(view), Presenter {

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