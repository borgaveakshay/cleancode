package news.agoda.com.sample.observables

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import domain_layer.common.Mapper
import domain_layer.domain_entities.NewsEntity
import domain_layer.use_cases.NewsUseCase
import news.agoda.com.sample.adapters.NewsAdapter
import news.agoda.com.sample.viewmodel.News
import javax.inject.Inject

class NewsScreenObservable @Inject constructor(val newsUseCase: NewsUseCase,
                                               val newsMapper: Mapper<NewsEntity, News>
                                               , val newsAdapter: NewsAdapter
                                               , var newsList: List<News>) : ViewModel() {

    var isLoading: ObservableField<Boolean> = ObservableField()


    init {
        isLoading.set(true)

    }

    fun getNews() {

        if (newsList.isEmpty()) {
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
        }

    }

    fun updateNewsAdapter() {
        newsAdapter.updateItems(newsList)
    }


}