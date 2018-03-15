package br.com.kituteprogramador.biblioteca.commons.mvp

/**
 * Created by brunoalmeida on 14/03/18.
 */
interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(view : V)

    fun detachView()

}