/***************************************************************************
 * Purpose : It is cab service program where person books the ride and pays
 * bills at the end of the month.
 * @author Rosy Rupali, Piyush Shaw
 * @Since 01-07-2021
 * @Version 1.0 
 ***************************************************************************/
package service;

import model.Ride;

public class InvoiceService {
	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;

	/**
	 * It find out the maximum fare of the cab
	 * 
	 * @param distance
	 * @param time
	 * @return maximum fare
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MINUTE;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	/**
	 * The method return the invoice summary
	 * 
	 * @param rides : first argument of the method
	 * @return : invoice summary which contain total number of rides and total fare
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += this.calculateFare(ride.distance, ride.time);
		return new InvoiceSummary(rides.length, totalFare);
	}

}
