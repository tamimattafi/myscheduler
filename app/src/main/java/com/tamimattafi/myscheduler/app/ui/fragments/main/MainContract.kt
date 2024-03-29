package com.tamimattafi.myscheduler.app.ui.fragments.main

import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.adapters.BaseRoutineAdapter
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.HoldersContract.RoutineHolder

interface MainContract {

    interface View : MvpRecyclerContract.View<RoutineHolder>

    interface Presenter : MvpRecyclerContract.Presenter<RoutineHolder>

    abstract class Adapter(view: View) : BaseRoutineAdapter(view)

}