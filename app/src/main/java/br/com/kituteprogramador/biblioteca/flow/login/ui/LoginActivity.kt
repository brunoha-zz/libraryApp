package br.com.kituteprogramador.biblioteca.flow.login.ui

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import br.com.kituteprogramador.biblioteca.R
import br.com.kituteprogramador.biblioteca.commons.mvp.BaseMvpActivity
import br.com.kituteprogramador.biblioteca.commons.utils.Extensions.verifyIsFilled
import br.com.kituteprogramador.biblioteca.flow.login.presenter.LoginContract
import br.com.kituteprogramador.biblioteca.flow.login.presenter.LoginPresenter
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.activity_login.*
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EActivity

@SuppressLint("Registered")
@EActivity(R.layout.activity_login)
class LoginActivity : BaseMvpActivity<LoginContract.View, LoginPresenter>(), LoginContract.View {

    override fun doLogin() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var mPresenter: LoginPresenter = LoginPresenter()

    override fun enableLoginButton() {
        RxTextView.textChangeEvents(loginPasswordInput).subscribe({
            verifyFields()
        })

        RxTextView.textChangeEvents(loginEmailInput).subscribe({
            verifyFields()
        })

    }

    @AfterViews
    fun afterViews(){
        enableLoginButton()
    }

    private fun verifyFields() {
        loginButton.isEnabled = loginEmailInput.verifyIsFilled() && loginPasswordInput.verifyIsFilled()
    }

    @Click(R.id.loginButton)
    fun login() {
        mPresenter.doLogin(loginEmailInput.text.toString(),loginPasswordInput.text.toString())
    }

}
