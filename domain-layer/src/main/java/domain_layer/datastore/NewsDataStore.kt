package domain_layer.datastore

import domain_layer.domain_entities.NewsEntity
import io.reactivex.Observable

interface NewsDataStore {

    fun getNews(): Observable<List<NewsEntity>>
}