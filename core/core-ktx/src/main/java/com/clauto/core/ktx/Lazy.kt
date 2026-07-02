@file:Suppress("unused")

package com.clauto.core.ktx

fun <T> unsafeLazy(initializer: () -> T): Lazy<T> = kotlin.lazy(LazyThreadSafetyMode.NONE, initializer)
