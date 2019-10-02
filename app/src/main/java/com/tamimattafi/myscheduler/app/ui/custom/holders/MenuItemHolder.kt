package com.tamimattafi.myscheduler.app.ui.custom.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.myscheduler.app.ui.custom.dialogs.base.SelectionDialogContract
import com.tamimattafi.myscheduler.app.ui.custom.dialogs.model.MenuItemData
import com.tamimattafi.myscheduler.utils.AppUtils
import kotlinx.android.synthetic.main.item_view_holder_menu_item.view.*

class MenuItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    SelectionDialogContract.SelectionDialogHolder<MenuItemData> {

    lateinit var item: MenuItemData

    override fun bindData(item: MenuItemData) {
        this.item = item
        with(itemView) {
            item.apply {
                this@with.label.text = label
                with(this@with.icon) {
                    setColorFilter(AppUtils.getColor(context, drawableColor))
                    setImageResource(this@apply.drawable ?: return)
                }
            }
        }
    }

    override fun bindListeners(listener: (item: MenuItemData) -> Unit) {
        itemView.setOnClickListener {
            listener.invoke(item)
        }
    }

}