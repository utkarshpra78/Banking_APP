package com.example.banking_app.ui.theme


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banking_app.data.Currency

val currencyList= listOf(
    Currency(
        name="USD",
        open = 23.46,
        close = 45.22,
        icon=Icons.Rounded.MonetizationOn
    ),
    Currency(
        name="EUR",
        open = 21.46,
        close = 15.22,
        icon=Icons.Rounded.Euro
    ),
    Currency(
        name="YEN",
        open = 56.86,
        close = 15.12,
        icon=Icons.Rounded.CurrencyYen
    ),
    Currency(
        name="USD",
        open = 17.27,
        close = 18.22,
        icon=Icons.Rounded.MonetizationOn
    ),
)

@Preview
@Composable
fun CurrencySection() {
    Column{
        for(i in currencyList){
            CurrencySectionItem(i)
        }
    }
}

@Composable
fun CurrencySectionItem(
    curr:Currency
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Box {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    imageVector = curr.icon,
                    contentDescription = curr.name,
                    tint = GreenStart,
                    modifier = Modifier
                        .size(25.dp)
                )
                Text(
                    text = curr.name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
        Text(
            text = "$${ curr.open }",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "$${ curr.close }" ,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}