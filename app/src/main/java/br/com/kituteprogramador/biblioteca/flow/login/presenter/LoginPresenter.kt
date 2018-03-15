package br.com.kituteprogramador.biblioteca.flow.login.presenter

import br.com.kituteprogramador.biblioteca.commons.mvp.BaseMvpPresenterImpl
import br.com.kituteprogramador.biblioteca.flow.login.model.LoginController
import org.androidannotations.annotations.AfterInject
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject

/**
 * Created by brunoalmeida on 14/03/18.
 */
class LoginPresenter : BaseMvpPresenterImpl<LoginContract.View>(), LoginContract.Presenter {

    var controler = LoginController()

    override fun doFacebookLogin() {
        //TODO - FACEBOOKLOGIN
    }

    override fun doLogin(email: String, password: String) {

        controler.doLogin(email, password).doOnError({
            mView?.showError(it.message)
        }).subscribe({
            mView?.doLogin()
        })
    }

}