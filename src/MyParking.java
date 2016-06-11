/**
 * Created by jonathan on 6/10/2016.
 */
public class MyParking
{
    static int NO_OF_SLOTS=100;
    static int HANDICAPPED_SLOTS=10;
    static int SMALL_SLOTS=30;
    static int NORMAL_SLOTS=30;


    public static void main(String args[])
    {
        //Create the parking lot
        ParkingLot myLot=new ParkingLot(NO_OF_SLOTS,SMALL_SLOTS,NORMAL_SLOTS,HANDICAPPED_SLOTS);

        Vehicle bike=new Vehicle(1,SIZE.Small);
        myLot.park(bike);

        Vehicle car=new Vehicle(2,SIZE.Normal);
        myLot.park(car);

        Vehicle handicapped_vehicle=new Vehicle(3,"Handicapped");
        myLot.park(handicapped_vehicle);

        myLot.unpark(car);


    }
}
