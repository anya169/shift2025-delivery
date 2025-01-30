import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.delivery.data.PostTypesRepository
import com.example.delivery.ui.theme.DeliveryTheme

class MainActivity : ComponentActivity() {

    val repository = PostTypesRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryTheme {
                MainScreen(repository = repository)
            }
        }
    }
}
