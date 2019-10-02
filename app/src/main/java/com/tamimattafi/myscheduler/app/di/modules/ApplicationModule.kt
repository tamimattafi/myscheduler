package com.tamimattafi.myscheduler.app.di.modules

import android.content.Context
import androidx.room.Room
import com.tamimattafi.myscheduler.database.Database
import com.tamimattafi.myscheduler.database.dao.IconDao
import com.tamimattafi.myscheduler.database.dao.ReminderDao
import com.tamimattafi.myscheduler.database.dao.RoutineDao
import com.tamimattafi.myscheduler.database.dao.TaskDao
import com.tamimattafi.myscheduler.database.global.Values
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideDatabase(context: Context): Database =
            Room.databaseBuilder(context, Database::class.java, Values.DATABASE_NAME)
                .fallbackToDestructiveMigrationOnDowngrade()
                .build()

        @JvmStatic
        @Provides
        @Singleton
        fun provideRoutineDao(database: Database): RoutineDao = database.routineDao()

        @JvmStatic
        @Provides
        @Singleton
        fun provideIconDao(database: Database): IconDao = database.iconDao()

        @JvmStatic
        @Provides
        @Singleton
        fun provideTaskDao(database: Database): TaskDao = database.taskDao()

        @JvmStatic
        @Provides
        @Singleton
        fun provideReminderDao(database: Database): ReminderDao = database.reminderDao()
    }

    @Binds
    abstract fun bindContext(application: DaggerApplication): Context
}