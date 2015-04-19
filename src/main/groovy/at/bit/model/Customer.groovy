package at.bit.model

import groovy.transform.ToString

import java.time.LocalDate

/**
 * Created by pbayer.
 */
@ToString
class Customer {
    int id
    String name
    String lastName
    LocalDate birthDay
}
