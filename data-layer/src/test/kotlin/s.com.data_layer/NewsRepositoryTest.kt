package s.com.data_layer

import domain_layer.common.Mapper
import domain_layer.datastore.NewsDataStore
import domain_layer.domain_entities.NewsEntity
import domain_layer.repositories.NewsRepository
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import s.com.data_layer.dependencies.components.Utils.TestUtils
import s.com.data_layer.dependencies.components.api.Api
import s.com.data_layer.dependencies.components.datastore.NewsDataStoreImpl
import s.com.data_layer.dependencies.components.entities.NewsModel
import s.com.data_layer.dependencies.components.entities.ResultsItem
import s.com.data_layer.dependencies.components.mappers.MapperNewsModelToNewsEntity
import s.com.data_layer.dependencies.components.repositiories.NewsRepositoryImpl

class NewsRepositoryTest {

    lateinit var api: Api
    lateinit var newsRepository: NewsRepository
    lateinit var newsDataStore: NewsDataStore
    val resultModelToEntityMapper: Mapper<ResultsItem, NewsEntity> = MapperNewsModelToNewsEntity()


    @Before
    fun before() {

        api = Mockito.mock(Api::class.java)
        newsDataStore = NewsDataStoreImpl(api, resultModelToEntityMapper)
        newsRepository = NewsRepositoryImpl(api, resultModelToEntityMapper)
    }

    @Test
    fun testNewsRepositoryRemoteResponse() {

        Mockito.`when`(api.getNews()).thenReturn(Observable.just(getNewsModel()))
        newsRepository.getNews().test()
                .assertValue {
                    it.size == 5
                }
                .assertComplete()

    }

    @Test
    fun testNewsDataStoreRemoteResponse() {

        Mockito.`when`(api.getNews()).thenReturn(Observable.just(getNewsModel()))
        newsDataStore.getNews().test()
                .assertValue {
                    it.size == 5
                }
                .assertComplete()

    }

    fun getNewsModel(): NewsModel {

        return TestUtils.getResultItems()
    }

}