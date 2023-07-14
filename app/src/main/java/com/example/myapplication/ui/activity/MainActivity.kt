package com.example.myapplication.ui.activity

import com.example.myapplication.R
import com.example.myapplication.base.BaseMvpActivity
import com.example.myapplication.mvp.contract.MainContract
import com.example.myapplication.mvp.presenter.MainPresenter

class MainActivity : BaseMvpActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {
    override fun createPresenter(): MainContract.Presenter  = MainPresenter()

    override fun getLayoutRes() = R.layout.activity_main

}