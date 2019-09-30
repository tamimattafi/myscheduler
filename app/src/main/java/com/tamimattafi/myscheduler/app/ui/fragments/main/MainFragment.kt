package com.tamimattafi.myscheduler.app.ui.fragments.main

import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.mvp.fragments.MvpRecyclerFragment
import com.tamimattafi.myscheduler.app.ui.custom.holders.Actions
import com.tamimattafi.myscheduler.app.ui.fragments.global.Visibility
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.*
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : MvpRecyclerFragment<RoutineHolder, Presenter, Adapter>(), View {

    override var fragmentName: String = "fragment-main"
    override val layoutId: Int = R.layout.fragment_main


    override fun onHolderClick(listPosition: Int, adapterPosition: Int) {

    }

    override fun onHolderLongClick(listPosition: Int, adapterPosition: Int) {

    }

    override fun onHolderAction(listPosition: Int, adapterPosition: Int, action: Int) {
        with(Actions) {
            when (action) {
                ACTION_CREATE -> addRoutine()
            }
        }
    }

    override fun onRecyclerDataChanged(dataCount: Int) {
        with(Visibility) {
            fab.apply {
                visibility = if (dataCount > 0) VISIBLE else GONE
                setOnClickListener { addRoutine() }
            }
        }
    }

    private fun addRoutine() {
        navigationManager.requestSlideLeftScreen(AddRoutineFragment())
    }

}