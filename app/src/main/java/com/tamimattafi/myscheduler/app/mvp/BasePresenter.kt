package com.tamimattafi.myscheduler.app.mvp


abstract class BasePresenter<V> protected constructor(open var view: V) : BaseContract.Presenter {

    override fun onPause() {}

    override fun onResume() {}

}