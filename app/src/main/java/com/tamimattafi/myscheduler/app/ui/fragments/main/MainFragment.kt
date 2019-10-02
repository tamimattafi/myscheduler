package com.tamimattafi.myscheduler.app.ui.fragments.main

import android.os.Bundle
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.fragments.global.Visibility
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.fragment.BaseRoutineFragment
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.Actions
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.*
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineFragment
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainFragment : BaseRoutineFragment<Presenter, Adapter>(), View {

    override var fragmentName: String = "fragment-main"
    override val layoutId: Int = R.layout.fragment_main

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search.setOnClickListener {
            navigationManager.requestSlideLeftScreen(SearchFragment())
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

    override fun onHolderAction(listPosition: Int, adapterPosition: Int, action: Int) {
        if (action == Actions.ACTION_CREATE) addRoutine()
        else super.onHolderAction(listPosition, adapterPosition, action)
    }

    private fun addRoutine() {
        navigationManager.requestSlideLeftScreen(AddRoutineFragment())
    }


}