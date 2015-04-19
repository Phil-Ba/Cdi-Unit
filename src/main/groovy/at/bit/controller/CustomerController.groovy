/**
 * Created by pbayer.*/
package at.bit.controller

import at.bit.dao.CustomerDao
import at.bit.model.Customer
import at.bit.model.NoCustomersFoundException

import javax.annotation.PostConstruct
import javax.inject.Inject

class CustomerController {

    @Inject
    private CustomerDao customerDao

    List<Customer> customers

    @PostConstruct
    private void init() {
        customers = customerDao.readCustomers()
    }

    /**
     *
     * @return the customer with the lowest id
     * @throws NoCustomersFoundException if there are no customers
     */
    Customer fechFirstCustomer() throws NoCustomersFoundException {
        if (!customers) {
            throw new NoCustomersFoundException()
        }
        customers.min({ it.id })
    }

}
