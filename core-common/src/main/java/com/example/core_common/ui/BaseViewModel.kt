package com.example.core_common.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_common.network.AppDispatchers
import com.example.core_common.network.Dispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    @Inject
    @Dispatcher(AppDispatchers.IO)
    lateinit var ioDispatcher: CoroutineDispatcher

    @Inject
    @Dispatcher(AppDispatchers.MAIN)
    lateinit var mainDispatcher: CoroutineDispatcher

    protected fun executeBlockOnMain(
        dispatcher: CoroutineDispatcher = mainDispatcher,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(dispatcher) { block() }

    protected fun executeBlockOnBackground(
        dispatcher: CoroutineDispatcher = ioDispatcher,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(dispatcher) { block() }
}