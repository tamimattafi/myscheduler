package com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpSimpleHolder
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.HoldersContract.RoutineHolder
import com.tamimattafi.myscheduler.utils.AppUtils
import kotlinx.android.synthetic.main.item_view_holder_empty.view.*
import kotlinx.android.synthetic.main.item_view_holder_main_routine.view.*
import kotlinx.android.synthetic.main.item_view_holder_main_routine.view.description

class MainRoutineHolder(view: View) : MvpSimpleHolder(view), RoutineHolder {

    override fun setDescription(description: String) {
        itemView.description.text = description
    }

    override fun setActive(isActive: Boolean) {
        itemView.toggle.apply {
            setOnCheckedChangeListener(null)
            isChecked = isActive
            setOnCheckedChangeListener { _, _ ->
                listener?.onHolderAction(listPosition, adapterPosition, Actions.ACTION_TOGGLE)
            }
        }
    }

    override fun setIconVector(@DrawableRes vector: Int) {
        itemView.icon.setImageResource(vector)
    }

    override fun setIconBackground(@DrawableRes background: Int) {
        itemView.setBackgroundResource(background)
    }

    override fun setIconTint(@ColorRes tint: Int) {
        itemView.image.setColorFilter(AppUtils.getColor(itemView.context, tint))
    }

    override fun setName(name: String) {
        itemView.name.text = name
    }

}