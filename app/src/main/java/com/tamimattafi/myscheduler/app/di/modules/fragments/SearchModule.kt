package com.tamimattafi.myscheduler.app.di.modules.fragments

import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchAdapter
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchContract.*
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchFragment
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class SearchModule {

    @Binds
    abstract fun bindView(fragment: SearchFragment): View

    @Binds
    abstract fun bindPresenter(presenter: SearchPresenter): Presenter

    @Binds
    abstract fun bindAdapter(adapter: SearchAdapter): Adapter

}