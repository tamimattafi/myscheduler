package com.tamimattafi.myscheduler.app.mvp.recycler

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.empty.EmptyHolder
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.empty.EmptyHolderList
import com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders.empty.UnbindableHolder
import javax.inject.Inject

abstract class MvpRecyclerAdapter<HOLDER : MvpRecyclerContract.Holder>(val view: MvpRecyclerContract.View<HOLDER>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    MvpRecyclerContract.Adapter<HOLDER> {

    @Inject
    lateinit var activity: Activity

    protected var dataCount: Int = 0

    open var headersCount = 0
    open var footersCount = 0

    override var isLoading: Boolean = false

    override fun attachToController(controller: MvpRecyclerContract.RecyclerController<HOLDER>) {
        with(controller) {
            if (prepareAdapter(this@MvpRecyclerAdapter)) {
                startListening()
            }
        }
    }

    override fun setDataCount(dataCount: Int): Boolean {
        this.dataCount = dataCount
        notifyDataSetChanged()
        view.onRecyclerDataChanged(dataCount)
        return true
    }

    override fun getItemCount(): Int {
        return when {
            dataCount > 0 -> dataCount + footersCount + headersCount
            else -> 1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MvpRecyclerContract.ListenerHolder) {
            holder.listener = view
        }
        (holder as? HOLDER)?.apply {
            listPosition = position - headersCount
            this@MvpRecyclerAdapter.view.bindViewHolder(this)
        }
    }


    abstract fun getItemHolder(parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun getNoDataHolderType(): Int

    open fun getNoDataHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        return EmptyHolder(
            EmptyHolderList.getItem(activity, type),
            LayoutInflater.from(activity).inflate(
                R.layout.item_view_holder_empty,
                parent,
                false
            )
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        with(LayoutInflater.from(activity)) {
            return when (viewType) {
                ITEM_MAIN -> getItemHolder(parent)
                ITEM_NO_DATA -> getNoDataHolder(parent, getNoDataHolderType())
                else -> UnbindableHolder(
                    inflate(
                        R.layout.item_view_holder_loading,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            dataCount > 0 && headersCount > 0 && position in 0 until headersCount -> ITEM_HEADER
            dataCount > 0 && position in headersCount until dataCount + headersCount -> ITEM_MAIN
            dataCount > 0 && footersCount > 0 && position in dataCount until (dataCount + footersCount) -> ITEM_FOOTER
            dataCount == 0 && !isLoading -> ITEM_NO_DATA
            else -> ITEM_LOADING
        }
    }

    override fun isEmpty(): Boolean = dataCount == 0

    companion object {
        protected const val ITEM_HEADER = Int.MAX_VALUE - 1
        protected const val ITEM_NO_DATA = ITEM_HEADER - 1
        protected const val ITEM_LOADING = ITEM_NO_DATA - 1
        protected const val ITEM_LOADING_ERROR = ITEM_LOADING - 1
        protected const val ITEM_MAIN = ITEM_LOADING_ERROR - 1
        protected const val ITEM_FOOTER = ITEM_MAIN - 1
    }

}