package com.tamimattafi.myscheduler.app.mvp.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class MvpSimpleHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    MvpRecyclerContract.Holder {

    override var listPosition: Int = -1

    override var listener: MvpRecyclerContract.Listener? = null
        set(value) {
            field = value
            onListenerSet(value)
        }

    open fun onListenerSet(listener: MvpRecyclerContract.Listener?) {
        with(itemView) {
            setOnClickListener {
                listener?.onHolderClick(listPosition, adapterPosition)
            }

            setOnLongClickListener {
                listener?.onHolderLongClick(
                    listPosition,
                    adapterPosition
                )
                true
            }
        }
    }

}