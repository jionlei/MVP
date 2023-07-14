package com.example.myapplication.base

interface IPresenter<V :IView> {
    abstract fun attachView(mView: V?)
    abstract fun detachView()
}
