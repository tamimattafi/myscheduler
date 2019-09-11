package com.tamimattafi.myscheduler.app

import android.content.Context
import com.tamimattafi.myscheduler.app.ui.fragments.global.NavigationContract
import com.tamimattafi.myscheduler.app.ui.fragments.main.MainFragment
import javax.inject.Inject

class Launcher @Inject constructor(private val context: Context) {

    fun getLaunchFragment(): NavigationContract.NavigationFragment = MainFragment()

}