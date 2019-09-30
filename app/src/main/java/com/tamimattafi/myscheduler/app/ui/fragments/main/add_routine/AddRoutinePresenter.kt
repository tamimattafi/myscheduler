package com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine

import com.tamimattafi.myscheduler.app.mvp.BasePresenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineContract.Presenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineContract.View
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.repository.global.RepositoryContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddRoutinePresenter @Inject constructor(view: View) : BasePresenter<View>(view), Presenter {

    @Inject
    lateinit var repository: RepositoryContract.Base<Routine>

    override fun onSaveClick() {
        with(view) {
            if (isValidForm()) {
                Routine(
                    name = getName(),
                    description = getDescription(),
                    days = getDays(),
                    startDay = getStartDay(),
                    importance = getImportance()
                ).also { routine ->
                    repository.set(routine).setOnSuccessListener { completable ->
                        completable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnError {
                                showError(it?.message ?: it.localizedMessage ?: it.toString())
                            }.doOnComplete {
                                dismiss()
                            }.subscribe()
                    }.setOnFailureListener { message ->
                        showError(message)
                    }
                }
            }
        }
    }

}