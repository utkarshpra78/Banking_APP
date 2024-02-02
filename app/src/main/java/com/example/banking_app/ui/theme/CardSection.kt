package com.example.banking_app.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banking_app.R
import com.example.banking_app.data.Card

val Cards= listOf(
    Card(
        cardName = "Business",
        cardNumber = "6577 8789 3273 9322",
        cardType = "VISA",
        balance = 45.28,
        color = getGradient(PurpleStart, PurpleEnd),
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "4362 7362 8629 7282",
        cardName = "Savings",
        balance = 345.22,
        color = getGradient(BlueStart, BlueEnd),
    ),
    Card(
        cardName = "School",
        cardType = "VISA",
        cardNumber = "8721 7328 8732 8931",
        balance = 73.29,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        cardNumber = "9831 8989 8738 8878",
        cardType = "MASTERCARD",
        cardName = "Trips",
        balance = 62.28,
        color = getGradient(GreenStart, GreenEnd),
    )
)

fun getGradient(
    startColor: androidx.compose.ui.graphics.Color,
    endColor: androidx.compose.ui.graphics.Color,
): Brush {
   return Brush.horizontalGradient(
       colors = listOf(startColor,endColor)
   )
}

@Preview
@Composable
fun CardSection() {
    LazyRow{
        items(Cards.size){index->
            CardItem(index)
        }
    }
}
@Composable
fun CardItem(
    index:Int
){
    val card=Cards[index]
    var image= painterResource(id =R.drawable.ic_visa )
    if(card.cardType=="MASTERCARD"){
        image=painterResource(id =R.drawable.ic_mastercard )
    }
    Box (
        modifier = Modifier.padding(start = 16.dp,end=16.dp)
    ){
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .height(160.dp)
                .width(250.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = image,
                contentDescription =card.cardName,
                modifier = Modifier
                    .height(30.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            Text(
                text = "$${ card.balance }",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
