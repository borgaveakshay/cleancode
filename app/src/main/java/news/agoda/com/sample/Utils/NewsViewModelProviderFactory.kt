package news.agoda.com.sample.Utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import domain_layer.use_cases.NewsUseCase
import news.agoda.com.sample.adapters.NewsAdapter
import news.agoda.com.sample.mappers.MapperNewsEntityToNews
import news.agoda.com.sample.observables.NewsScreenObservable
import news.agoda.com.sample.viewmodel.News
import javax.inject.Inject

class NewsViewModelProviderFactory @Inject constructor(private val newsUseCase: NewsUseCase
                                                       , private val mappersNewsEntityToNews: MapperNewsEntityToNews
                                                       , private val newsAdapter: NewsAdapter
                                                       , var newsList: List<News>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsScreenObservable(newsUseCase, mappersNewsEntityToNews, newsAdapter, newsList) as T
    }
}