package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;
    public Reservation(){}
    public Reservation(Integer roomNumber,Date checkin, Date checkout){
         this.roomNumber = roomNumber;
         this.checkin = checkin;
         this.checkout = checkout;
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Integer getRoomNumber(){
        return this.roomNumber;
    }
    public Date getCheckin(){
        return this.checkin;
    }
    public Date getCheckout(){
        return this.checkout;
    }

    public long duration(){
       long time = checkout.getTime() - checkin.getTime();
       return TimeUnit.DAYS.convert(time,TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String toString(){
        return "Room: "+this.getRoomNumber()+ ", Check-in: "+sdf.format(checkin)+", Check-out: "
                +sdf.format(checkout)+", Duration: "+this.duration()+" Days";
    }
}
