package com.example.expensetracker.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.expensetracker.R
import com.example.expensetracker.ui.theme.Destructive
import com.example.expensetracker.ui.theme.TextPrimary
import com.example.expensetracker.ui.theme.Typography


//Create settings Table
//Put it in a row
@Composable
fun TableRow(label: String, onClick: (String) -> Unit, hasArrow: Boolean = false, isDestructive: Boolean = false){
    val textColor = if (isDestructive) Destructive else TextPrimary

        Row(
            modifier = Modifier
                .fillMaxWidth()
                //Click for table row
                .clickable {onClick(label)}
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = label, style = Typography.bodyMedium, color = textColor)

            //if hasArrow is true -> show arrow icon
            if (hasArrow) {
                Icon(
                    painterResource(id = R.drawable.chevron),
                    contentDescription = "Right arrow"
                )

            }

        }
}