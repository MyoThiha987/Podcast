package com.mth.padc_podcast.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_podcast.mvp.views.ProfileView
import com.mth.shared.mvp.presenters.BasePresenter

interface ProfilePresenter : BasePresenter<ProfileView> {
    fun onUIReady(lifecycleOwner: LifecycleOwner)

}