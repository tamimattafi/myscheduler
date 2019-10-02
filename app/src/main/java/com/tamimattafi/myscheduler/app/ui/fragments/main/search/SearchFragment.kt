package com.tamimattafi.myscheduler.app.ui.fragments.main.search

import android.os.Bundle
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.fragment.BaseRoutineFragment
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.Actions
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchContract.*
import com.tamimattafi.myscheduler.utils.KeyboardUtils
import kotlinx.android.synthetic.main.toolbar_search.*

class SearchFragment : BaseRoutineFragment<Presenter, Adapter>(), View {

    override var fragmentName: String = "fragment-search"
    override val layoutId: Int = R.layout.fragment_search

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back.setOnClickListener { navigationManager.requestBackPress() }
        search.addTextListener { presenter.updateQuery(it) }
    }

    private fun openSearch() {
        search.requestFocus()
        KeyboardUtils.show(appActivity)
    }

    override fun onHolderAction(listPosition: Int, adapterPosition: Int, action: Int) {
        if (action == Actions.ACTION_SEARCH) openSearch()
        super.onHolderAction(listPosition, adapterPosition, action)
    }

    override fun startListening() {
        if (!search.text.isNullOrEmpty()) presenter.loadRecyclerData()
        else adapter.setDataCount(0)
    }

}