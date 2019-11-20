package citaspro_rd

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HaircutController {

    HaircutService haircutService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond haircutService.list(params), model:[haircutCount: haircutService.count()]
    }

    def show(Long id) {
        respond haircutService.get(id)
    }

    def create() {
        respond new Haircut(params)
    }

    def save(Haircut haircut) {
        if (haircut == null) {
            notFound()
            return
        }

        try {
            haircutService.save(haircut)
        } catch (ValidationException e) {
            respond haircut.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'haircut.label', default: 'Haircut'), haircut.id])
                redirect haircut
            }
            '*' { respond haircut, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond haircutService.get(id)
    }

    def update(Haircut haircut) {
        if (haircut == null) {
            notFound()
            return
        }

        try {
            haircutService.save(haircut)
        } catch (ValidationException e) {
            respond haircut.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'haircut.label', default: 'Haircut'), haircut.id])
                redirect haircut
            }
            '*'{ respond haircut, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        haircutService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'haircut.label', default: 'Haircut'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'haircut.label', default: 'Haircut'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
