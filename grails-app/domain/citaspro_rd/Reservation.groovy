package citaspro_rd

import java.sql.Time
import java.time.LocalDateTime

class Reservation {
    String code_reservation
    LocalDateTime fecha_reservation
    Time hora
    String client_code
    static constraints = {
    }
}
