package com.dev.news.util.resource

import androidx.core.app.NotificationCompat.MessagingStyle.Message

sealed class Resource<T>(val data: T? = null, val message: String?= null) {

    class Success<T>(data: T?) : Resource<T>(data = data)

    class Error<T>(message: String?) : Resource<T>(message = message)



}