package at.bit.controller
import at.bit.model.Customer
import org.jglue.cdiunit.CdiRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.hasItem
import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty
/**
 * Created by pbayer.*/
@RunWith(CdiRunner)
class CustomerControllerWithAlternativeTest {


	@Test
	void controllerHasCustomers() {
		List<Customer> customers = controller.getCustomers()
		assertThat(customers, hasItem(hasProperty('name', is('Andreas'))));
		assertThat(customers, hasItem(hasProperty('name', is('Thomas'))));
	}

	@Test
	void firstCustomerIsUte() {
		Customer firstCustomer = controller.fetchFirstCustomer()
		assertThat(firstCustomer.getName(), is('Thomas'))
		assertThat(firstCustomer.getLastName(), is('Muster'))
	}

}
