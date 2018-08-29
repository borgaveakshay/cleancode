package domain_layer.use_cases

import domain_layer.common.Transformer
import domain_layer.domain_entities.NewsModel
import domain_layer.repositories.NewsRepository
import io.reactivex.Observable

class NewsUseCase(private val newsRepository: NewsRepository,
                  transformer: Transformer<NewsModel>) : UserCase<NewsModel>(transformer) {

    override fun createObservable(data: Map<String, Any>?): Observable<NewsModel> {
        return newsRepository.getNews()
    }
}