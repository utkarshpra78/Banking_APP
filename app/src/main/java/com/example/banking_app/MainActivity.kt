package com.example.banking_app

import android.os.Bundle
import android.view.WindowInsets.Side
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.banking_app.ui.theme.Banking_AppTheme
import com.example.banking_app.ui.theme.CardSection
import com.example.banking_app.ui.theme.CurrencySection
import com.example.banking_app.ui.theme.FinanceSection
import com.example.banking_app.ui.theme.WalletSection
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Banking_AppTheme {
                // A surface container using the 'background' color from the theme
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScree()
                }
            }
        }
    }
    @Composable
    private fun SetBarColor(color: Color){
        val systemUiController= rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color= color
            )
        }
    }
}


@Preview
@Composable
fun HomeScree() {
    Scaffold (
        bottomBar = {
            BottomNavigationBar()
        }
    ){
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            WalletSection()
            CardSection()
            FinanceSection()
            CurrencySection()
        }

    }
}




