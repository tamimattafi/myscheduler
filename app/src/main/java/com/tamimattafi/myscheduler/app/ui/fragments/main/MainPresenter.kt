package com.tamimattafi.myscheduler.app.ui.fragments.main

import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.presenter.BaseRoutinePresenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.Presenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainContract.View
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.Base
import javax.inject.Inject

class MainPresenter @Inject constructor(view: View) :
    BaseRoutinePresenter<View, Base<Routine>>(view), Presenter



