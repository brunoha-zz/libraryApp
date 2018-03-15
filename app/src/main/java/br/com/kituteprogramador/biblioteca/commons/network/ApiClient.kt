package br.com.kituteprogramador.biblioteca.commons.network

import br.com.kituteprogramador.biblioteca.BuildConfig
import br.com.kituteprogramador.biblioteca.commons.Constants.WebConstants
import br.com.kituteprogramador.biblioteca.commons.utils.Extensions.getSimpleLogging
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by brunoalmeida on 15/03/18.
 */
open class ApiClient {


    companion object {
        private val HEADER_TIMEZONE = "Timezone"

        private lateinit var sRetrofit: Retrofit
        private lateinit var sHttpClientBuilder: OkHttpClient.Builder

        fun <S> createService(serviceClass : Class<S>) : S {
            sHttpClientBuilder = OkHttpClient.Builder()

            sHttpClientBuilder.addNetworkInterceptor {

                chain: Interceptor.Chain ->

                val original = chain.request()

                val requestBuilder = original.newBuilder()
                        .header(HEADER_TIMEZONE, "America/Sao_Paulo")
                        .method(original.method(),original.body())

                val request = requestBuilder.build()
                chain.proceed(request)

            }

            if (BuildConfig.DEBUG){
                sHttpClientBuilder.addInterceptor(HttpLoggingInterceptor().getSimpleLogging())
            }
            val client = sHttpClientBuilder
                    .readTimeout(15, TimeUnit.SECONDS)
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .build()
            sRetrofit = getClientBuilder(WebConstants.BASEURL).client(client).build()
            return sRetrofit.create(serviceClass)
        }

        private fun getClientBuilder(baseUrl: String): Retrofit.Builder {
            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
        }


    }


}

