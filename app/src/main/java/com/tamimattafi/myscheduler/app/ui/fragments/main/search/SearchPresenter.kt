package com.tamimattafi.myscheduler.app.ui.fragments.main.search

import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.presenter.BaseRoutinePresenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchContract.Presenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchContract.View
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.SearchBase
import javax.inject.Inject

class SearchPresenter @Inject constructor(view: View) :
    BaseRoutinePresenter<View, SearchBase<Routine>>(view), Presenter {

    override fun updateQuery(query: String?) {
        repository.updateSearchQuery(query)
        query?.let { loadRecyclerData() } ?: clear()
    }

    private fun clear() {
        onPause()
        onDataListChanged()
    }

}