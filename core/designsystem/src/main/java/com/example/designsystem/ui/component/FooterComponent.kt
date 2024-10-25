package com.example.designsystem.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.designsystem.ui.theme.Black01
import com.example.designsystem.ui.theme.ColorMainBlue500
import com.example.designsystem.ui.theme.Divider
import com.example.designsystem.ui.theme.LocalTypography
import com.example.designsystem.ui.theme.White
import com.example.model.Footer
import com.example.model.type.FooterType

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FooterComponent(footer: Footer, onClick: () -> Unit = {}) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(1.dp, Divider,)
            .background(White),
    ) {
        Button(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .border(1.dp, Divider, shape = RoundedCornerShape(20.dp))
              , onClick = { onClick() }
                , colors = ButtonDefaults.buttonColors(White,ColorMainBlue500 )

            , contentPadding = PaddingValues(0.dp)
              , shape = RoundedCornerShape(20.dp)
        ) {
            when (footer.type) {
                FooterType.MORE -> {
                    Text(footer.title, color = Black01 , style = LocalTypography.current.button)
                }

                FooterType.REFRESH -> {
                    Row (modifier = Modifier.wrapContentSize()){
                        footer.iconURL?.let {iconURL->
                            GlideImage(
                                model = iconURL,
                                contentDescription = "",
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(end = 4.dp)
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                        }
                        Text(footer.title, color = Black01 , style = LocalTypography.current.button)
                    }
                }
            }
        }



    }

}


@Preview(showBackground = true)
@Composable
fun FooterComponentPreview() {
    FooterComponent(Footer(type = FooterType.MORE, "", "")) // 5회 방문 예시
}
