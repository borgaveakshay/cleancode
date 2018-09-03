package s.com.data_layer.dependencies.components.mappers

import android.util.Log
import com.google.gson.internal.LinkedTreeMap
import domain_layer.common.Mapper
import domain_layer.domain_entities.NewsEntity
import s.com.data_layer.dependencies.components.entities.ResultsItem
import javax.inject.Inject

/**
 * Mapper converter implementation from ResultItem to NewsEntity
 */
class MapperNewsModelToNewsEntity @Inject constructor() : Mapper<ResultsItem, NewsEntity>() {

    override fun mapFrom(from: ResultsItem): NewsEntity {

        val newsEntity = NewsEntity()

        from.let {

            newsEntity.title = from.title
            newsEntity.articleUrl = from.url
            newsEntity.abstract = from.abstract

            /*
            * Some of the MultiMedia parameter value coming as empty string and few of them are list
            * */
            from.multimedia.let {

                if (it is List<*>) {

                    Log.i("multimedia: ", it.toString())

                    val item = it.get(0) as LinkedTreeMap<String, String>
                    newsEntity.thumbUrl = item.get("url")

                }
            }
        }

        return newsEntity
    }
}