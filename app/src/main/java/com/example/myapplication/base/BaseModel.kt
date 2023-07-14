package com.example.myapplication.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseModel : IModel, LifecycleEventObserver {

    // 默认单例线程安全
    private val mCompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun addDisposable(disposable: Disposable?) {
        disposable?.let {
            mCompositeDisposable.add(it)
        }
    }

    override fun onDetach() {
        mCompositeDisposable.clear()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_DESTROY ->{
                source.lifecycle.removeObserver(this)
            }
            else -> {

            }
        }
    }
}