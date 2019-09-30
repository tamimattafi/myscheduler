package com.tamimattafi.myscheduler.app.ui.fragments.main.add_routine

interface AddRoutineContract {

    interface View {
        fun isValidForm(): Boolean
        fun showError(message: String)
        fun dismiss()
        fun getName(): String
        fun getDescription(): String
        fun getImportance(): Int
        fun getStartDay(): Int
        fun getDays(): Int
    }

    interface Presenter {
        fun onSaveClick()
    }
}