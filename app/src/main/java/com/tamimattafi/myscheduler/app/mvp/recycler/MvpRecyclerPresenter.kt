package com.tamimattafi.myscheduler.app.mvp.recycler

import com.tamimattafi.myscheduler.app.mvp.BasePresenter
import com.tamimattafi.myscheduler.repository.global.RepositoryContract
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

abstract class MvpRecyclerPresenter<T,
        VIEW : MvpRecyclerContract.View<HOLDER>,
        HOLDER : MvpRecyclerContract.Holder>(override var view: VIEW) : BasePresenter<VIEW>(view),
    MvpRecyclerContract.Presenter<HOLDER> {

    @Inject
    protected lateinit var repository: RepositoryContract.Base<T>

    protected lateinit var data: Flowable<List<T>>
    protected var dataList: ArrayList<T> = ArrayList()
        set(value) {
            field = value
            onDataListChanged()
        }

    override fun loadMoreRecyclerData() {
        with(view.getRecyclerAdapter()) {
            if (!isLoading) {

                isLoading = true

                repository.getData().setOnSuccessListener { newData ->
                    data = (if (::data.isInitialized) {
                        Flowable.merge(data, newData)
                    } else newData).apply {
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
                }.setOnFailureListener {
                    view.showError(it)
                }

            }

        }
    }

    override fun onDestroyView() {
        repository.stopListening()
        super.onDestroyView()
    }

    override fun onDestroy() {
        onDestroyView()
        dataList.clear()
    }

    open fun onDataListChanged() {
        view.getRecyclerAdapter().setDataCount(dataList.size)
    }

}