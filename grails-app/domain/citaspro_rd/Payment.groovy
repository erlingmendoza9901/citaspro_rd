package citaspro_rd

import java.time.LocalDateTime

class Payment {
    String code_payment
    String client_code
    LocalDateTime fecha_pago
    Integer price_haircut
    static constraints = {
    }
}
