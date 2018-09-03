package news.agoda.com.sample.views

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import news.agoda.com.sample.R
import news.agoda.com.sample.Utils.App
import news.agoda.com.sample.databinding.ActivityNewsBinding
import news.agoda.com.sample.dependencies.components.AppComponent
import news.agoda.com.sample.dependencies.components.DaggerAppComponent
import news.agoda.com.sample.dependencies.modules.AppModule
import news.agoda.com.sample.observables.NewsScreenObservable

class NewsActivity : AppCompatActivity() {

    lateinit var mNewsActivityBinding: ActivityNewsBinding
    lateinit var mAppComponent: AppComponent
    lateinit var mNewsScreenObservable: NewsScreenObservable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNewsActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_news)

        mAppComponent = DaggerAppComponent
                .builder()
                .networkComponent(App.app.networkComponent)
                .appModule(AppModule(this))
                .build()
        mNewsScreenObservable = mAppComponent.getNewsScreenObservable()

        mNewsScreenObservable.newsAdapter.setOnItemClickListener { news ->

            val detailActivity = Intent(this@NewsActivity, NewsDetailActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable("news", news)
            detailActivity.putExtras(bundle)
            startActivity(detailActivity)
        }
        mNewsActivityBinding.list.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL))
        mNewsActivityBinding.newsObserver = mNewsScreenObservable
        mNewsActivityBinding.list.adapter = mNewsScreenObservable.newsAdapter
        mNewsScreenObservable.getNews()

    }


}
