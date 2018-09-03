package domain_layer.common

import io.reactivex.ObservableTransformer

/**
 * This class can be extended to provider how the observable operation will be performed
 */
abstract class Transformer<T> : ObservableTransformer<T, T>