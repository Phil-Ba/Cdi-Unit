package at.bit.controller

import at.bit.audit.Audited

/**
 * Created by pbayer.*/

class BankingController {

	private int balance = 100;

	@Audited
	int addToBalance(int amount) {
		balance += amount
	}

	@Audited
	int substractFromBalance(int amount) {
		balance -= amount
	}

}
