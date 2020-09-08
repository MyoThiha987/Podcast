package com.mth.padc_podcast.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_podcast.mvp.presenters.AbstractBasePresenter
import com.mth.padc_podcast.mvp.presenters.ProfilePresenter
import com.mth.padc_podcast.mvp.views.ProfileView

class ProfilePresenterImpl : ProfilePresenter,AbstractBasePresenter<ProfileView>() {
    override fun onUIReady(lifecycleOwner: LifecycleOwner) {
        TODO("Not yet implemented")
    }
}