package com.tamimattafi.myscheduler.app.ui.fragments.main.search

import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.empty.EmptyHolderList
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchContract.View
import javax.inject.Inject

class SearchAdapter @Inject constructor(view: View) : SearchContract.Adapter(view) {

    override fun getNoDataHolderType(): Int = EmptyHolderList.SEARCH

}