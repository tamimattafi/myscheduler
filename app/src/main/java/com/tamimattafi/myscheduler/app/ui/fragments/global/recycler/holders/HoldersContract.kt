package com.tamimattafi.myscheduler.app.ui.fragments.global.recycler.holders

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.tamimattafi.myscheduler.app.mvp.recycler.MvpRecyclerContract

interface HoldersContract {

    interface RoutineHolder : MvpRecyclerContract.Holder {
        fun setName(name: String)
        fun setDescription(description: String)
        fun setActive(isActive: Boolean)
        fun setIconVector(@DrawableRes vector: Int)
        fun setIconBackground(@DrawableRes background: Int)
        fun setIconTint(@ColorRes tint: Int)
    }

}