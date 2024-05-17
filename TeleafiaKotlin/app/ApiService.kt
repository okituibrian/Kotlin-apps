import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

// Import your response model here
import com.example.packageName.YourResponseModel // Replace packageName with the actual package name

interface ApiService {

    @FormUrlEncoded
    @POST("login") // Replace "login" with your actual login endpoint
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<YourResponseModel> // Replace YourResponseModel with your actual response model
}
