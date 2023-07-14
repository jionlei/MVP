package com.example.myapplication.base

import io.reactivex.disposables.Disposable

interface IModel {

    // Rxjava model disposable 统一处理
    fun addDisposable(disposable: Disposable?)

    fun onDetach()
}