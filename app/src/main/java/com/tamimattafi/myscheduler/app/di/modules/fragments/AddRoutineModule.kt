package com.tamimattafi.myscheduler.app.di.modules.fragments

import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineContract.Presenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineContract.View
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineFragment
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutinePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class AddRoutineModule {

    @Binds
    abstract fun bindView(fragment: AddRoutineFragment): View

    @Binds
    abstract fun bindPresenter(presenter: AddRoutinePresenter): Presenter

}