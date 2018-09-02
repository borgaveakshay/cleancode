package domain_layer.TestUtils

import domain_layer.domain_entities.NewsEntity
import java.util.*

class TestDataUtils{

    companion object {

        fun getResultItems(): List<NewsEntity>{

            var newsResult: MutableList<NewsEntity> = ArrayList<NewsEntity>()
            for (i:Int  in 0..4){
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