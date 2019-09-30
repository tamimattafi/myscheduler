package com.tamimattafi.myscheduler.repository.global

import com.tamimattafi.myscheduler.repository.global.RepositoryContract.Callback

class Callback<T> : Callback<T> {

    override var onSuccess: ((result: T) -> Unit)? = null
    override var onFailure: ((message: String) -> Unit)? = null

    override fun setOnSuccessListener(onSuccess: (result: T) -> Unit): Callback<T> =
        this.also { this.onSuccess = onSuccess }

    override fun setOnFailureListener(onFailure: (message: String) -> Unit): Callback<T> =
        this.also { this.onFailure = onFailure }

    override fun destroy() {
        this.onSuccess = null
        this.onFailure = null
    }

}