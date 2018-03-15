package br.com.kituteprogramador.biblioteca.flow.login.model

import br.com.kituteprogramador.biblioteca.commons.Constants.WebConstants
import br.com.kituteprogramador.biblioteca.commons.network.GenericRequestModel
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by brunoalmeida on 15/03/18.
 */
interface LoginService {

    @POST(WebConstants.LOGIN)
    @FormUrlEncoded
    fun doLogin(@Field("email") email : String, @Field("password") password : String) : Observable<GenericRequestModel>
}