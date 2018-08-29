package domain_layer.repositories

import domain_layer.domain_entities.NewsModel
import io.reactivex.Observable

interface NewsRepository{

    fun getNews(): Observable<NewsModel>
}