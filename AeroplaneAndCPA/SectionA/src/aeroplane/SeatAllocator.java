package aeroplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SeatAllocator {

	private Map<Seat, Passenger> allocation;

	private static final String CREW = "crew";
	private static final String BUSINESS = "business";
	private static final String ECONOMY = "economy";
	
	public SeatAllocator() {
		allocation = new HashMap<Seat, Passenger>();
	}

	@Override
	public String toString() {
		return allocation.toString();
	}
	
	private void allocateInRange(Passenger passenger,
			Seat first, Seat last) throws AeroplaneFullException {

		if (!passenger.isDummy()) {
			Seat chose = first;
			while (allocation.containsKey(chose)) {
				if (chose.equals(last)) {
					throw new AeroplaneFullException();
				}
				chose = chose.next();
			}
			allocation.put(chose, passenger);
		}

	}

	private static String readStringValue(BufferedReader br) throws MalformedDataException, IOException {

		String result = br.readLine();
		
		if(result == null) {
			throw new MalformedDataException();
		}
		
		return result;
		
	}

	private static int readIntValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Integer.parseInt(readStringValue(br));
		} catch(NumberFormatException e) {
			throw new MalformedDataException();
		}
	}

	private static Luxury readLuxuryValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Luxury.valueOf(readStringValue(br));
		} catch(IllegalArgumentException e) {
			throw new MalformedDataException();
		}
	}

	
	public void allocate(String filename) throws IOException, AeroplaneFullException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line;
		while((line = br.readLine()) != null) {
			try {
				if(line.equals(CREW)) {
					allocateCrew(br);
				} else if(line.equals(BUSINESS)) {
					allocateBusiness(br);
				} else if(line.equals(ECONOMY)) {
					allocateEconomy(br);
				} else {
					throw new MalformedDataException();
				}
			} catch(MalformedDataException e) {
				System.out.println("Skipping malformed line of input");
			}
		}
		
	}
	
	private void allocateCrew(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		Passenger passenger = new CrewMember(firstName, lastName);
		Seat first = new Seat(1,'A');
		allocateInRange(passenger, first, new Seat(1, first.getMaxSeatLetter()));
		//       create a crew member using firstName and lastName
		//       call allocateInRange with appropriate arguments
	}

	private void allocateBusiness(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		Luxury luxury = readLuxuryValue(br);
		Passenger passenger = new BusinessClass(luxury, firstName, lastName, age);
		Seat first = new Seat(2,'A');
		allocateInRange(passenger, first, new Seat(15, first.getMaxSeatLetter()));
		//       create a business class passenger using firstName, lastName, age and luxury
		//       call allocateInRange with appropriate arguments
	}

	private void allocateEconomy(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		Passenger passenger = new EconomyClass(firstName, lastName, age);
		Seat first = new Seat(16,'A');
		allocateInRange(passenger, first, new Seat(first.getNoOfRow(), first.getMaxSeatLetter()));
		//       create an economy class passenger using firstName, lastName and age
		//       call allocateInRange with appropriate arguments
	}

	// TODO: Section A, Task 5 - add upgrade method

}
