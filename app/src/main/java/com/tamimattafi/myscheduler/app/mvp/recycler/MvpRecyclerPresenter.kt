package com.tamimattafi.myscheduler.app.mvp.recycler

import android.annotation.SuppressLint
import com.tamimattafi.myscheduler.app.mvp.BasePresenter
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract.*
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.Base
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

abstract class MvpRecyclerPresenter<T,
        VIEW : View<HOLDER>,
        HOLDER : Holder,
        REPOSITORY : Base<T>>(override var view: VIEW) : BasePresenter<VIEW>(view),
    Presenter<HOLDER> {

    @Inject
    protected lateinit var repository: REPOSITORY

    protected var data: Flowable<List<T>>? = null
    protected var dataList: ArrayList<T> = ArrayList()
        set(value) {
            field = value
            onDataListChanged()
        }

    override fun loadRecyclerData() {
        with(view.getRecyclerAdapter()) {
            if (!isLoading) {
                isLoading = true
                repository.getData().setOnSuccessListener { data ->
                    this@MvpRecyclerPresenter.data = data
                    subscribe()
                }.setOnFailureListener {
                    view.showError(it)
                }
            }
        }
    }

    private fun subscribe() {
        with(view.getRecyclerAdapter()) {
            data?.apply {
                subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError {
                        isLoading = false
                        view.showError(it.localizedMessage ?: it.toString())
                    }.doOnNext { list ->
                        isLoading = true
                        dataList = ArrayList(list)
                        isLoading = false
                    }
                    .subscribe()
            }
        }
    }

    @SuppressLint("CheckResult")
    override fun onPause() {
        repository.stopListening()
        dataList.clear()
        data?.unsubscribeOn(Schedulers.io())
    }

    override fun onResume() {
        subscribe()
    }


    open fun onDataListChanged() {
        view.getRecyclerAdapter().setDataCount(dataList.size)
    }


}