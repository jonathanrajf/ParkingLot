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

        Vehicle bike=new Bike(1);
        myLot.park(bike);

        Vehicle car=new Car(2);
        myLot.park(car);

        Vehicle handicapped_vehicle=new HandicappedVehicle(3);
        myLot.park(handicapped_vehicle);

        myLot.unpark(car);


    }
}
