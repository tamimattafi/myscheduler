package com.tamimattafi.myscheduler.repository.async

import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.repository.global.Callback
import com.tamimattafi.myscheduler.repository.global.RepositoryContract
import io.reactivex.Completable

class WriteAsync<T>(private val dao: BaseDao<T>, callback: Callback<Completable>) :
    RepositoryContract.Async<Pair<T, Int>, Completable>(callback) {

    override fun doWork(parameter: Pair<T, Int>): Completable = with(dao) {
        with(parameter.first) {
            when (parameter.second) {
                INSERT -> insert(this)
                UPDATE -> update(this)
                DELETE -> delete(this)
                else -> throw IllegalArgumentException("Type unknown")
            }
        }
    }


    companion object {
        const val INSERT = 0
        const val UPDATE = 1
        const val DELETE = 2
    }

}