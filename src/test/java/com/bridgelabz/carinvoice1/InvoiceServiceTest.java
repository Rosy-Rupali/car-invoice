/***************************************************************************
 * Purpose : Test cases for the cab invoice generator
 * @author Rosy Rupali, Piyush Shaw
 * @Since 01-07-2021
 * @Version 1.0 
 ***************************************************************************/
package com.bridgelabz.carinvoice1;

import org.junit.Assert;
import org.junit.Test;

import model.Ride;
import service.InvoiceService;

public class InvoiceServiceTest {
	/**
	 * method to return fare, distance and time given
	 */
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceService invoiceService = new InvoiceService();
		double distance = 2.0;
		int time = 5;
		double totalFare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, totalFare, 0.0);
	}

	/**
	 * method to return minimum fare, less distance and time is given
	 */
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		InvoiceService invoiceService = new InvoiceService();
		double distance = 0.1;
		int time = 1;
		double totalFare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, totalFare, 0.0);
	}
	
	/**
	 * method to return total fare of cab
	 */
	@Test
	public void givenMultipleRides_ShoulReturnTotalFare() {
		InvoiceService invoiceService = new InvoiceService();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.5, 5), new Ride(0.1, 1), };
		double totalFare = invoiceService.calculateFare(rides);
		Assert.assertEquals(40, totalFare, 0.0);
	}

}
