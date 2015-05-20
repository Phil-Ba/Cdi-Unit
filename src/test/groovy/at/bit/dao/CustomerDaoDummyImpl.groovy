package at.bit.dao
import at.bit.model.Customer
/**
 * Created by pbayer.
 */
class CustomerDaoDummyImpl implements CustomerDao {

    @Override
    List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList()
        return customers
    }
}
