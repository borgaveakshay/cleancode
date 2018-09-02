package s.com.data_layer.dependencies.components.repositiories

import domain_layer.common.Mapper
import domain_layer.datastore.NewsDataStore
import domain_layer.domain_entities.NewsEntity
import domain_layer.repositories.NewsRepository
import io.reactivex.Observable
import s.com.data_layer.dependencies.components.api.Api
import s.com.data_layer.dependencies.components.datastore.NewsDataStoreImpl
import s.com.data_layer.dependencies.components.entities.ResultsItem

class NewsRepositoryImpl(api: Api,
                         resultToNewsEntity: Mapper<ResultsItem, NewsEntity>) : NewsRepository {

    private val newsDataStore: NewsDataStore
    init {
        newsDataStore = NewsDataStoreImpl(api, resultToNewsEntity)
    }

    override fun getNews(): Observable<List<NewsEntity>> {
        return newsDataStore.getNews()
    }
}