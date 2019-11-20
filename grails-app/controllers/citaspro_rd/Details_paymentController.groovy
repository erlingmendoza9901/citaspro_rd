package citaspro_rd

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Details_paymentController {

    Details_paymentService details_paymentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond details_paymentService.list(params), model:[details_paymentCount: details_paymentService.count()]
    }

    def show(Long id) {
        respond details_paymentService.get(id)
    }

    def create() {
        respond new Details_payment(params)
    }

    def save(Details_payment details_payment) {
        if (details_payment == null) {
            notFound()
            return
        }

        try {
            details_paymentService.save(details_payment)
        } catch (ValidationException e) {
            respond details_payment.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'details_payment.label', default: 'Details_payment'), details_payment.id])
                redirect details_payment
            }
            '*' { respond details_payment, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond details_paymentService.get(id)
    }

    def update(Details_payment details_payment) {
        if (details_payment == null) {
            notFound()
            return
        }

        try {
            details_paymentService.save(details_payment)
        } catch (ValidationException e) {
            respond details_payment.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'details_payment.label', default: 'Details_payment'), details_payment.id])
                redirect details_payment
            }
            '*'{ respond details_payment, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        details_paymentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'details_payment.label', default: 'Details_payment'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'details_payment.label', default: 'Details_payment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
