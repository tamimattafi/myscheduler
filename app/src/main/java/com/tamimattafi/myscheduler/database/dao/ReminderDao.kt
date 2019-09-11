package com.tamimattafi.myscheduler.database.dao

import androidx.room.Dao
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.model.Reminder
import io.reactivex.Flowable

@Dao
interface ReminderDao : BaseDao<Reminder> {
    @RawQuery(observedEntities = [Reminder::class])
    override fun get(itemQuery: SimpleSQLiteQuery): Flowable<Reminder>

    @RawQuery(observedEntities = [Reminder::class])
    override fun getList(listQuery: SimpleSQLiteQuery): Flowable<List<Reminder>>
}
