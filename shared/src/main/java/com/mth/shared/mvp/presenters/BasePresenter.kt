package com.mth.shared.mvp.presenters

import com.mth.shared.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view : T)
}