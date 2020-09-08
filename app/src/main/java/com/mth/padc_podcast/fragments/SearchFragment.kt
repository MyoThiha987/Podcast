package com.mth.padc_podcast.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mth.padc_podcast.R
import com.mth.padc_podcast.adapters.SearchPodcastAdapter
import com.mth.padc_podcast.data.vos.CategoryVO
import com.mth.padc_podcast.delegate.CategoryDelegate
import com.mth.padc_podcast.mvp.presenters.SearchPodcastPresenter
import com.mth.padc_podcast.mvp.presenters.impls.SearchPodcastPresenterImpl
import com.mth.padc_podcast.mvp.views.SearchPodcastView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() , SearchPodcastView ,CategoryDelegate{
    private lateinit var mSearchPodcastPresenter: SearchPodcastPresenter
    private lateinit var mAdapter : SearchPodcastAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        mSearchPodcastPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mSearchPodcastPresenter = ViewModelProviders.of(this).get(SearchPodcastPresenterImpl::class.java)
        mSearchPodcastPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mAdapter = SearchPodcastAdapter(this)
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rv_category.layoutManager = linearLayoutManager
        rv_category.adapter = mAdapter
    }

    override fun displayGenreList(list: List<CategoryVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun navigateToDetailScreen() {
        TODO("Not yet implemented")
    }

    override fun onTapCategoryListItem() {
        TODO("Not yet implemented")
    }


}