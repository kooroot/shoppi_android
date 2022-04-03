package com.jnhtest.shoppingproject.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    val badge: BannerBadge,
    val label: String,
    @SerializedName("product_detail") val productDetail: ProductDetail
)

data class BannerBadge(
    val label: String,
    @SerializedName("background_color") val backgroundColor: String
)

