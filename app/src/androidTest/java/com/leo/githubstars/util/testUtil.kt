package com.leo.githubstars.util

fun Long?.waitTest(){
    this?.let {
        Thread.sleep(it)
    }
}

fun Int?.waitTest(){
    this?.let {
        try {
            var value = it * 1000L
            Thread.sleep(value)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}

