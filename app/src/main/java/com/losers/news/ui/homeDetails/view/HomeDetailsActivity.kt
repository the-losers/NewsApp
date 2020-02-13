package com.losers.news.ui.homeDetails.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.losers.news.R
import com.losers.news.data.network.Article
import com.losers.news.ui.base.view.BaseActivity
import com.losers.news.ui.homeDetails.interactor.HomeDetailsMVPInteractor
import com.losers.news.ui.homeDetails.presenter.HomeDetailsMVPPresenter
import kotlinx.android.synthetic.main.activity_home_details.*
import javax.inject.Inject

public const val ARTICLE_DATA = "ARTICLE_DATA"

class HomeDetailsActivity : BaseActivity(), HomeDetailsMVPView {

    companion object {
        fun getActivityIntent(context: Context): Intent {
            val intent = Intent(context, HomeDetailsActivity::class.java)
            return intent
        }

        fun getActivityIntent(context: Context, article: Article): Intent {
            val intent = Intent(context, HomeDetailsActivity::class.java)
            intent.putExtra(ARTICLE_DATA, article)
            return intent
        }
    }

    @Inject
    internal lateinit var presenter: HomeDetailsMVPPresenter<HomeDetailsMVPView, HomeDetailsMVPInteractor>

    private var article: Article? = null
    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_details)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = "News"
        setSupportActionBar(toolbar)
        setToolbar(toolbar)
        presenter.onAttach(this)

        val bundle = intent.extras
        if (bundle == null) {
            finish()
            return
        }

        article = bundle.getParcelable(ARTICLE_DATA)
        init()
    }

    private fun init(){
        title_tv.text = article?.title
        description_tv.text = article?.description
        author_tv.text = article?.author

        Glide.with(applicationContext)
                .load(article?.urlToImage)
                .asBitmap()
                .centerCrop()
                .into(source_imv)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}
