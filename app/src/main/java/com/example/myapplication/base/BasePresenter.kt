package com.example.myapplication.base

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

abstract class BasePresenter<M : IModel, V : IView> : IPresenter<V>, LifecycleEventObserver {
    private val TAG = this.javaClass.simpleName
    protected var mModel: M? = null
    protected var mView: V? = null

    abstract fun createModel(): M?

    override fun attachView(mView: V?) {
        this.mView = mView
        this.mModel = createModel()

        // 仅仅是加了两个lifecycle
        if (mView is LifecycleOwner) {
            mView.lifecycle.addObserver(this)
            mModel?.let {
                if (it is LifecycleEventObserver) {
                    mView.lifecycle.addObserver(mModel as LifecycleEventObserver)
                }
            }
        }

    }

    override fun detachView() {
        mModel?.onDetach()
        mModel = null
        mView = null
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                //detachView()
                Log.d(TAG, "lifecycle destroyed")
            }

            else -> {

            }
        }
    }
}