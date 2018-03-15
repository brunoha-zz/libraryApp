package br.com.kituteprogramador.biblioteca.flow.login.presenter

import android.database.Observable
import android.widget.EditText
import br.com.kituteprogramador.biblioteca.commons.mvp.BaseMvpPresenter
import br.com.kituteprogramador.biblioteca.commons.mvp.BaseMvpView
import com.jakewharton.rxbinding2.view.RxView

/**
 * Created by brunoalmeida on 15/03/18.
 */
interface LoginContract {

    interface View : BaseMvpView {

        fun enableLoginButton()

        fun doLogin()
    }

    interface Presenter : BaseMvpPresenter<View> {

        fun doLogin(email : String, password : String)

        fun doFacebookLogin()

    }
}