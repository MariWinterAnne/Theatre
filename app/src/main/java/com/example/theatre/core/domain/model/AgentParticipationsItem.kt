package com.example.theatre.core.domain.model

/**
 * Agent participations item - модель для получения постановок, в которых задействован актер
 *
 * @property id - идентификатор
 * @property title - наименование
 * @property description - описание
 * @property item_url - адрес
 * @property ctype - тип элемента
 * @property performance_place - место [PerformancePlace]
 * @property first_image - главное изображение
 * @property age_restriction - ограничение по возрасту
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipationsItem(
    val id: Int?,
    val title: String?,
    val description: String?,
    val item_url: String?,
    val ctype: String?,
    val performance_place: PerformancePlace?,
    val first_image: Images?,
    val age_restriction: String?
)
