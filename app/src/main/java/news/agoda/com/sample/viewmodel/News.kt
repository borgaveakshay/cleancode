package news.agoda.com.sample.viewmodel

import android.arch.lifecycle.ViewModel
import android.os.Parcel
import android.os.Parcelable

/**
 * Data class for News
 */
data class News(var title: String? = "",
                var articleUrl: String? = "",
                var caption: String? = "",
                var abstract: String? = "",
                var thumbUrl: String? = "") : ViewModel(), Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(title)
        writeString(articleUrl)
        writeString(caption)
        writeString(abstract)
        writeString(thumbUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<News> = object : Parcelable.Creator<News> {
            override fun createFromParcel(source: Parcel): News = News(source)
            override fun newArray(size: Int): Array<News?> = arrayOfNulls(size)
        }
    }
}
