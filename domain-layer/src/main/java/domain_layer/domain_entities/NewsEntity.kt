package domain_layer.domain_entities

data class NewsEntity(var title: String? = "",
                      var articleUrl: String? = "",
                      var caption: String? = "",
                      var abstract: String? = "",
                      var thumbUrl: String? = "")