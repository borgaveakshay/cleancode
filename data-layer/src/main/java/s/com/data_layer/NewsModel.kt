package s.com.data_layer

data class NewsModel(val copyright: String = "",
                     val lastUpdated: String = "",
                     val section: String = "",
                     val results: List<ResultsItem>?,
                     val numResults: Int = 0,
                     val status: String = "")