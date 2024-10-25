package com.example.main.home

import com.airbnb.mvrx.MavericksState
import com.example.model.ProductList

data class InterViewStatus(val posts: ProductList? = null, val link:String="") : MavericksState
