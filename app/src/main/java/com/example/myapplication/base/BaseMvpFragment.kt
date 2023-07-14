package com.example.myapplication.base

abstract class BaseMvpFragment<V : IView, P : IPresenter<V>> : BaseFragment(), IView {

    private var mPresenter: P? = null

    abstract fun createPresenter(): P?

    override fun initView() {
        mPresenter = createPresenter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter?.detachView()
        mPresenter = null
    }
}