package com.tamimattafi.myscheduler.app.ui.custom.dialogs.specific

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.tamimattafi.myscheduler.R
import kotlinx.android.synthetic.main.dialog_info.view.*

class InfoDialog(context: Context) {

    private val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_info, null)
    private val dialog: AlertDialog

    private var onCancel: (() -> Unit)? = null

    var title: String = ""
        set(value) {
            field = value
            dialogView.label.text = value
        }

    var hint: String = ""
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

        }

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