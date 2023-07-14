package com.example.myapplication.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutRes() :  Int

    protected open fun initView() {

    }

    protected open fun initData() {

    }

    protected open fun initListener() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initView()
        initData()
        initListener()
    }

}