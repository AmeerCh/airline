interface BookedTicket {
  ticketId?: number;

  customerId: number;

  flightId: number;

  source: string;

  destination: string;

  dateOfBooking: string;

  takeOffTime: string;

  arivalTime: string;
}
