package com.tamimattafi.myscheduler.database.global

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.tamimattafi.myscheduler.model.Icon
import com.tamimattafi.myscheduler.model.Reminder
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.model.Task
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single


@Dao
interface BaseDao<T> {

    @RawQuery(
        observedEntities =
        [Task::class,
            Icon::class,
            Reminder::class,
            Routine::class]
    )
    fun get(itemQuery: SimpleSQLiteQuery): Maybe<T>

    @RawQuery(
        observedEntities =
        [Task::class,
            Icon::class,
            Reminder::class,
            Routine::class]
    )
    fun getList(listQuery: SimpleSQLiteQuery) : Flowable<List<T>>

    @Insert
    fun insertAll(items: List<T>): Completable

    @Insert
    fun insert(item : T) : Completable

    @Update
    fun update(item: T): Completable

    @Delete
    fun delete(item : T) : Completable

    @RawQuery(
        observedEntities =
        [Task::class,
            Icon::class,
            Reminder::class,
            Routine::class]
    )
    fun deleteAll(deleteAllQuery: SimpleSQLiteQuery): Single<T>

}