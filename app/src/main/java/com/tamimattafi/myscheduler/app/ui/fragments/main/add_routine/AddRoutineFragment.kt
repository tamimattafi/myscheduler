package com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine

import android.os.Bundle
import android.view.View.OnClickListener
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.custom.dialogs.specific.ConfirmationDialog
import com.tamimattafi.myscheduler.app.ui.custom.dialogs.specific.InfoDialog
import com.tamimattafi.myscheduler.app.ui.custom.dialogs.sub.StringSelectionDialog
import com.tamimattafi.myscheduler.app.ui.custom.views.FormEditText
import com.tamimattafi.myscheduler.app.ui.custom.views.FormInputLayout
import com.tamimattafi.myscheduler.app.ui.fragments.global.NavigationContract.NavigationFragment
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineContract.Presenter
import com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine.AddRoutineContract.View
import kotlinx.android.synthetic.main.fragment_add_routine.*
import kotlinx.android.synthetic.main.toolbar_add_routine.*
import javax.inject.Inject

class AddRoutineFragment : NavigationFragment(), View {

    @Inject
    lateinit var presenter: Presenter

    override var fragmentName: String = "add-routine-fragment"
    override val layoutId: Int = R.layout.fragment_add_routine

    private val backDialog by lazy {
        ConfirmationDialog(appActivity).apply {
            with(appActivity.resources) {
                title = getString(R.string.cancel)
                hint = getString(R.string.cancel_confirmation)
            }
        }.setConfirmListener {
            dismiss()
        }
    }

    private val daysDialog by lazy {
        getSelectionDialog(AddRoutineValues.getDaysList(appContext), startDay)
    }

    private val importanceDialog by lazy {
        getSelectionDialog(AddRoutineValues.getImportanceList(appContext), importance)
    }

    private fun getSelectionDialog(
        list: ArrayList<String>,
        input: FormEditText
    ): StringSelectionDialog = StringSelectionDialog(appActivity).apply {
        bindData(list) { selected ->
            input.setText(selected)
            this.dismiss()
        }
    }


    private val errorDialog by lazy {
        InfoDialog(appActivity).apply {
            title = appActivity.resources.getString(R.string.error)
        }
    }

    private val backListener by lazy {
        OnClickListener {
            backDialog.show()
        }
    }

    private val saveListener by lazy {
        OnClickListener {
            presenter.onSaveClick()
        }
    }

    private fun setClickListener(listener: OnClickListener, vararg views: android.view.View) {
        for (view in views) {
            view.setOnClickListener(listener)
        }
    }

    private fun checkForm(vararg inputs: Pair<FormEditText, FormInputLayout>): Boolean {
        for (input in inputs) {
            if (!isValidInput(input)) {
                return false
            }
        }
        return true
    }

    private fun isValidInput(input: Pair<FormEditText, FormInputLayout>): Boolean {
        with(input.second) {
            return if (input.first.text.isNullOrEmpty()) {
                error = appActivity.resources.getString(R.string.required_field)
                false
            } else {
                error = null
                isErrorEnabled = false
                true
            }
        }
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        daysSeek.setOnProgressChangeListener { progress ->
            days.text = (progress + AddRoutineValues.getMinDays(appActivity)).toString()
        }

        setClickListener(saveListener, confirm, save)
        setClickListener(backListener, back, cancel)

        startDay.setOnClickListener {
            daysDialog.show()
        }

        importance.setOnClickListener {
            importanceDialog.show()
        }
    }

    override fun isValidForm(): Boolean = checkForm(
        Pair(name, nameLayout),
        Pair(startDay, startDayLayout),
        Pair(importance, importanceLayout)
    )

    override fun showError(message: String) {
        errorDialog.apply {
            hint = message
        }.show()
    }

    override fun dismiss() {
        navigationManager.requestBackPress()
    }

    override fun getName(): String = name.text.toString()

    override fun getDescription(): String = description.text.toString()

    override fun getImportance(): Int =
        AddRoutineValues.getImportanceList(appActivity).indexOf(importance.text.toString())

    override fun getStartDay(): Int =
        AddRoutineValues.getDaysList(appActivity).indexOf(startDay.text.toString())

    override fun getDays(): Int = days.text.toString().toInt()


}