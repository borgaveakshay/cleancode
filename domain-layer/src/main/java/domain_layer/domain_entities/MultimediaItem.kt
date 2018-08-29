package domain_layer.domain_entities

data class MultimediaItem(val copyright: String = "",
                          val subtype: String = "",
                          val format: String = "",
                          val width: Int = 0,
                          val caption: String = "",
                          val type: String = "",
                          val url: String = "",
                          val height: Int = 0)