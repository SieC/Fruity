package sc.fruity.repository.remote

import retrofit2.http.GET
import sc.fruity.data.Fruit

interface RetrofitFruityApi {
        @GET("all")
        suspend fun getAll(): List<Fruit>
    }

