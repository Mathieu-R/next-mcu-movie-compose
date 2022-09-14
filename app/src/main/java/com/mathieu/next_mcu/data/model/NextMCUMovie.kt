package com.mathieu.next_mcu.data.model

data class NextMCUMovie(
    val days_until: Int,
    val following_production: FollowingProduction,
    val overview: String,
    val poster_url: String,
    val release_date: String,
    val title: String,
    val type: String
)