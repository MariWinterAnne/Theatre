
import com.example.theatre.core.domain.model.ResultState
import com.example.theatre.core.domain.model.safeCall
import com.example.theatre.features.info.domain.model.theatre.Theatre
import com.example.theatre.features.info.domain.model.theatre.TheatreLocation
import com.example.theatre.features.info.domain.repository.TheatreRepository

/**
 * Get theatre use case
 *
 * @property theatreRepository - репозиторий
 * @author Tamerlan Mamukhov
 */

class GetTheatreUseCase(private val theatreRepository: TheatreRepository) {
    suspend fun getTheatre(): ResultState<List<Theatre>> =
        safeCall { theatreRepository.getTheatre() }

    suspend fun getTheatreById(id: Int): ResultState<Theatre> =
        safeCall { theatreRepository.getTheatreById(id) }

    suspend fun getCityName(slug: String): ResultState<TheatreLocation> =
        safeCall { theatreRepository.getCityName(slug) }
}