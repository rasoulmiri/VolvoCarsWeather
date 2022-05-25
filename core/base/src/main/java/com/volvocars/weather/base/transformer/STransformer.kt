package com.volvocars.weather.base.transformer

import io.reactivex.SingleTransformer

abstract class STransformer<T> : SingleTransformer<T, T>