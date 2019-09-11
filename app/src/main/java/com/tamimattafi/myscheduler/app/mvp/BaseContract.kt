package com.tamimattafi.myscheduler.app.mvp

interface BaseContract {

    interface Presenter {
        fun onDestroyView()
        fun onDestroy()
    }
}