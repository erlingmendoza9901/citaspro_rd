package citaspro_rd

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BarberController {

    BarberService barberService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond barberService.list(params), model:[barberCount: barberService.count()]
    }

    def show(Long id) {
        respond barberService.get(id)
    }

    def create() {
        respond new Barber(params)
    }

    def save(Barber barber) {
        if (barber == null) {
            notFound()
            return
        }

        try {
            barberService.save(barber)
        } catch (ValidationException e) {
            respond barber.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'barber.label', default: 'Barber'), barber.id])
                redirect barber
            }
            '*' { respond barber, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond barberService.get(id)
    }

    def update(Barber barber) {
        if (barber == null) {
            notFound()
            return
        }

        try {
            barberService.save(barber)
        } catch (ValidationException e) {
            respond barber.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'barber.label', default: 'Barber'), barber.id])
                redirect barber
            }
            '*'{ respond barber, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        barberService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'barber.label', default: 'Barber'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'barber.label', default: 'Barber'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
