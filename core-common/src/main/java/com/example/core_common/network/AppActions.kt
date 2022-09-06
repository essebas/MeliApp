package com.example.core_common.network

import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class AppActions {
    @Inject
    @Dispatcher(AppDispatchers.IO)
    lateinit var ioDispatcher: CoroutineDispatcher

    @Inject
    @Dispatcher(AppDispatchers.MAIN)
    lateinit var mainDispatcher: CoroutineDispatcher

    protected suspend fun <T> executeAction(action: suspend () -> T): T =
        withContext(mainDispatcher) { action() }

    protected suspend fun <T> executeNetworkAction(action: suspend () -> T): T =
        withContext(ioDispatcher) { action() }
}