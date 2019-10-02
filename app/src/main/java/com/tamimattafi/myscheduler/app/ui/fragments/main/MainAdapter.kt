package com.tamimattafi.myscheduler.app.ui.fragments.main

import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.empty.EmptyHolderList
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.Adapter
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.View
import javax.inject.Inject

class MainAdapter @Inject constructor(view: View) : Adapter(view) {

    override fun getNoDataHolderType(): Int = EmptyHolderList.DATA

}