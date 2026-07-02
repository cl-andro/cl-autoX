@file:Suppress("unused", "NOTHING_TO_INLINE")

package com.clauto.core.database

import android.database.Cursor

inline fun Cursor.getColumnIndexOrNull(columnName: String): Int? {
    val index = getColumnIndex(columnName)
    return if (index < 0) null else index
}