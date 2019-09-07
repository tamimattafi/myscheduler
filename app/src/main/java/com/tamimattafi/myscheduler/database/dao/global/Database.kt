package com.tamimattafi.myscheduler.database.dao.global

import androidx.room.RoomDatabase
import com.tamimattafi.myscheduler.database.dao.IconDao
import com.tamimattafi.myscheduler.database.dao.ReminderDao
import com.tamimattafi.myscheduler.database.dao.RoutineDao
import com.tamimattafi.myscheduler.database.dao.TaskDao
import javax.inject.Singleton

@Singleton
abstract class Database : RoomDatabase() {
    abstract fun taskDao() : TaskDao
    abstract fun iconDao() : IconDao
    abstract fun routineDao() : RoutineDao
    abstract fun reminderDao() : ReminderDao
}