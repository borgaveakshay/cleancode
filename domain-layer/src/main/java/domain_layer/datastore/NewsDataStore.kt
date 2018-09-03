package domain_layer.datastore

import domain_layer.domain_entities.NewsEntity
import io.reactivex.Observable

/**
 * This interface will provider data from network
 */
interface NewsDataStore {

    fun getNews(): Observable<List<NewsEntity>>
}