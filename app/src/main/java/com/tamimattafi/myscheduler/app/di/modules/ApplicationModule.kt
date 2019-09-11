package com.tamimattafi.myscheduler.app.di.modules

import android.content.Context
import androidx.room.Room
import com.tamimattafi.myscheduler.database.Database
import com.tamimattafi.myscheduler.database.global.Values
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
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
    }


    @Reusable
    @Binds
    abstract fun bindContext(application: DaggerApplication): Context
}