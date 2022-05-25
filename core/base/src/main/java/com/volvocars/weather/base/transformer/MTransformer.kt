package com.volvocars.weather.base.transformer

import io.reactivex.MaybeTransformer

abstract class MTransformer<T> : MaybeTransformer<T, T>