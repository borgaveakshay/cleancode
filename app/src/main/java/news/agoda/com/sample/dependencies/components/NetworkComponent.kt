package news.agoda.com.sample.dependencies.components

import dagger.Component
import domain_layer.repositories.NewsRepository
import news.agoda.com.sample.dependencies.modules.NetworkModule
import news.agoda.com.sample.dependencies.scopes.NetworkScope
import s.com.data_layer.dependencies.components.api.Api

@NetworkScope
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun getApi(): Api
    fun getNewsRepository(): NewsRepository
}