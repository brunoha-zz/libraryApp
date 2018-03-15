package br.com.kituteprogramador.biblioteca.flow.login.model

import br.com.kituteprogramador.biblioteca.commons.network.ApiClient
import br.com.kituteprogramador.biblioteca.commons.network.GenericRequestModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.androidannotations.annotations.EBean

/**
 * Created by brunoalmeida on 15/03/18.
 */

@EBean
class LoginController(){

    val loginService : LoginService = ApiClient.createService(LoginService::class.java)

    fun doLogin( email : String, password : String) : Observable<GenericRequestModel> {
        return loginService.doLogin(email,password)
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
    }

}