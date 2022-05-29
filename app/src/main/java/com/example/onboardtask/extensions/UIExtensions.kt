package com.example.onboardtask.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageWithGlide(url: Any?) = Glide.with(this).load(url).into(this)
