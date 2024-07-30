package in.codetech.restcontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.reponse.Ticket;
import in.codetech.request.Passanger;

@RestController
public class IrctcRestController {
	
	
	private Map<Integer, Ticket> tickets = new HashMap<>();
	
	private int ticketId = 100;
	
	@PostMapping(value="/ticket", consumes = {"application/xml", "application/json"}, produces = {"application/xml", "application/json"})
	public Ticket bookTicket(@RequestBody Passanger passanger) {
		
		
		
		Ticket ticket = new Ticket();
		
//		Random r = new Random();
//		int ticketId = r.nextInt();
		
		ticket.setTicketId(ticketId);
		ticket.setFrom(passanger.getFrom());
		ticket.setTo(passanger.getTo());
		ticket.setTicketStatus("CONFIRMED");
		ticket.setTrainNum(passanger.getTrainNum());
		ticket.setTktCost("1200.00 INR");
		
		tickets.put(ticketId, ticket);
		ticketId++;
		
		return ticket;
		
	}
	
	@GetMapping(value="/ticket/{ticketId}", produces = {"application/xml", "application/json"})
	public Ticket getTicket(@PathVariable Integer ticketId) {
		if(tickets.containsKey(ticketId)) {
			return tickets.get(ticketId);
		}
		
		return null;
		
	}
	
	//getAllTicket
	
	//updateTicket
	
	//deleteTicketById
	
	
	
	

}
