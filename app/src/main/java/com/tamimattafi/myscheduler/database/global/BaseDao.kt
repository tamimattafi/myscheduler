package com.tamimattafi.myscheduler.database.global

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single


@Dao
interface BaseDao<T> {

    @RawQuery
    fun get(itemQuery : SimpleSQLiteQuery) : Flowable<T>

    @RawQuery
    fun getList(listQuery: SimpleSQLiteQuery) : Flowable<List<T>>

    @Insert
    fun insertAll(items: List<T>): Completable

    @Insert
    fun insert(item : T) : Completable

    @Update
    fun update(item: T): Completable

    @Delete
    fun delete(item : T) : Completable

    @RawQuery
    fun deleteAll(deleteAllQuery: SimpleSQLiteQuery): Single<Int>

}