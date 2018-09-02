package news.agoda.com.sample.dependencies.modules

import android.arch.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import domain_layer.repositories.NewsRepository
import domain_layer.use_cases.NewsUseCase
import news.agoda.com.sample.R
import news.agoda.com.sample.Utils.AsyncTransformer
import news.agoda.com.sample.Utils.NewsViewModelProviderFactory
import news.agoda.com.sample.adapters.NewsAdapter
import news.agoda.com.sample.dependencies.scopes.AppScope
import news.agoda.com.sample.observables.NewsScreenObservable
import news.agoda.com.sample.views.NewsActivity

@Module
class AppModule(private val newsActivity: NewsActivity) {

    @Provides
    @AppScope
    fun getActivity(): NewsActivity = newsActivity

    @Provides
    @AppScope
    fun getNewsUseCase(newsRepository: NewsRepository): NewsUseCase = NewsUseCase(newsRepository, AsyncTransformer())

    @Provides
    @AppScope
    fun getNewsScreenObservable(factory: NewsViewModelProviderFactory
                                , newsActivity: NewsActivity): NewsScreenObservable = ViewModelProviders.of(newsActivity, factory).get(NewsScreenObservable::class.java)

    @Provides
    @AppScope
    fun getGlideImageLoader(newsActivity: NewsActivity): RequestManager = Glide.with(newsActivity)

    @Provides
    @AppScope
    fun getNewsAdapter(requestManager: RequestManager): NewsAdapter = NewsAdapter(mutableListOf(), R.layout.list_item_news, requestManager)


}