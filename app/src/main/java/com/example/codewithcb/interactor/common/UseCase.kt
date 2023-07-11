//package com.example.codewithcb.interactor.common
//
//import com.example.codewithcb.domain.core.RequestResult
//import com.example.codewithcb.domain.core.mapToErrorEntity
//
//abstract class UseCase<in I : InputValues, T> {
//    suspend operator fun invoke(input: I): RequestResult<T> {
//        return try {
//            execute(input)
//        } catch (th: Throwable) {
//            var code  = th.message?.toIntOrNull()
//            if (code == null) {
//                code = 0
//            }
//
//            RequestResult.Error(th.mapToErrorEntity())
//        }
//    }
//
//    protected abstract suspend fun execute(input: I): RequestResult<T>
//}
//
//interface InputValues
//
//abstract class UseCaseV2<in I : InputValues, R> {
//    suspend operator fun invoke(input: I): Result<R> {
//        return try {
//            execute(input)
//        } catch (th: Throwable) {
//            Result.failure(th)
//        }
//    }
//
//    protected abstract suspend fun execute(input: I): Result<R>
//}
