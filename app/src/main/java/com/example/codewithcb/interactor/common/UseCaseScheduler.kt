package com.example.codewithcb.interactor.common

//import android.os.Handler
//import android.os.Looper
//import com.example.codewithcb.interactor.common.UseCase.ResponseValues
//import com.example.codewithcb.interactor.common.UseCase.UseCaseCallBack
//import java.util.concurrent.ArrayBlockingQueue
//import java.util.concurrent.ThreadPoolExecutor
//import java.util.concurrent.TimeUnit
//
//interface UseCaseScheduler {
//
//    fun execute(runnable: Runnable)
//
//    fun <V : ResponseValues> notifyResponse(response: V,
//        useCaseCallback: UseCaseCallBack<V>
//    )
//
//    fun <V : ResponseValues> onError(
//        useCaseCallback: UseCaseCallBack<V>, t: Throwable)
//}
//
//
//class UseCaseThreadPoolScheduler : UseCaseScheduler {
//
//    val POOL_SIZE = 2
//
//    val MAX_POOL_SIZE = 4
//
//    val TIMEOUT = 30
//
//    private val mHandler = Handler(Looper.getMainLooper())
//
//    internal var mThreadPoolExecutor: ThreadPoolExecutor
//
//    init {
//        mThreadPoolExecutor = ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIMEOUT.toLong(),
//            TimeUnit.SECONDS, ArrayBlockingQueue(POOL_SIZE)
//        )
//    }
//
//    override fun execute(runnable: Runnable) {
//        mThreadPoolExecutor.execute(runnable)
//    }
//
//    override fun <V : ResponseValues> notifyResponse(response: V,
//        useCaseCallback: UseCaseCallBack<V>
//    ) {
//        mHandler.post { useCaseCallback.onSuccess(response) }
//    }
//
//    override fun <V : ResponseValues> onError(
//        useCaseCallback: UseCaseCallBack<V>, t: Throwable) {
//        mHandler.post { useCaseCallback.onError(t) }
//    }
//
//}