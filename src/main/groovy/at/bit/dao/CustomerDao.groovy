package at.bit.dao
import at.bit.model.Customer
/**
 * Created by pbayer.
 */
interface CustomerDao {
    List<Customer> readCustomers()
}
