package com.tamimattafi.myscheduler.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tamimattafi.myscheduler.database.dao.IconDao
import com.tamimattafi.myscheduler.database.dao.ReminderDao
import com.tamimattafi.myscheduler.database.dao.RoutineDao
import com.tamimattafi.myscheduler.database.dao.TaskDao
import com.tamimattafi.myscheduler.database.global.Values
import com.tamimattafi.myscheduler.model.Icon
import com.tamimattafi.myscheduler.model.Reminder
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.model.Task
import javax.inject.Singleton

@Singleton
@Database(
    entities = [Task::class, Icon::class, Routine::class, Reminder::class],
    version = Values.DATABASE_VERSION,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun taskDao() : TaskDao
    abstract fun iconDao() : IconDao
    abstract fun routineDao() : RoutineDao
    abstract fun reminderDao() : ReminderDao
}