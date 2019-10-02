package com.tamimattafi.myscheduler.app.di.modules

import android.app.Activity
import com.tamimattafi.myscheduler.app.AppActivity
import com.tamimattafi.myscheduler.app.di.modules.fragments.MainFragments
import com.tamimattafi.myscheduler.app.ui.fragments.global.NavigationContract
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.repository.RoutineRepository
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.Base
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.SearchBase
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

    @Binds
    abstract fun bindRoutineRepository(repository: RoutineRepository): Base<Routine>

    @Binds
    abstract fun bindRoutineSearchRepository(searchRepository: RoutineRepository): SearchBase<Routine>
}