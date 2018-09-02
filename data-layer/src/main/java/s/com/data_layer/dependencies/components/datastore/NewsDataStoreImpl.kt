package s.com.data_layer.dependencies.components.datastore

import domain_layer.common.Mapper
import domain_layer.datastore.NewsDataStore
import domain_layer.domain_entities.NewsEntity
import io.reactivex.Observable
import s.com.data_layer.dependencies.components.api.Api
import s.com.data_layer.dependencies.components.entities.ResultsItem

class NewsDataStoreImpl(private val api: Api
                        , private val newsModelToNewsEntity: Mapper<ResultsItem, NewsEntity>) : NewsDataStore {

    override fun getNews(): Observable<List<NewsEntity>> {

        return api.getNews().map { it -> it.results?.map { newsModelToNewsEntity.mapFrom(it) } }

    }
}