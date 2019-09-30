package com.tamimattafi.myscheduler.app.di.modules

import android.content.Context
import androidx.room.Room
import com.tamimattafi.myscheduler.database.Database
import com.tamimattafi.myscheduler.database.dao.IconDao
import com.tamimattafi.myscheduler.database.dao.ReminderDao
import com.tamimattafi.myscheduler.database.dao.RoutineDao
import com.tamimattafi.myscheduler.database.dao.TaskDao
import com.tamimattafi.myscheduler.database.global.Values
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.repository.RoutineRepository
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.Base
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.support.DaggerApplication

@Module
abstract class ApplicationModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Reusable
        fun provideDatabase(context: Context): Database =
            Room.databaseBuilder(context, Database::class.java, Values.DATABASE_NAME)
                .fallbackToDestructiveMigrationOnDowngrade()
                .build()

        @JvmStatic
        @Provides
        @Reusable
        fun provideRoutineDao(database: Database): RoutineDao = database.routineDao()

        @JvmStatic
        @Provides
        @Reusable
        fun provideIconDao(database: Database): IconDao = database.iconDao()

        @JvmStatic
        @Provides
        @Reusable
        fun provideTaskDao(database: Database): TaskDao = database.taskDao()

        @JvmStatic
        @Provides
        @Reusable
        fun provideReminderDao(database: Database): ReminderDao = database.reminderDao()
    }

    @Reusable
    @Binds
    abstract fun bindRoutineRepository(routineRepository: RoutineRepository): Base<Routine>

    @Reusable
    @Binds
    abstract fun bindContext(application: DaggerApplication): Context
}