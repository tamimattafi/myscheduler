package com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.empty

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract
import com.tamimattafi.myscheduler.utils.AppUtils
import kotlinx.android.synthetic.main.item_view_holder_empty.view.*

class EmptyHolder(private val emptyHolderData: EmptyHolderData, itemView: View) :
    RecyclerView.ViewHolder(itemView), MvpRecyclerContract.ListenerHolder {


    override var listener: MvpRecyclerContract.Listener? = null
        set(value) {
            field = value
            itemView.action.setOnClickListener {
                value?.onHolderAction(-1, adapterPosition, emptyHolderData.action)
            }
        }

    init {
        with(itemView) {
            emptyHolderData.apply {
                this@with.label.text = label
                this@with.description.text = description
                this@with.image.setImageDrawable(AppUtils.getDrawable(context, image))
                this@with.action.apply {
                    text = actionName
                    setIconResource(actionIcon)
                }
            }
        }
    }

}