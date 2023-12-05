package sc.fruity.repository.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sc.fruity.BuildConfig
import sc.fruity.data.Fruit
import sc.fruity.repository.FruityRepository

class WebService {
    private val api: RetrofitFruityApi by lazy {
        createApi()
    }

    suspend fun getAll(): List<Fruit> {
        return api.getAll()
    }

    private fun createApi(): RetrofitFruityApi {
        val gsonConverterFactory = GsonConverterFactory.create()

        val retrofit = Retrofit.Builder()
          //  .baseUrl(BuildConfig.FRUITY_BASE_URL)
            .baseUrl(FruityRepository.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()

        return retrofit.create(RetrofitFruityApi::class.java)

    }
}