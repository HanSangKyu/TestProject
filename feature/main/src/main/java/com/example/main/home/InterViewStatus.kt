package com.example.main.home

import com.airbnb.mvrx.MavericksState
import com.example.model.Response

data class InterViewStatus(val posts: Response? = null,val link:String="") : MavericksState
