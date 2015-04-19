package at.bit.controller

import at.bit.dao.CustomerDaoImpl
import at.bit.model.Customer
import org.jglue.cdiunit.AdditionalClasses
import org.jglue.cdiunit.CdiRunner
import org.junit.Test
import org.junit.runner.RunWith

import javax.inject.Inject

import static org.hamcrest.CoreMatchers.hasItem
import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty

/**
 * Created by pbayer.*/
@RunWith(CdiRunner)
@AdditionalClasses(CustomerDaoImpl)
//@AdditionalPackages(CustomerDao)
class CustomerControllerTest extends GroovyTestCase {

    @Inject
    CustomerController customerController;

    @Test
    void controllerHasCustomers() {
        List<Customer> customers = customerController.getCustomers();
        assertThat(customers, hasItem(hasProperty('name', is('Ute'))));
        assertThat(customers, hasItem(hasProperty('name', is('Kurt'))));
    }

    @Test
    void firstCustomerIsUte(){
        Customer firstCustomer = customerController.fechFirstCustomer();
        assertThat(firstCustomer.getName(),is('Ute'))
        assertThat(firstCustomer.getLastName(),is('Bock'))
    }
}
