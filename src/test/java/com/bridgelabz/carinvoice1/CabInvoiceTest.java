/***************************************************************************
 * Purpose : Test cases for the cab invoice generator
 * 
 * @author Rosy Rupali, Piyush Shaw
 * @Since 01-07-2021
 * @Version 1.0 
 ***************************************************************************/
package com.bridgelabz.carinvoice1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Ride;

import service.InvoiceGenerator;
import service.InvoiceSummary;

public class CabInvoiceTest {

	static InvoiceGenerator invoiceGenerator;

	@BeforeClass
	public static void createInvoiceGeneratorObj() {
		invoiceGenerator = new InvoiceGenerator();
	}

	/**
	 * method to return fare, distance and time given
	 */
	
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calaculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}
	
	/**
	 * method to return minimum fare, less distance and time is given
	 */

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calaculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	/**
	 * method to return invoice summary of multiple rides
	 */

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.calaculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
     
	/**
	 * method to give user id  return invoice summary
	 */
	
	@Test
	public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
		String userId = "abc.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
	public void givenUserIdAndRides_ShouldReturn_MultipleInvoiceSummary() {
		String userId = "abc.com";
		Ride[] rides = { new Ride(2.0, 5, InvoiceGenerator.RideMode.NORMAL),
				new Ride(0.1, 1, InvoiceGenerator.RideMode.NORMAL) };
		invoiceGenerator.addRides(userId, rides);
		Ride[] rides1 = { new Ride(2.0, 5, InvoiceGenerator.RideMode.PREMIUM),
				new Ride(0.1, 1, InvoiceGenerator.RideMode.PREMIUM) };
		invoiceGenerator.addRides(userId, rides1);
		Ride[] rides2 = { new Ride(2.0, 5, InvoiceGenerator.RideMode.NORMAL),
				new Ride(0.1, 1, InvoiceGenerator.RideMode.PREMIUM) };
		invoiceGenerator.addRides(userId, rides2);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(6, 125);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}
