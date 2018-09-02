package s.com.data_layer.dependencies.components.Utils

import domain_layer.domain_entities.NewsEntity
import s.com.data_layer.dependencies.components.entities.NewsModel
import s.com.data_layer.dependencies.components.entities.ResultsItem
import java.util.*

class TestUtils {

    companion object {

        fun getResultItems(): NewsModel {

            val newsModel = NewsModel(copyright = "copy right",
                    section = "",
                    status = "",
                    results = getNewsResults())

            return newsModel
        }

        fun getNewsResults(): List<ResultsItem> {

            val newsResult: MutableList<ResultsItem> = ArrayList<ResultsItem>()

            (0..4).map {
                val resultsItem = ResultsItem(
                        abstract = "demo abstract",
                        url = "",
                        multimedia = null,
                        geoFacet = null,
                        title = "Demo title",
                        orgFacet = null,
                        desFacet = null,
                        perFacet = null

                )
                newsResult.add(resultsItem)
            }
            return newsResult
        }

        fun getEntityItems(): List<NewsEntity> {

            val newsResult: MutableList<NewsEntity> = ArrayList<NewsEntity>()
            (0..4).map {
                val resultsItem = NewsEntity(
                        abstract = "demo abstract",
                        articleUrl = "",
                        thumbUrl = "",
                        caption = "",
                        title = "Demo title"
                )
                newsResult.add(resultsItem)
            }

            return newsResult
        }
    }
}