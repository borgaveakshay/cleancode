package news.agoda.com.sample.dependencies.modules

import dagger.Module
import dagger.Provides
import domain_layer.repositories.NewsRepository
import news.agoda.com.sample.dependencies.scopes.NetworkScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import s.com.data_layer.dependencies.components.api.Api
import s.com.data_layer.dependencies.components.mappers.MapperNewsModelToNewsEntity
import s.com.data_layer.dependencies.components.repositiories.NewsRepositoryImpl

@Module
class NetworkModule(val baseUrl: String) {

    @Provides
    @NetworkScope
    fun getUrl(): String = baseUrl

    @Provides
    @NetworkScope
    fun getRetrofit(baseUrl: String,
                    okHttpClient: OkHttpClient,
                    gsonConverterFactory: GsonConverterFactory,
                    rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build()


    }

    @Provides
    @NetworkScope
    fun getGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @NetworkScope
    fun getRxJavaConverter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    @NetworkScope
    fun getOkHttpClient(): OkHttpClient = OkHttpClient()

    @Provides
    @NetworkScope
    fun getApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @Provides
    @NetworkScope
    fun getNewsRepository(api: Api, mapperNewsModelToNewsEntity: MapperNewsModelToNewsEntity): NewsRepository = NewsRepositoryImpl(api, mapperNewsModelToNewsEntity)


}