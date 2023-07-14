package com.example.myapplication.mvp.presenter

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.mvp.contract.MainContract
import com.example.myapplication.mvp.model.presenter.MainModel

class MainPresenter :BasePresenter<MainContract.Model,MainContract.View>(), MainContract.Presenter{

    override fun createModel():  MainContract.Model = MainModel()


}