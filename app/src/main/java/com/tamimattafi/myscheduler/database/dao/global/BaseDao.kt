package com.tamimattafi.myscheduler.database.dao.global

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface BaseDao<T> {

    @RawQuery
    fun get(itemQuery : SimpleSQLiteQuery) : Flowable<T>

    @RawQuery
    fun getList(listQuery: SimpleSQLiteQuery) : Flowable<List<T>>

    @Insert
    fun insertList(items : ArrayList<T>) : Completable

    @Insert
    fun insert(item : T) : Completable

    @Delete
    fun delete(item : T) : Completable

    @RawQuery
    fun deleteAll(deleteAllQuery : SimpleSQLiteQuery) : Completable

}