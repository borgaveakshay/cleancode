package domain_layer.repositories

import domain_layer.domain_entities.NewsEntity
import io.reactivex.Observable

/**
 * repository which will provide news data
 */
interface NewsRepository{

    fun getNews(): Observable<List<NewsEntity>>
}