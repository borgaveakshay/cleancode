package s.com.domain_layer

import domain_layer.TestUtils.TestDataUtils
import domain_layer.TestUtils.TestTransformer
import domain_layer.domain_entities.NewsModel
import domain_layer.repositories.NewsRepository
import domain_layer.use_cases.NewsUseCase
import io.reactivex.Observable
import org.junit.Test
import org.mockito.Mockito


class UseCasesUnitTest {

    @Test
    fun getNews() {

        val newsRepository = Mockito.mock(NewsRepository::class.java)
        Mockito.`when`(newsRepository.getNews()).thenReturn(Observable.just(getNewsTestData()))
        val news = NewsUseCase(newsRepository, TestTransformer())
        news.Observable().test()
                .assertValue {
                    it.results!!.isEmpty()
                }
                .assertComplete()

    }


    fun getNewsTestData(): NewsModel {

        return TestDataUtils.getNewsResults()
    }
}