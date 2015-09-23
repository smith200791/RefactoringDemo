package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String m_Name;
	private List<Rental> m_Rentals = new ArrayList<Rental>();

	public Customer(String name) {
		m_Name = name;
	}

	public String getName() {
		return m_Name;
	}

	public void addRental(Rental arg) {
		m_Rentals.add(arg);
	}

	public List<Rental> getM_Rentals() {
		return m_Rentals;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;

		String result = "Rental record for " + m_Name + "\n";

		for (Rental each : m_Rentals) {
			double thisAmount = 0;

			// Determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
			case Regular:
				thisAmount = calculateAmountForRegular(each, thisAmount);
				break;

			case NewRelease:
				thisAmount = caclculateAmountForNewRealease(each, thisAmount);
				break;

			case Childrens:
				thisAmount = calculateAmountForChildren(each, thisAmount);
				break;
			}

			// Add frequent renter points
			frequentRenterPoints++;

			// Add bonus for a two-day new-release rental
			if ((each.getMovie().getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1)) {
				frequentRenterPoints++;
			}

			// Show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// Add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		return result;
	}

	public double calculateAmountForChildren(Rental each, double thisAmount) {
		thisAmount += 1.5;
		if (each.getDaysRented() > 3) {
			thisAmount = (each.getDaysRented() - 3) * 1.5;
		}
		return thisAmount;
	}

	public double caclculateAmountForNewRealease(Rental each, double thisAmount) {
		thisAmount += each.getDaysRented() * 3;
		return thisAmount;
	}

	public double calculateAmountForRegular(Rental each, double thisAmount) {
		thisAmount += 2;
		if (each.getDaysRented() > 2) {
			thisAmount += (each.getDaysRented() - 2) * 1.5;
		}
		return thisAmount;
	}
}
