package com.example.codewithcb.interactor.common

//class UseCaseHandler(private val useCaseScheduler: UseCaseScheduler) {
//
//    fun <T: RequestValues, R: ResponseValues> execute (
//        usecase: UseCase<T, R>, values: T,  callBack: UseCaseCallBack<R>
//    ) {
//        usecase.requestValues = values
//        usecase.useCaseCallback = UiCallbackWrapper(callBack, this)
//
//    }
//
//    private fun <V : ResponseValues> notifyResponse(response: V,
//        useCaseCallback: UseCase.UseCaseCallBack<V>) {
//        useCaseScheduler.notifyResponse(response, useCaseCallback)
//    }
//
//    private fun <V : ResponseValues> notifyError(
//        useCaseCallback: UseCase.UseCaseCallBack<V>, t: Throwable) {
//        useCaseScheduler.onError(useCaseCallback, t)
//    }
//
//
//    private class UiCallbackWrapper<V : ResponseValues>(
//        private val mCallback: UseCase.UseCaseCallBack<V>,
//        private val mUseCaseHandler: UseCaseHandler
//    ) : UseCase.UseCaseCallBack<V> {
//
//        override fun onSuccess(response: V) {
//            mUseCaseHandler.notifyResponse(response, mCallback)
//        }
//
//        override fun onError(t: Throwable) {
//            mUseCaseHandler.notifyError(mCallback, t)
//        }
//    }

//}