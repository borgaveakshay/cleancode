package news.agoda.com.sample.views

import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import news.agoda.com.sample.R
import news.agoda.com.sample.databinding.ActivityNewsDetailBinding
import news.agoda.com.sample.viewmodel.News

class NewsDetailActivity : AppCompatActivity() {

    lateinit var mNewsDetailBinding: ActivityNewsDetailBinding
    var mNews: News? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent != null) mNews = intent.extras?.getParcelable("news")

        mNewsDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail)
        mNewsDetailBinding.news = mNews

        Glide.with(this)
                .load(mNews?.thumbUrl)
                .apply(RequestOptions().placeholder(R.drawable.place_holder))
                .into(mNewsDetailBinding.newsImage)


    }


    fun onFullStoryClicked(view: View) {

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(mNews?.articleUrl))
        startActivity(intent)

    }
}
