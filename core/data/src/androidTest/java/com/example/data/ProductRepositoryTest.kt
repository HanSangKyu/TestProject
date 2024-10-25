import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data_api.repository.ProductRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ProductRepositoryTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var productRepository: ProductRepository

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        hiltRule.inject() // Hilt 의존성 주입

        // MockWebServer 설정
        mockWebServer = MockWebServer()
        mockWebServer.start()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `test get products from repository`() = runBlocking {
        // MockWebServer에 가짜 응답 추가
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody("{ /* JSON 응답 */ }") // 실제 JSON 응답 데이터로 변경
        mockWebServer.enqueue(mockResponse)

        // Repository 메서드 호출 및 검증
        val products = productRepository.getList() // getProducts는 Repository 메서드로 가정
        assert(products.data.isNotEmpty()) // 결과 검증
        // 필요에 따라 추가 검증 로직 추가
    }
}