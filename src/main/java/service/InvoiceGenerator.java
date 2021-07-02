/***************************************************************************
 * Purpose : To give a user id the invoice service gets the list of rides 
 * and return invoice
 * 
 * @author Rosy Rupali, Piyush Shaw
 * @Since 01-07-2021
 * @Version 1.0 
 ***************************************************************************/


package service;

import model.Ride;
import model.RideRepository;

public class InvoiceGenerator {
	private static final double MIN_COST_PER_KM = 10.0;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5.0;
	public final RideRepository rideRepository;

	public InvoiceGenerator() {
		this.rideRepository = new RideRepository();
	}

	public double calaculateFare(double distance, int time) {
		double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
		return (totalFare < MINIMUM_FARE) ? MINIMUM_FARE : totalFare;
	}

	public InvoiceSummary calaculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calaculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);

	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calaculateFare(rideRepository.getRides(userId));
	}

}
