package at.bit.controller
import at.bit.dao.CustomerDaoFsImpl
import at.bit.model.Customer
import org.jglue.cdiunit.ActivatedAlternatives
import org.jglue.cdiunit.CdiRunner
import org.junit.Test
import org.junit.runner.RunWith

import javax.inject.Inject

import static org.hamcrest.CoreMatchers.hasItem
import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty
/**
 * Created by pbayer.
 */
@RunWith(CdiRunner)
@ActivatedAlternatives(CustomerDaoFsImpl)
class CustomerControllerWithAlternativeTest  {

    @Inject
    CustomerController customerController;

    @Test
    void controllerHasCustomers() {
        List<Customer> customers = customerController.getCustomers();
        assertThat(customers, hasItem(hasProperty('name', is('Andreas'))));
        assertThat(customers, hasItem(hasProperty('name', is('Thomas'))));
    }

    @Test
    void firstCustomerIsUte(){
        Customer firstCustomer = customerController.fechFirstCustomer();
        assertThat(firstCustomer.getName(),is('Thomas'))
        assertThat(firstCustomer.getLastName(),is('Muster'))
    }

}
