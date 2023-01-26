package com.example.theatre.core.domain.models

/**
 * Agent participations item - модель для получения постановок, в которых задействован актер
 *
 * @property id - идентификатор
 * @property title - наименование
 * @property description - описание
 * @property itemUrl - адрес
 * @property ctype - тип элемента
 * @property performancePlace - место [PerformancePlace]
 * @property firstImage - главное изображение
 * @property ageRestriction - ограничение по возрасту
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipationsItem(
    val id: Int?,
    val title: String?,
    val description: String?,
    val itemUrl: String?,
    val ctype: String?,
    val performancePlace: PerformancePlace?,
    val firstImage: Images?,
    val ageRestriction: String?
)
