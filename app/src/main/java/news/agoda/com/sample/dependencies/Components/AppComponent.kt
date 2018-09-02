package news.agoda.com.sample.dependencies.components

import dagger.Component
import news.agoda.com.sample.Utils.NewsViewModelProviderFactory
import news.agoda.com.sample.adapters.NewsAdapter
import news.agoda.com.sample.dependencies.modules.AppModule
import news.agoda.com.sample.dependencies.scopes.AppScope
import news.agoda.com.sample.observables.NewsScreenObservable

@AppScope
@Component(modules = [AppModule::class], dependencies = [NetworkComponent::class])
interface AppComponent{

    fun getNewsScreenObservable(): NewsScreenObservable
    fun getNewsAdapter(): NewsAdapter
    fun getNewsViewModelFactory(): NewsViewModelProviderFactory
}