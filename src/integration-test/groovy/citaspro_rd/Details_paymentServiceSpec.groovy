package citaspro_rd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Details_paymentServiceSpec extends Specification {

    Details_paymentService details_paymentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Details_payment(...).save(flush: true, failOnError: true)
        //new Details_payment(...).save(flush: true, failOnError: true)
        //Details_payment details_payment = new Details_payment(...).save(flush: true, failOnError: true)
        //new Details_payment(...).save(flush: true, failOnError: true)
        //new Details_payment(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //details_payment.id
    }

    void "test get"() {
        setupData()

        expect:
        details_paymentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Details_payment> details_paymentList = details_paymentService.list(max: 2, offset: 2)

        then:
        details_paymentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        details_paymentService.count() == 5
    }

    void "test delete"() {
        Long details_paymentId = setupData()

        expect:
        details_paymentService.count() == 5

        when:
        details_paymentService.delete(details_paymentId)
        sessionFactory.currentSession.flush()

        then:
        details_paymentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Details_payment details_payment = new Details_payment()
        details_paymentService.save(details_payment)

        then:
        details_payment.id != null
    }
}
