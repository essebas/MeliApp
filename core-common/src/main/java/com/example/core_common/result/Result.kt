package com.example.core_common.result

import com.example.core_common.utils.StringUtil

data class Result<T>(var status: Status, var data: T? = null, val message: String? = StringUtil.EMPTY_STRING) {
    sealed class Status {
        object SUCCESS : Status()
        data class ERROR(val throwable: Throwable?, val code: Int, val errorBody: String = StringUtil.EMPTY_STRING) : Status()
    }

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(
                status = Status.SUCCESS,
                data = data,
                message = null
            )
        }

        fun <T> error(
            exception: Exception,
            code: Int,
            errorBody: String = StringUtil.EMPTY_STRING,
            data: T? = null
        ): Result<T> {
            return Result(
                status = Status.ERROR(exception, code, errorBody),
                data = data,
                message = exception.message
            )
        }
    }
}
