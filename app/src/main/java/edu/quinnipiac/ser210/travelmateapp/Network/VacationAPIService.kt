package edu.quinnipiac.ser210.travelmateapp.Network

import edu.quinnipiac.ser210.travelmateapp.Model.VacationAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://vacations-details-your-ultimate-guide.p.rapidapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface VacationApiService {
    @Headers(
        "x-rapidapi-key: 67cc14a362msh51c3f591c9298fep190a08jsne2ee14ec09ca",
        "x-rapidapi-host: vacations-details-your-ultimate-guide.p.rapidapi.com"
    )

    @GET("api/countries")
    suspend fun getAllVacationData(): Map<String, VacationAPI>
}

object VacationApi {
    val retrofitService: VacationApiService by lazy {
        retrofit.create(VacationApiService::class.java)
    }
}
