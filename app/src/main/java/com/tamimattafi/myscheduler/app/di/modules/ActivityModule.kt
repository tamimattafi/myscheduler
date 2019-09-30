package com.tamimattafi.myscheduler.app.di.modules

import android.app.Activity
import com.tamimattafi.myscheduler.app.AppActivity
import com.tamimattafi.myscheduler.app.di.modules.fragments.MainFragments
import com.tamimattafi.myscheduler.app.ui.fragments.global.NavigationContract
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainFragments::class])
    abstract fun mainActivity(): AppActivity

    @Binds
    abstract fun bindNavigationManager(mainActivity: AppActivity): NavigationContract.NavigationManager

    @Binds
    abstract fun bindActivity(mainActivity: AppActivity): Activity
}