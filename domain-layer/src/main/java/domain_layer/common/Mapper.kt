package domain_layer.common

import io.reactivex.Observable

/**
 * This template class can be extended to convert entity object from one to another
 */

abstract class Mapper<in T, E> {

    abstract fun mapFrom(from: T): E


    fun observable(from: T): Observable<E> {

        return Observable.fromCallable { mapFrom(from) }
    }


    fun observable(from: List<T>): Observable<List<E>> {

        return Observable.fromCallable { from.map { mapFrom(it) }  }

    }
}