package com.tamimattafi.myscheduler.repository.global

import android.os.AsyncTask
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe

interface RepositoryContract {


    interface Base<T> {
        fun getData(): Callback<Flowable<List<T>>>
        fun get(id: Int): Callback<Maybe<T>>
        fun set(item: T): Callback<Completable>
        fun delete(item: T): Callback<Completable>
        fun update(item: T): Callback<Completable>
        fun stopListening()
    }

    abstract class Async<PARAM, RESULT>(private val callback: Callback<RESULT>) :
        AsyncTask<PARAM, Int, RESULT>() {

        abstract fun doWork(parameter: PARAM): RESULT

        override fun doInBackground(vararg params: PARAM): RESULT {
            return try {
                doWork(params[0])
            } catch (e: Exception) {
                callback.onFailure?.invoke(e.localizedMessage ?: e.message ?: e.toString())
                throw Exception(e.message)
            }
        }

        override fun onPostExecute(result: RESULT) {
            super.onPostExecute(result)
            callback.onSuccess?.invoke(result)
        }

    }

    interface Callback<T> {
        var onSuccess: ((result: T) -> Unit)?
        var onFailure: ((message: String) -> Unit)?
        fun setOnSuccessListener(onSuccess: (result: T) -> Unit): Callback<T>
        fun setOnFailureListener(onFailure: (message: String) -> Unit): Callback<T>
        fun destroy()
    }
}