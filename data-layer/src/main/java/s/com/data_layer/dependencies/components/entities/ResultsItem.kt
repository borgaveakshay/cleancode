package s.com.data_layer.dependencies.components.entities

data class ResultsItem(val perFacet: List<String>?,
                       val subsection: String = "",
                       val itemType: String = "",
                       val orgFacet: List<String>?,
                       val section: String = "",
                       val abstract: String = "",
                       val title: String = "",
                       val desFacet: List<String>?,
                       val url: String = "",
                       val materialTypeFacet: String = "",
                       val multimedia: Any?,
                       val geoFacet: List<String>?,
                       val updatedDate: String = "",
                       val createdDate: String = "",
                       val byline: String = "",
                       val publishedDate: String = "",
                       val kicker: String = "")