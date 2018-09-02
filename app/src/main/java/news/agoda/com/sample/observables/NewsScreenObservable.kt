package news.agoda.com.sample.observables

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import domain_layer.common.Mapper
import domain_layer.domain_entities.NewsEntity
import domain_layer.use_cases.NewsUseCase
import news.agoda.com.sample.adapters.NewsAdapter
import news.agoda.com.sample.viewmodel.News

class NewsScreenObservable(val newsUseCase: NewsUseCase,
                           val newsMapper: Mapper<NewsEntity, News>
                           , val newsAdapter: NewsAdapter) : ViewModel() {

    var isLoading: ObservableField<Boolean> = ObservableField()
    var newsList: List<News>? = null

    init {
        isLoading.set(true)

    }

    fun getNews() {

        if (newsList == null) {
            newsUseCase.Observable().map { results -> results.map { newsMapper.mapFrom(it) } }
                    .subscribe({ results ->
                        results.let {
                            isLoading.set(false)
                            newsList = it
                            updateNewsAdapter()
                        }
                    }
                            , {
                        Log.i("error", it?.message)
                        isLoading.set(false)

                    })
        } else {
            isLoading.set(false)
            updateNewsAdapter()
        }

    }

    fun updateNewsAdapter() {
        newsAdapter.updateItems(newsList)
    }


}