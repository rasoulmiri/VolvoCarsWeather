package com.volvocars.weather.base.usecase

interface SyncUseCase<RQ, RS> {
    fun executeSync(rq: RQ): RS
}