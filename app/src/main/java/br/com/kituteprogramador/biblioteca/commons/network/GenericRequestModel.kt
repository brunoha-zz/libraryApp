package br.com.kituteprogramador.biblioteca.commons.network

import com.squareup.moshi.Json

/**
 * Created by brunoalmeida on 15/03/18.
 */
open class GenericRequestModel(@Json(name = "msg") val msg: String,
                               @Json(name = "buziness_success") val businessSucess: Boolean)