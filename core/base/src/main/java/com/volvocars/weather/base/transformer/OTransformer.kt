package com.volvocars.weather.base.transformer

import io.reactivex.ObservableTransformer

abstract class OTransformer<T> : ObservableTransformer<T, T>