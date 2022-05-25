package com.volvocars.weather.uikit.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val jobs = HashMap<String, Job>()

    fun track(jobName: String? = null, block: suspend CoroutineScope.() -> Unit) {
        val job = viewModelScope.launch(context = Dispatchers.IO, block = block)
        jobs[jobName ?: job.hashCode().toString()] = job
    }

    fun removeJobByName(jobName: String) {
        jobs[jobName]?.cancel()
        jobs.remove(jobName)
    }

    fun removeAllJob() {
        jobs.forEach {
            it.value.cancel()
        }
        jobs.clear()
    }


}