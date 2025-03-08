import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.SuccessResult
import coil3.request.ErrorResult
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import java.lang.reflect.Modifier

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Image() {
    val context = LocalContext.current
    val imageUrl = "https://i.pinimg.com/236x/68/31/12/68311248ba2f6e0ba94ff6da62eac9f6.jpg"

    LaunchedEffect(imageUrl) {
        val request = ImageRequest.Builder(context)
            .data(imageUrl)
            .build()
val imageLoader = ImageLoader(context)

        val result = imageLoader.execute(request)


        when (result) {
            is SuccessResult -> Log.d("ImageLoading", "Image loaded successfully")
            is ErrorResult -> Log.e("ImageLoading", "Image loading failed: ${result.throwable}")
        }
    }

    Column {
        Text(text = "remo ,")

        GlideImage(
            model = imageUrl,
            contentDescription = null
        )

    }
}
