/***************************************************************************
 * Purpose : It is cab service program where person books the ride and pays
 * bills at the end of the month.
 * @author Rosy Rupali, Piyush Shaw
 * @Since 01-07-2021
 * @Version 1.0 
 ***************************************************************************/
package service;

public class InvoiceService {
	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;

	/**
	 * UC1-This method is to calculate the fare of ride with the given time and
	 * distance
	 * 
	 * @param distance
	 * @param time
	 * @return total fare of cab
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MINUTE;
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;
	}

}
