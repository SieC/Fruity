package sc.fruity.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sc.fruity.data.Fruit

@Composable
fun FruitItem(
    fruit: Fruit,
) {

    var expanded by remember { mutableStateOf (false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) ,

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                border = BorderStroke(0.5.dp, color = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = { expanded = !expanded })
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(modifier = Modifier
                .padding(8.dp)
                .align(Start) ,
                text = fruit.name,
                style = TextStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal, fontSize = 22.sp)
            )
            RowItem(label = "Family", text = fruit.family)



            if (expanded) {

                Text(
                    text = "Nutritional content",
                    modifier = Modifier
                        .padding(start = 8.dp, bottom = 2.dp, top = 8.dp)
                        .align(Start) ,
                    style = MaterialTheme.typography.bodyLarge
                )
                Divider(thickness = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                RowItem(label = "Fat", text = "${fruit.nutritions.fat} g" )
                RowItem(label = "Sugar", text = "${fruit.nutritions.sugar} g" )
                RowItem(label = "Carbohydrates", text = "${fruit.nutritions.carbohydrates} g" )
                RowItem(label = "Protein", text = "${fruit.nutritions.protein} g" )
            }
        }
    }
}