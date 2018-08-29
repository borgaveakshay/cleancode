package domain_layer.TestUtils

import domain_layer.domain_entities.NewsModel
import domain_layer.domain_entities.ResultsItem
import java.util.*

class TestDataUtils{

    companion object {

        fun getNewsResults(): NewsModel{

            return NewsModel(
                    copyright = "copy rights",
                    lastUpdated = "last update",
                    numResults = 4,
                    results = getResultItems(),
                    section = "section",
                    status = "populated"
            )
        }

        fun getResultItems(): List<ResultsItem>{

            var newsResult: List<ResultsItem> = ArrayList<ResultsItem>()
            for (i:Int  in 0..4){
                val resultsItem = ResultsItem( perFacet = null,
                        section = "demo section",
                        abstract = "demo abstract",
                        desFacet = null,
                        createdDate = "Today",
                        geoFacet = null,
                        byline = "",
                        itemType = "news",
                        kicker = "",
                        materialTypeFacet = "",
                        orgFacet = null,
                        multimedia = null,
                        subsection = "demo subsection",
                        publishedDate = "",
                        title = "Demo title",
                        updatedDate = "",
                        url = "")
            }

            return newsResult
        }

    }
}