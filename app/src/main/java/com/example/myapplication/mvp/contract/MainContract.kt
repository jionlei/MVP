package com.example.myapplication.mvp.contract

import com.example.myapplication.base.IModel
import com.example.myapplication.base.IPresenter
import com.example.myapplication.base.IView

interface MainContract {

    interface View : IView {

    }

    interface Model : IModel {

    }

    interface Presenter : IPresenter<View> {

    }
}