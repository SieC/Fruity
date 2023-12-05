package sc.fruity.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sc.fruity.data.Fruit
import sc.fruity.repository.remote.RetrofitFruityApi
import sc.fruity.repository.remote.WebService

class FruityRepository(private val fruityWebService: WebService, private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    companion object {
        const val BASE_URL = "https://www.fruityvice.com/api/fruit/"
    }


    suspend fun getAll(): List<Fruit>
            = withContext(defaultDispatcher) {
        return@withContext fruityWebService.getAll()
    }

}