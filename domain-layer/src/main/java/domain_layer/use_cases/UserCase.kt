package domain_layer.use_cases


import domain_layer.common.Transformer
import io.reactivex.Observable

abstract class UserCase<T>(private val transformation: Transformer<T>) {

    abstract fun createObservable(data: Map<String, Any>? = null): Observable<T>


    fun Observable(withData: Map<String, Any>? = null): Observable<T> {

        return createObservable(withData).compose(transformation)
    }
}

