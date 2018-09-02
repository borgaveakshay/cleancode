package news.agoda.com.sample.Utils

import android.app.Application
import news.agoda.com.sample.constants.AppConstants
import news.agoda.com.sample.dependencies.components.DaggerNetworkComponent
import news.agoda.com.sample.dependencies.components.NetworkComponent
import news.agoda.com.sample.dependencies.modules.NetworkModule

class App : Application() {


    lateinit var networkComponent: NetworkComponent

    companion object {

        lateinit var app: App
    }

    override fun onCreate() {
        super.onCreate()
        app = this

        networkComponent = DaggerNetworkComponent
                .builder()
                .networkModule(NetworkModule(AppConstants.BASE_URL))
                .build()

    }


}