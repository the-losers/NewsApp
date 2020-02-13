package com.losers.news.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.losers.news.R
import com.losers.news.util.Misc.Companion.isOnline
import dagger.android.AndroidInjection


abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    fun setToolbar(toolbar: Toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24px)
        toolbar.setNavigationOnClickListener { view -> finish() }
    }

    override fun isNetworkConnected(): Boolean {
        return isOnline(applicationContext)
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = com.losers.news.util.CommonUtil.showLoadingDialog(this)
    }

    override fun onError() {
    }

    private fun performDI() = AndroidInjection.inject(this)

}