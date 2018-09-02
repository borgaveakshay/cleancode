package s.com.data_layer.dependencies.components.api


import io.reactivex.Observable
import retrofit2.http.GET
import s.com.data_layer.dependencies.components.entities.NewsModel

interface Api {

    @GET("/bins/nl6jh")
    fun getNews(): Observable<NewsModel>

}