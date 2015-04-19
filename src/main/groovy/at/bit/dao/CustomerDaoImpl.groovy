package at.bit.dao

import at.bit.model.Customer

import java.time.LocalDate

/**
 * Created by pbayer.
 */
class CustomerDaoImpl implements CustomerDao {

    @Override
    List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList()
        //read from DB
        customers.add new Customer(id: 12376, name: 'Kurt', lastName: 'Ostbahn', birthDay: LocalDate.of(1963, 5, 9))
        customers.add new Customer(id: 9709, name: 'Ute', lastName: 'Bock', birthDay: LocalDate.of(1942, 6, 27))
        return customers
    }
}
