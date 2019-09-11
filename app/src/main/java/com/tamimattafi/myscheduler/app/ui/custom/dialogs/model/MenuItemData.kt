package com.tamimattafi.myscheduler.app.ui.custom.dialogs.model

import com.tamimattafi.myscheduler.R

data class MenuItemData(
    var id: Int? = null,
    var label: String = "⋯",
    var description: String? = "",
    var drawable: Int? = null,
    var drawableColor: Int = R.color.colorAccent,
    var action: Int = -1
)
