package com.example.gitproject.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class License(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("spdx_id")
	val spdxId: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null
) : Parcelable