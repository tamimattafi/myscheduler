package com.tamimattafi.myscheduler.app.ui.custom.dialogs.base

interface SelectionDialogContract {

    interface SelectionDialog<OBJECT, HOLDER : SelectionDialogHolder<OBJECT>> {
        fun getSelectionAdapter(
            data: ArrayList<OBJECT>,
            listener: (item: OBJECT) -> Unit
        ): SelectionAdapter<OBJECT, HOLDER>

        fun bindData(data: ArrayList<OBJECT>, listener: (item: OBJECT) -> Unit)
    }

    interface SelectionDialogHolder<OBJECT> {
        fun bindListeners(listener: (item: OBJECT) -> Unit)
        fun bindData(item: OBJECT)
    }

    interface ListDialogActionListener<OBJECT> {
        fun onItemSelected(item: OBJECT)
    }
}