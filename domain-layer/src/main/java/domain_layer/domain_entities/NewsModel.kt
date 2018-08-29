package domain_layer.domain_entities

data class NewsModel(val copyright: String = "",
                     val lastUpdated: String = "",
                     val section: String = "",
                     val results: List<ResultsItem>?,
                     val numResults: Int = 0,
                     val status: String = "")