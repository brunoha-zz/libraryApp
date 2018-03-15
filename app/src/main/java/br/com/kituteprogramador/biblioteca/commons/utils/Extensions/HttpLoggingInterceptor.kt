package br.com.kituteprogramador.biblioteca.commons.utils.Extensions

import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by brunoalmeida on 15/03/18.
 */

fun HttpLoggingInterceptor.getSimpleLogging() : HttpLoggingInterceptor {

    val logging = this
    // logging: use NONE | HEADERS | BASIC | BODY to see request data
    logging.level = HttpLoggingInterceptor.Level.BODY

    return logging

}