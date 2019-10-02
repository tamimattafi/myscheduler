package com.tamimattafi.myscheduler.app.di.modules.fragments

import com.tamimattafi.myscheduler.app.ui.fragments.main.MainFragment
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineFragment
import com.tamimattafi.myscheduler.app.ui.fragments.main.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragments {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainFragment(): MainFragment

    @ContributesAndroidInjector(modules = [AddRoutineModule::class])
    abstract fun addRoutineFragment(): AddRoutineFragment

    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun searchFragment(): SearchFragment

}