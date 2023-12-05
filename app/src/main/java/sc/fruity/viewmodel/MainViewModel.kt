package sc.fruity.viewmodel;

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sc.fruity.data.Fruit
import sc.fruity.repository.FruityRepository
import sc.fruity.repository.remote.WebService
import kotlin.system.measureTimeMillis

class MainViewModel(): ViewModel() {
    var isRefreshing = mutableStateOf(false)
        private set
    var fruits: List<Fruit>? by mutableStateOf(null)
        private set

    private val repository = FruityRepository(
        WebService()
    )

    fun getAllFruits() = viewModelScope.launch {
        isRefreshing.value = true
        val time = measureTimeMillis {
            val response = repository.getAll()
            fruits = response
            isRefreshing.value = false
        }
        Log.i("REQUEST TIME :: ", " Time take :: $time ms")

    }

}
