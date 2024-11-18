package app.app.samplekmp.app.home.data.datasource.remote

import app.app.samplekmp.core.network.handleRestException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import app.app.samplekmp.core.result.Result
import io.ktor.client.request.url

internal interface IDiscoverTracksRemoteDataSource {
    suspend fun fetchDiscoverTracks(): Result<DiscoverTracksApiResponse>
}

internal class DiscoverTracksRemoteDataSource(private val httpClient: HttpClient) : IDiscoverTracksRemoteDataSource {

    override suspend fun fetchDiscoverTracks() = try {
        val result: DiscoverTracksApiResponse = httpClient.get {
            url(urlString = "http://apk.ctn.smapps.mx:9582/contenedor/feedCM/mx/feedCM_mx.json")
        }.body()
        Result.Success(result)
    } catch (exception: Exception) {
        Result.Error(handleRestException(exception))
    }
}
