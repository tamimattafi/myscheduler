package com.tamimattafi.myscheduler.app.mvp.recycler

import com.tamimattafi.myscheduler.app.mvp.BaseContract


interface MvpRecyclerContract {

    interface Adapter<HOLDER : Holder> {
        var isLoading: Boolean
        fun attachToController(controller: RecyclerController<HOLDER>)
        fun setDataCount(dataCount: Int): Boolean
        fun isEmpty(): Boolean
    }

    interface RecyclerController<HOLDER : Holder> {
        fun prepareAdapter(adapter: MvpRecyclerAdapter<HOLDER>): Boolean
        fun startListening()
    }


    interface Listener {
        fun onHolderClick(listPosition: Int, adapterPosition: Int)
        fun onHolderLongClick(listPosition: Int, adapterPosition: Int)
        fun onHolderAction(listPosition: Int, adapterPosition: Int, action: Int)
    }

    interface Holder : ListenerHolder {
        var listPosition: Int
    }

    interface ListenerHolder {
        var listener: Listener?
    }

    interface Presenter<HOLDER : Holder> : BaseContract.Presenter {
        fun bindViewHolder(holder: HOLDER)
        fun loadMoreRecyclerData()
    }

    interface View<HOLDER : Holder> : Listener {
        fun bindViewHolder(holder: HOLDER)
        fun showError(message: String)
        fun getRecyclerAdapter(): Adapter<HOLDER>
        fun loadMoreData()
        fun onRecyclerDataChanged(dataCount: Int)
    }


}