package domain_layer.use_cases


import domain_layer.common.Transformer
import io.reactivex.Observable

/**
 * This is a base use case class each use case implementation will extend this class and provide desired operations
 */

abstract class UserCase<T>(private val transformation: Transformer<T>) {

    abstract fun createObservable(data: Map<String, Any>? = null): Observable<T>


    /**
     * Method use to return Observable data.
     */
    fun Observable(withData: Map<String, Any>? = null): Observable<T> {

        return createObservable(withData).compose(transformation)
    }
}

