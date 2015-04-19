package at.bit.dao

import at.bit.model.Customer
import groovy.json.JsonSlurper

import javax.enterprise.inject.Alternative
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Created by pbayer.
 */
@Alternative
class CustomerDaoFsImpl implements CustomerDao {
    private DateTimeFormatter datePattern = DateTimeFormatter.ofPattern('yyyy.MM.dd')

    List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList()
        def data = new JsonSlurper().parse(ClassLoader.getResource('/Customer.json'))
        data.each {
            customers.add new Customer(id: it.id, lastName: it.lastName, name: it.name, birthDay: LocalDate.parse(it.birthDay, datePattern))
        }
        customers
    }

}
