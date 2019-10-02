package com.tamimattafi.myscheduler.app.mvp

interface BaseContract {

    interface Presenter {
        fun onPause()
        fun onResume()
    }
}