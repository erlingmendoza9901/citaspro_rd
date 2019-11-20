package citaspro_rd

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Details_reservationController {

    Details_reservationService details_reservationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond details_reservationService.list(params), model:[details_reservationCount: details_reservationService.count()]
    }

    def show(Long id) {
        respond details_reservationService.get(id)
    }

    def create() {
        respond new Details_reservation(params)
    }

    def save(Details_reservation details_reservation) {
        if (details_reservation == null) {
            notFound()
            return
        }

        try {
            details_reservationService.save(details_reservation)
        } catch (ValidationException e) {
            respond details_reservation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'details_reservation.label', default: 'Details_reservation'), details_reservation.id])
                redirect details_reservation
            }
            '*' { respond details_reservation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond details_reservationService.get(id)
    }

    def update(Details_reservation details_reservation) {
        if (details_reservation == null) {
            notFound()
            return
        }

        try {
            details_reservationService.save(details_reservation)
        } catch (ValidationException e) {
            respond details_reservation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'details_reservation.label', default: 'Details_reservation'), details_reservation.id])
                redirect details_reservation
            }
            '*'{ respond details_reservation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        details_reservationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'details_reservation.label', default: 'Details_reservation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'details_reservation.label', default: 'Details_reservation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
