package com.tamimattafi.zennex.repository.global

import android.os.AsyncTask
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe

interface RepositoryContract {


    interface Base<T> {
        fun getData()
        fun destroy()
        fun get(id: Int)
        fun set(item: T)
        fun delete(item: T)
        fun update(item: T)
    }

    interface LocalBase<T> : Base<T>, LocalCallBack<T> {

        abstract class LocalRepository<T> : LocalBase<T> {
            override var onListReadComplete: ((it: Flowable<List<T>>) -> Unit)? = null
            override var onWriteComplete: ((Completable) -> Unit)? = null
            override var onReadComplete: ((it: Maybe<T>) -> Unit)? = null


            override fun stopListening() {
                onListReadComplete = null
                onWriteComplete = null
                onReadComplete = null
            }

            override fun destroy() {
                stopListening()
            }
        }

    }


    abstract class Async<PARAMS, RESULT> : AsyncTask<PARAMS, Int, RESULT>(),
        CompleteCallback<RESULT> {

        override var onComplete: ((it: RESULT) -> Unit)? = null

        override fun onPostExecute(result: RESULT) {
            super.onPostExecute(result)
            onComplete?.invoke(result)
        }
    }

    interface CompleteCallback<RESULT> {
        var onComplete: ((it: RESULT) -> Unit)?
    }

    interface LocalCallBack<T> {
        var onReadComplete: ((it: Maybe<T>) -> Unit)?
        var onListReadComplete: ((it: Flowable<List<T>>) -> Unit)?
        var onWriteComplete: ((Completable) -> Unit)?
        fun stopListening()
    }
}