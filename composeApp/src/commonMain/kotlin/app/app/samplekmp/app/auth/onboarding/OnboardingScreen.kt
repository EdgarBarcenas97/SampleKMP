package app.app.samplekmp.app.auth.onboarding

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import app.app.samplekmp.resources.Space16
import app.app.samplekmp.resources.Space2
import app.app.samplekmp.resources.Space24
import app.app.samplekmp.resources.Space4
import app.app.samplekmp.resources.Space6
import app.app.samplekmp.resources.Space600
import app.app.samplekmp.resources.Space8
import app.app.samplekmp.resources.Weight1
import coil3.compose.AsyncImage

@Composable
fun OnboardingScreen(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    OnboardingScaffold(
        onSignInClick = onSignInClick,
        onSignUpClick = onSignUpClick
    )
}

@Composable
fun OnboardingScaffold(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    val pages = listOf(
        mapOf(
            "title" to "Welcome to Wheels",
            "subtitle" to "Let's find you a bike",
            "image" to "https://images.unsplash.com/photo-1475666675596-cca2035b3d79",
        ), mapOf(
        "title" to "Find a bike in any town",
        "subtitle" to "With over 5,000 spots world wide, we always got you covered",
        "image" to "https://images.unsplash.com/photo-1605028241606-ca01277aa15c",
    ), mapOf(
        "title" to "Safety above all",
        "subtitle" to "Travel with peace of mind, thanks to our safety features",
        "image" to "https://images.unsplash.com/photo-1517305349393-aad1f0ee4328",
    )
    )
    val pagerState = rememberPagerState { pages.size }

    Scaffold {
        Column(
            modifier = Modifier.background(Color.Black)
        ) {
            HorizontalPager(
                state = pagerState, modifier = Modifier.weight(Weight1)
            ) { page ->
                val item = pages[page]
                val title = item.getValue("title")
                val subtitle = item.getValue("subtitle")
                val image = item.getValue("image")
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = image,
                        modifier = Modifier.fillMaxSize().background(Color.Black),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black)))
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(Space24)
                            .widthIn(max = Space600)
                            .fillMaxWidth(),
                    ) {
                        CompositionLocalProvider(
                            value = LocalContentColor provides Color.White
                        ) {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.headlineLarge,
                                textAlign = TextAlign.Start
                            )
                            Spacer(modifier = Modifier.height(Space4))
                            Text(
                                text = subtitle,
                                style = MaterialTheme.typography.headlineSmall,
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(Space6),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                val currentPage = pagerState.currentPage
                repeat(pages.size) { iteration ->
                    val color = if (currentPage == iteration) Color.White else Color.Gray
                    val size by animateDpAsState(if (currentPage == iteration) Space8 else Space6)
                    Box(
                        modifier = Modifier.size(Space8),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(color)
                                .size(size)
                        )
                    }
                }
            }
            Spacer(
                modifier = Modifier.height(Space24)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(Space2),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = Space16)
                    .padding(bottom = Space16).widthIn(max = Space600)
            ) {
                Button(
                    onClick = onSignUpClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Create account",
                        modifier = Modifier.padding(vertical = Space8)
                    )
                }
                TextButton(
                    onClick = onSignInClick,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
                ) {
                    Text(text = "Log in")
                }
            }
        }
    }
}
