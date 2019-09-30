package com.tamimattafi.myscheduler.app.di.modules.fragments

import com.tamimattafi.myscheduler.app.ui.fragments.main.MainAdapter
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.*
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainFragment
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    abstract fun bindView(mainFragment: MainFragment): View

    @Binds
    abstract fun bindPresenter(mainPresenter: MainPresenter): Presenter

    @Binds
    abstract fun bindAdapter(mainAdapter: MainAdapter): Adapter

}