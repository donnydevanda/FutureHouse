package com.example.futurehouse.CreateProject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Project (
    var title: String ?="",
    var desc: String ?="",
    var address: String ?="",
    var duration: String ?="",
    var frontend: String ?="",
    var backend: String ?="",
    var ui: String ?="",
    var ux: String ?="",
    var images: String ?=""
): Parcelable