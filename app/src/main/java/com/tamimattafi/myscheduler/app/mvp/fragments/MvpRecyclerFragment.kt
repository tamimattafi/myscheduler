package com.tamimattafi.myscheduler.app.mvp.fragments

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerController
import com.tamimattafi.myscheduler.app.ui.fragments.global.NavigationContract
import kotlinx.android.synthetic.main.fragment_recycler.*
import javax.inject.Inject

abstract class MvpRecyclerFragment<HOLDER : MvpRecyclerContract.Holder,
        PRESENTER : MvpRecyclerContract.Presenter<HOLDER>,
        ADAPTER : MvpRecyclerContract.Adapter<HOLDER>> : NavigationContract.NavigationFragment(),
    MvpRecyclerContract.View<HOLDER> {

    @Inject
    lateinit var presenter: PRESENTER

    @Inject
    lateinit var adapter: ADAPTER

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.attachToController(MvpRecyclerController(recycler, this))
    }

    override fun loadMoreData() {
        presenter.loadMoreRecyclerData()
    }

    override fun bindViewHolder(holder: HOLDER) {
        presenter.bindViewHolder(holder)
    }

    override fun getRecyclerAdapter(): MvpRecyclerContract.Adapter<HOLDER> = adapter

    override fun showError(message: String) {
        Snackbar.make(view!!, message, Snackbar.LENGTH_LONG).show()
    }


}