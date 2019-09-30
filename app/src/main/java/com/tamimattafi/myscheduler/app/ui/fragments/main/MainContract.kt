package com.tamimattafi.myscheduler.app.ui.fragments.main

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerAdapter
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract

interface MainContract {

    interface RoutineHolder : MvpRecyclerContract.Holder {
        fun setName(name: String)
        fun setDescription(description: String)
        fun setActive(isActive: Boolean)
        fun setIconVector(@DrawableRes vector: Int)
        fun setIconBackground(@DrawableRes background: Int)
        fun setIconTint(@ColorRes tint: Int)
    }

    interface View : MvpRecyclerContract.View<RoutineHolder>

    interface Presenter : MvpRecyclerContract.Presenter<RoutineHolder>

    abstract class Adapter(view: View) : MvpRecyclerAdapter<RoutineHolder>(view)

}