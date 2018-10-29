package tcench.restapi.vo

import java.math.BigDecimal
import java.time.LocalDateTime

data class DemoVO(
        val id: Int,
        val localDateTime: LocalDateTime,
        val amount: BigDecimal
)