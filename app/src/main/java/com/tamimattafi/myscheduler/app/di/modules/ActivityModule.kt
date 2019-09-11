package com.tamimattafi.myscheduler.app.di.modules

import android.app.Activity
import com.tamimattafi.myscheduler.app.MainActivity
import com.tamimattafi.myscheduler.app.ui.fragments.global.NavigationContract
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @Binds
    abstract fun bindNavigationManager(mainActivity: MainActivity): NavigationContract.NavigationManager

    @Binds
    abstract fun bindActivity(mainActivity: MainActivity): Activity
}