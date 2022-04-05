package motel.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(int roomNumber, Date checkIn, Date checkOut) throws DomainException {
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("DATA ERRADA TA SAINDO ANTES DE ENTRAR");
		} 
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("ERRO! AS DATAS DEVEM SER FUTURAS");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("DATA ERRADA TA SAINDO ANTES DE ENTRAR");
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reservation: Room " + this.getRoomNumber() + ", check in: " + sdf.format(checkIn) + ", check out: "
				+ sdf.format(checkOut) + ", " + this.duration() + " nights.";
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

}
