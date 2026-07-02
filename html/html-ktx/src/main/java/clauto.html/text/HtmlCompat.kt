@file:Suppress("unused")

package com.clauto.html.text

import android.text.Html
import android.text.Spanned

fun CharSequence.toHtml(flags: Int = 0, imageGetter: Html.ImageGetter? = null, tagHandler: HtmlCompat.TagHandler? = null): Spanned {
    return HtmlCompat.fromHtml(this.toString(), flags, imageGetter, tagHandler)
}