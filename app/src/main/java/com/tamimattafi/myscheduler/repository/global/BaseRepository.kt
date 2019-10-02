package com.tamimattafi.myscheduler.repository.global

import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.database.global.QueryBuilder
import com.tamimattafi.myscheduler.database.global.QueryBuilder.Direction
import com.tamimattafi.myscheduler.model.Properties
import com.tamimattafi.myscheduler.repository.async.ItemAsync
import com.tamimattafi.myscheduler.repository.async.ListAsync
import com.tamimattafi.myscheduler.repository.async.WriteAsync
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.Base
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.Callback
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

abstract class BaseRepository<T, DAO : BaseDao<T>> : Base<T> {

    @Inject
    lateinit var dao: DAO

    abstract val table: String
    private val callbacks: ArrayList<Callback<*>> = ArrayList()

    open fun getQuery(): QueryBuilder = QueryBuilder()
        .selectFrom(table)
        .orderBy(Properties.ID, Direction.DESCENDING)

    override fun getData(): Callback<Flowable<List<T>>> = Callback<Flowable<List<T>>>().also {
        ListAsync(dao, it).execute(getQuery().build())
    }

    override fun get(id: Int): Callback<Maybe<T>> = Callback<Maybe<T>>().also {
        ItemAsync(dao, it).execute(QueryBuilder.Custom.getItem(table, id))
    }

    override fun set(item: T): Callback<Completable> = getEditCallback(item, WriteAsync.INSERT)

    override fun delete(item: T): Callback<Completable> = getEditCallback(item, WriteAsync.DELETE)

    override fun update(item: T): Callback<Completable> = getEditCallback(item, WriteAsync.UPDATE)

    override fun stopListening() {
        callbacks.forEach {
            it.destroy()
        }
        callbacks.clear()
    }

    private fun getEditCallback(item: T, type: Int): Callback<Completable> =
        Callback<Completable>().also {
            WriteAsync(dao, it).execute(Pair(item, type))
        }

}