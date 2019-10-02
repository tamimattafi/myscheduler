package com.tamimattafi.myscheduler.app.ui.fragments.main.search

import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.adapters.BaseRoutineAdapter
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.HoldersContract.RoutineHolder

interface SearchContract {

    interface View : MvpRecyclerContract.View<RoutineHolder>

    interface Presenter : MvpRecyclerContract.Presenter<RoutineHolder> {
        fun updateQuery(query: String?)
    }

    abstract class Adapter(view: View) : BaseRoutineAdapter(view)

}