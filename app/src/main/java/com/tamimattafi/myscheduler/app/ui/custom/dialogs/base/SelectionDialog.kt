package com.tamimattafi.myscheduler.app.ui.custom.dialogs.base

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.tamimattafi.myscheduler.R
import kotlinx.android.synthetic.main.dialog_selection.view.*


abstract class SelectionDialog<OBJECT, HOLDER : SelectionDialogContract.SelectionDialogHolder<OBJECT>>(
    context: Context?,
    spanSize: Int
) : SelectionDialogContract.SelectionDialog<OBJECT, HOLDER> {

    private val dialogView =
        LayoutInflater.from(context).inflate(R.layout.dialog_selection, null, false)
    private val dialog: AlertDialog

    private var onCancel: (() -> Unit)? = null


    init {
        AlertDialog.Builder(context).apply {
            setView(dialogView)
            setCancelable(true)
            dialog = create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        dialogView.apply {
            cancel.setOnClickListener {
                dismiss()
                onCancel?.invoke()
            }

            with(recycler) {
                layoutManager = GridLayoutManager(context, spanSize).apply {
                    spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                        override fun getSpanSize(p0: Int): Int {
                            return if (itemCount <= 1) spanSize
                            else 1
                        }
                    }
                }
                itemAnimator = DefaultItemAnimator()
            }

        }

    }

    override fun bindData(
        data: ArrayList<OBJECT>,
        listener: (item: OBJECT) -> Unit
    ) {
        dialogView.recycler.adapter = getSelectionAdapter(data, listener)
    }

    fun setCancelListener(onCancel: () -> Unit) {
        this.onCancel = onCancel
    }

    fun show() {
        dialog.show()
    }

    fun dismiss() {
        dialog.dismiss()
    }


}