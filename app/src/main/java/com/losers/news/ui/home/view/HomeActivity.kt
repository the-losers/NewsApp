package com.losers.news.ui.home.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.losers.news.R
import com.losers.news.data.network.Article
import com.losers.news.data.network.News
import com.losers.news.ui.Article.view.HomeAdapter
import com.losers.news.ui.base.view.BaseActivity
import com.losers.news.ui.home.interactor.HomeMVPInteractor
import com.losers.news.ui.home.presenter.HomeMVPPresenter
import com.losers.news.ui.homeDetails.view.HomeDetailsActivity
import com.losers.news.util.Misc.Companion.isOnline
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeMVPView {
    override fun isNetworkConnected(): Boolean {
        return isOnline(applicationContext)
    }

    override fun newsResponse(news: News) {
        homeAdapter.addHomesToList(news.articles!!)
    }

    @Inject
    internal lateinit var homeAdapter: HomeAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenter: HomeMVPPresenter<HomeMVPView, HomeMVPInteractor>

    override fun showValidationMessage(errorCode: Int) {
    }


    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = "News Timeline"
        setSupportActionBar(toolbar)
        presenter.onAttach(this)

        setAdapter()
        presenter.onGetNewsData()
    }

    private fun setAdapter() {

        article_rv.layoutManager = layoutManager
        article_rv.itemAnimator = DefaultItemAnimator()
        article_rv.adapter = homeAdapter
        homeAdapter.setContext1(applicationContext)
        homeAdapter.setOnItemClickListener1(object : HomeAdapter.OnItemClickListener {
            override fun onItemClick(article: Article) {
                val gson = Gson()
                Log.d("sdaasdads", gson.toJson(article))
                startActivity(HomeDetailsActivity.getActivityIntent(applicationContext, article))
            }

        })

    }
}
