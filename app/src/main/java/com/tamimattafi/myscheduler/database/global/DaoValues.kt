package com.tamimattafi.myscheduler.database.global

import com.tamimattafi.myscheduler.model.Icon
import com.tamimattafi.myscheduler.model.Reminder
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.model.Task

object DaoValues {
    val observedObjects = arrayOf(
        Task::class,
        Icon::class,
        Reminder::class,
        Routine::class
    )
}