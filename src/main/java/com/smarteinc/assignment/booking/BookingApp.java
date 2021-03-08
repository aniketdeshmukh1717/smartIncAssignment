package com.smarteinc.assignment.booking;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BookingApp {



	public int bookingProcess(Ticket x) {

		final Map<Integer, ITicketApply> ticketApply = new HashMap<>();
		ticketApply.put(TicketType.BUS.getI(), new ITicketApply() {

			@Override
			public void bookTicket(Ticket x) {
				// TODO Auto-generated method stub
				bookBusTicket(x);
			}});

		ticketApply.put(TicketType.CAR.getI(), new ITicketApply() {

			@Override
			public void bookTicket(Ticket x) {
				// TODO Auto-generated method stub
				bookCarTicket(x);
			}});

		if(ticketApply.get(x.getType())==null) {
			throw new IllegalArgumentException("Only type 1 and 2 tickets are supported");
		}else {
			validateAllFieldsPresent(x);
			ticketApply.get(x.getType()).bookTicket(x);
			sendTicketBookedMail(x);
		}

		//method should return the type of ticket booked
		return x.getType();
	}

	private void bookCarTicket(Ticket x) {
		//assume Car is booked by making some entries in db
	}

	private void bookBusTicket(Ticket x) {
		//assume Bus is booked by making some entries in db
	}


	private void sendTicketBookedMail(Ticket x) {
		//Assume email is sent to passenger that his/her ticket is booked
	}

	//Ensure all input data is present
	void validateAllFieldsPresent(Ticket ticket) {
		Objects.requireNonNull(ticket);
		Objects.requireNonNull(ticket.getStartDate());
		Objects.requireNonNull(ticket.getEndDate());

		Objects.requireNonNull(ticket.getFrom());
		Objects.requireNonNull(ticket.getDestination());
		Objects.requireNonNull(ticket.getPassenger());

	}
}


