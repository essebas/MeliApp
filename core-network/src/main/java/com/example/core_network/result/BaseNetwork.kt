package com.example.core_network.result

import retrofit2.Response
import com.example.core_common.result.Result
import com.example.core_common.utils.StringUtil

abstract class BaseNetwork {
    protected inline fun <reified T> getResult(call: () -> Response<T>): Result<T> {
        var code = 0
        try {
            val response = call()
            code = response.code()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(response.body())
            }
            return error(
                Exception(response.message()),
                code,
                response.errorBody()?.string().orEmpty(),
                response.body()
            )
        } catch (e: Exception) {
            return error(e, code, StringUtil.EMPTY_STRING)
        }
    }

    fun <T> error(e: Exception, code: Int, errorBody: String, data: T? = null): Result<T> {
        return Result.error(e, code, errorBody, data)
    }
}