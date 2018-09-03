package domain_layer.use_cases

import domain_layer.common.Transformer
import domain_layer.domain_entities.NewsEntity

import domain_layer.repositories.NewsRepository
import io.reactivex.Observable

/**
 * News use case class, It uses news repository object to return observable data
 */
class NewsUseCase(private val newsRepository: NewsRepository,
                  transformer: Transformer<List<NewsEntity>>) : UserCase<List<NewsEntity>>(transformer) {

    override fun createObservable(data: Map<String, Any>?): Observable<List<NewsEntity>> {
        return newsRepository.getNews()
    }
}