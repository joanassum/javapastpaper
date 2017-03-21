package aeroplane;

import java.util.ArrayList;
import java.util.List;

public class Seat {

    private final int noOfRow = 50;
    private final char maxSeatLetter = 'F';
    private final List<Integer> emergencyRow = new ArrayList<>();

	private int row;
	private char letter;

	public Seat(int row, char letter) {
	    this.row = row;
	    this.letter = letter;
	    emergencyRow.add(1);
        emergencyRow.add(10);
        emergencyRow.add(30);
    }

    public int getRow() {return row;}
    public int getNoOfRow() {return noOfRow;}
    public char getLetter() {return letter;}
    public char getMaxSeatLetter() {return maxSeatLetter;}
    public List<Integer> getEmergencyRow() {return emergencyRow;}

    @Override
    public String toString() {
	    return "" + row + "" + letter + "";
    }

    public boolean isEmergencyExit() {
	    for (int i : emergencyRow) {
	        if (i == row) {
	            return true;
            }
        }
        return false;
    }

    public boolean hasNext() {
	    return row != noOfRow || letter != maxSeatLetter;
    }

    public Seat next() {
	    if  (this.hasNext()) {
	        if (letter == maxSeatLetter) {
	            return new Seat(row+1, 'A');
            } else {
	            return new Seat(row, (char) (letter + 1));
            }
        } else {
	        throw (new java.util.NoSuchElementException());
        }
    }

    @Override
    public boolean equals(Object seat) {
	    if (seat instanceof Seat) {
	        Seat s = (Seat) seat;
	        return s.getLetter() == letter && s.getRow() == row;
	       /* boolean sameEmerRow = s.getEmergencyRow().containsAll(emergencyRow)
                    && emergencyRow.containsAll(s.getEmergencyRow());
	        return s.getLetter() == letter && s.getRow() == row
                    && sameEmerRow && maxSeatLetter == s.getMaxSeatLetter()
                    && noOfRow == s.getNoOfRow();*/
        }
        return false;
    }

    @Override
    public int hashCode() {
	    return row * 10 + (letter - 'A');
    }


}
