import com.example.teleafiakotlin.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("api/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @POST("api/register")
    fun register(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}
