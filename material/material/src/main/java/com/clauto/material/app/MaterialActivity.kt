package com.clauto.material.app

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.CallSuper
import com.clauto.core.res.ResourcesCompatLayoutInflaterListener
import com.clauto.core.res.resolveColor
import com.clauto.insets.WindowInsetsHelper
import com.clauto.layoutinflater.view.LayoutInflaterFactory
import com.clauto.material.R
import com.clauto.material.internal.ThemedAppCompatActivity
import com.clauto.material.widget.FakeFontWeightOnCreateViewListener

open class MaterialActivity : ThemedAppCompatActivity(), TranslucentSystemBars {

    override fun onCreate(savedInstanceState: Bundle?) {
        onInstallViewFactory(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)

        if (shouldApplyTranslucentSystemBars()) {
            onApplyTranslucentSystemBars()
        }
    }

    open fun onInstallViewFactory(layoutInflater: LayoutInflater) {
        layoutInflater.factory2 = onCreateLayoutInflaterFactory()
    }

    open fun onCreateLayoutInflaterFactory(): LayoutInflaterFactory {
        return LayoutInflaterFactory(delegate).apply {
            addOnViewCreatedListeners(
                WindowInsetsHelper.LISTENER,
                ToolbarTitleAlignmentFix.LISTENER
            )

            addOnCreateViewListener(FakeFontWeightOnCreateViewListener.getInstance())

            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
                addOnViewCreatedListeners(
                    ResourcesCompatLayoutInflaterListener.getInstance()
                )
            }
        }
    }

    override fun shouldApplyTranslucentSystemBars(): Boolean {
        return true
    }

    @CallSuper
    override fun onApplyTranslucentSystemBars() {
        val window = window
        val theme = theme

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window?.decorView?.post {
                if (window.decorView.rootWindowInsets?.systemWindowInsetBottom ?: 0 >= Resources.getSystem().displayMetrics.density * 40) {
                    window.navigationBarDividerColor = theme.resolveColor(R.attr.navigationBarDividerColor)
                }
            }
        }
    }
}
