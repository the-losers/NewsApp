package com.losers.news.ui.Article.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.losers.news.R
import com.losers.news.data.network.Article

class HomeAdapter(private val articleList: MutableList<Article>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {


    var onItemClickListener: OnItemClickListener? = null
    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_article, parent, false))
    }


    override fun getItemCount() = articleList.size

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) = holder.run {
        clear()
        onBind(position)
    }

    public fun setContext1(context: Context) {
        this.context = context
    }

    internal fun addHomesToList(Homes: List<Article>) {
        this.articleList.addAll(Homes)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener1(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        fun onItemClick(article: Article)
    }

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {

        }

        private var rootView: CardView
        private var titleTv: TextView
        private var authorTv: TextView
        private var timeTv: TextView
        private var sourceTv: TextView
        private var sourceImag: ImageView

        init {

            rootView = view.findViewById(R.id.cv)
            sourceTv = view.findViewById(R.id.source_tv)
            titleTv = view.findViewById(R.id.title_tv)
            authorTv = view.findViewById(R.id.author_tv)
            timeTv = view.findViewById(R.id.time)
            sourceImag = view.findViewById(R.id.imageView)


        }

        fun onBind(position: Int) {
            val data = articleList[position]
            sourceTv.text = data.source?.name
            titleTv.text = data.title
            authorTv.text = data.author
            rootView.setOnClickListener {
                onItemClickListener?.onItemClick(data)
            }
            Glide.with(context)
                    .load(data.urlToImage)
                    .asBitmap()
                    .centerCrop()
                    .into(sourceImag)

        }


    }
}
