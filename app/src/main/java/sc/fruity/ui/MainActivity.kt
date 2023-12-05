package sc.fruity.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import sc.fruity.ui.theme.FruityTheme
import sc.fruity.ui.widgets.swipetorefresh.PullRefreshIndicator
import sc.fruity.ui.widgets.swipetorefresh.pullRefresh
import sc.fruity.ui.widgets.swipetorefresh.rememberPullRefreshState
import sc.fruity.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FruityTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    FruitList()
                }

            }
        }
    }
}

@Composable
fun FruitList(modifier: Modifier = Modifier, viewModel: MainViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.getAllFruits()
    }
    // val lifecycleOwner = LocalLifecycleOwner.current
    val refreshing = viewModel.isRefreshing.value

    val pullRefreshState = rememberPullRefreshState(refreshing, {
        viewModel.getAllFruits()
    })

    Box(
        Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ) {
        Column {

            if (!refreshing && viewModel.fruits != null) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    items(items = viewModel.fruits!!) { fruit ->
                        FruitItem(fruit = fruit)
                    }
                }

            } else Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) { LinearProgressIndicator() }
        }
        PullRefreshIndicator(refreshing, pullRefreshState, Modifier.align(Alignment.TopCenter))
    }
}

