package news.agoda.com.sample.mappers

import domain_layer.common.Mapper
import domain_layer.domain_entities.NewsEntity
import news.agoda.com.sample.viewmodel.News
import javax.inject.Inject

class MapperNewsEntityToNews @Inject constructor() : Mapper<NewsEntity, News>() {

    override fun mapFrom(from: NewsEntity): News {
        return News(title = from.title,
                caption = from.caption,
                thumbUrl = from.thumbUrl,
                articleUrl = from.articleUrl,
                abstract = from.abstract
        )
    }
}