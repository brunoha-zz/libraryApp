package br.com.kituteprogramador.biblioteca.commons.mvp

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity

/**
     * Created by brunoalmeida on 14/03/18.
 */

@Suppress("All")
@EActivity
abstract class BaseMvpActivity<in V : BaseMvpView, T : BaseMvpPresenter<V>> : AppCompatActivity(), BaseMvpView {

    protected abstract var mPresenter : T

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mPresenter.attachView(this as V)
    }

    override fun getContext(): Context = this

    override fun showError(error: String?) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun showError(strId : Int) {
        Toast.makeText(this,strId,Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(stringRes: Int) {
        Toast.makeText(this,stringRes,Toast.LENGTH_SHORT).show()
    }

}