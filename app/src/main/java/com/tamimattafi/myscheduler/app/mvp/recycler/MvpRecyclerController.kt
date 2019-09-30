package com.tamimattafi.myscheduler.app.mvp.recycler

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.custom.decorators.ItemOffsetDecoration

open class MvpRecyclerController<HOLDER : MvpRecyclerContract.Holder>(
    val recycler: RecyclerView,
    private val view: MvpRecyclerContract.View<HOLDER>
) :
    MvpRecyclerContract.RecyclerController<HOLDER> {

    open fun onSetRecyclerSpan(): Int = 1

    lateinit var layoutManager: GridLayoutManager

    override fun prepareAdapter(adapter: MvpRecyclerAdapter<HOLDER>): Boolean {
        with(recycler) {
            this@with.layoutManager = GridLayoutManager(
                context!!,
                onSetRecyclerSpan()
            ).also { setUpLayoutManagerSpan(it) }
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(onSetRecyclerDecorator())
            this.adapter = adapter
        }

        return addRecyclerScrollListener()

    }

    override fun startListening() {
        view.loadMoreData()
    }

    open fun addRecyclerScrollListener(): Boolean {
        recycler.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) {
                        (recyclerView.layoutManager as? GridLayoutManager)?.apply {
                            if (findLastVisibleItemPosition() >= itemCount * 90 / 100) {
                                view.loadMoreData()
                            }
                        }
                    }
                }
            }
        )
        return true
    }

    open fun onSetRecyclerDecorator(): RecyclerView.ItemDecoration =
        ItemOffsetDecoration(recycler.context, R.dimen.item_spacing)

    open fun setUpLayoutManagerSpan(layoutManager: GridLayoutManager) {
        this.layoutManager = layoutManager
        with(layoutManager) {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (itemCount) {
                        1 -> spanCount
                        else -> 1
                    }
                }
            }
        }
    }


}