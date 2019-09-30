package com.tamimattafi.myscheduler.app.ui.custom.dialogs.specific

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.tamimattafi.myscheduler.R
import kotlinx.android.synthetic.main.dialog_confirmation.view.*


class ConfirmationDialog(context: Context) {

    private val dialogView =
        LayoutInflater.from(context).inflate(R.layout.dialog_confirmation, null)
    private val dialog: AlertDialog


    private var onConfirm: (() -> Unit)? = null
    private var onCancel: (() -> Unit)? = null


    var title: String? = ""
        set(value) {
            field = value
            dialogView.label.text = value
        }

    var hint: String? = ""
        set(value) {
            field = value
            dialogView.hint.text = value
        }

    init {
        AlertDialog.Builder(context).apply {
            setView(dialogView)
            setCancelable(true)
            dialog = create()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        }

        dialogView.apply {
            cancel.setOnClickListener {
                onCancel?.invoke()
                dismiss()
            }

            confirm.setOnClickListener {
                onConfirm?.invoke()
                dismiss()
            }

        }

    }

    fun setConfirmListener(onConfirm: () -> Unit): ConfirmationDialog =
        this.also { it.onConfirm = onConfirm }

    fun setCancelListener(onCancel: () -> Unit): ConfirmationDialog =
        this.also { it.onCancel = onCancel }

    fun show() {
        dialog.show()
    }

    fun dismiss() {
        dialog.dismiss()
    }

}