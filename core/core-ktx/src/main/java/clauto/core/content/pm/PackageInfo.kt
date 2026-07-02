package com.clauto.core.content.pm

import android.content.pm.PackageInfo
import com.clauto.core.util.BuildUtils

@Suppress("DEPRECATION")
inline val PackageInfo.longVersionCodeCompat: Long
    get() {
        return if (BuildUtils.atLeast28)
            longVersionCode
        else
            versionCode.toLong()
    }