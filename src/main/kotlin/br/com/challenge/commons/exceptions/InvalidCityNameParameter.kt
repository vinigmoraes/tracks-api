package br.com.challenge.commons.exceptions

import br.com.challenge.commons.exceptions.errors.ErrorResponse
import io.ktor.http.HttpStatusCode

class InvalidCityNameParameter(
    val parameter: String?
) : CityPlaylistApiException() {
    override fun response(): ErrorResponse =
        ErrorResponse.create("Invalid value for city name: $parameter", "parameter" to parameter)

    override fun statusCode(): HttpStatusCode = HttpStatusCode.UnprocessableEntity
}