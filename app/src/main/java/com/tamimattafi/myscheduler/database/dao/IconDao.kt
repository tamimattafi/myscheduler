package com.tamimattafi.myscheduler.database.dao

import androidx.room.Dao
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.model.Icon
import io.reactivex.Flowable

@Dao
interface IconDao : BaseDao<Icon> {

    @RawQuery(observedEntities = [Icon::class])
    override fun get(itemQuery: SimpleSQLiteQuery): Flowable<Icon>

    @RawQuery(observedEntities = [Icon::class])
    override fun getList(listQuery: SimpleSQLiteQuery): Flowable<List<Icon>>
}
