package at.bit.controller

import at.bit.model.Customer
import org.jglue.cdiunit.CdiRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import static org.hamcrest.CoreMatchers.is

import static org.hamcrest.CoreMatchers.hasItem
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty

/**
 * Created by pbayer.*/
@RunWith(CdiRunner)
class CustomerControllerTest {

	@Test
	void controllerHasCustomers() {
		List<Customer> customers = controller.getCustomers()
		Assert.assertThat(customers, hasItem(hasProperty('name', is('Ute'))));
		Assert.assertThat(customers, hasItem(hasProperty('name', is('Kurt'))));
	}

	@Test
	void firstCustomerIsUte() {
		Customer firstCustomer = controller.fetchFirstCustomer()
		Assert.assertThat(firstCustomer.getName(), is('Ute'))
		Assert.assertThat(firstCustomer.getLastName(), is('Bock'))
	}

}
