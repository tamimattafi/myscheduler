package com.tamimattafi.myscheduler.app

import android.os.Bundle
import com.tamimattafi.myscheduler.R
import com.tamimattafi.myscheduler.app.ui.fragments.global.NavigationActivity
import javax.inject.Inject

class MainActivity : NavigationActivity() {

    @Inject
    lateinit var launcher: Launcher

    override val layoutId: Int = R.layout.activity_main
    override var rootId: Int = R.id.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        requestAttachBaseScreen(launcher.getLaunchFragment())
    }

}
