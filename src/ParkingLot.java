/**
 * Created by jonathan on 6/9/2016.
 */
/**
*Design a parking lot.
*When a vehicle enters it should be able to check whether a slot is empty and give the number of the slots.
*Sizes of slots can be for bikes, cars and trucks.
*If slots for bikes are full then a bike can use a car sized slot and so on.
*First 10 slots should be for handicapped and car sized.


*/
import java.util.*;
public class ParkingLot {

    private int NUMBER_OF_SLOTS;
    private int NUMBER_OF_HANDICAPPED_SPOTS;
    private Map<SIZE,Integer> SLOT_SIZES_EMPTY;//to hold the number of empty slots of each size
    private int SMALL_SLOTS;
    private int NORMAL_SLOTS;
    private int LARGESLOTS;
    private int emptySlots;
    private int TOTAL_VEHICLES_IN_LOT;

    Slot[] slotList;//list to store

    ParkingLot(int num_of_slots,int small, int normal, int num_of_handicapped_spots)
    {
        SLOT_SIZES_EMPTY=new HashMap<>(3);
        NUMBER_OF_SLOTS=num_of_slots;
        NUMBER_OF_HANDICAPPED_SPOTS=num_of_handicapped_spots;
        emptySlots=NUMBER_OF_SLOTS;
        SMALL_SLOTS=small;
        NORMAL_SLOTS=normal;
        LARGESLOTS=NUMBER_OF_SLOTS-(NUMBER_OF_HANDICAPPED_SPOTS+SMALL_SLOTS+NORMAL_SLOTS);
        slotList=new Slot[NUMBER_OF_SLOTS];

        SLOT_SIZES_EMPTY=new HashMap<>(3);
        SLOT_SIZES_EMPTY.put(SIZE.Small,10);
        SLOT_SIZES_EMPTY.put(SIZE.Normal,10);
        SLOT_SIZES_EMPTY.put(SIZE.Large,10);

        //initialize the ParkingLot. Give the beginning slots as handicapped spots
        //initialize handicapped spots
        for(int i=0;i<=NUMBER_OF_HANDICAPPED_SPOTS-1;i++)
        {
            slotList[i]=new Slot(i+1,SIZE.Normal);
            slotList[i].setHandicapped();
        }

        //initialize small slots
        for (int i=NUMBER_OF_HANDICAPPED_SPOTS-1;i<=SMALL_SLOTS-1;i++)
        {
            slotList[i]=new Slot(i+1, SIZE.Small);
        }

        //initialize the normal slots
        for (int i=SMALL_SLOTS-1;i<=NORMAL_SLOTS;i++)
        {
            slotList[i]=new Slot(i+1, SIZE.Normal);
        }

        //initialize large slots
        for (int i=NORMAL_SLOTS-1;i<=LARGESLOTS-1;i++)
        {
            slotList[i]=new Slot(i+1, SIZE.Large);
        }
    }

    //function to get a suitable empty slot
    public Slot getSlot(SIZE size)
    {
        for(int i=NORMAL_SLOTS-NUMBER_OF_HANDICAPPED_SPOTS;i<NUMBER_OF_SLOTS;i++)
        {
            if(slotList[i].getSize()==size && slotList[i].isFree())
                return slotList[i];
        }
        return null;
    }

    //overloaded function to get a handicapped spot
    public Slot getSlot(String h)
    {
        for (int i=0;i<NUMBER_OF_HANDICAPPED_SPOTS;i++)
        {
            if (slotList[i].isFree())
                return slotList[i];
        }
        return null;
    }

    //function to accept a vehicle and park it return if done properly
    public boolean park(Vehicle vehicle)
    {
        //check if there is still space in the parking lot
        if(emptySlots<=0)
        {
            System.out.println("Sorry no more slots. Parking Full!");
            return false;
        }
        else {

            //check if handicapped and get a slot
            Slot mySlot;
            if (vehicle.isHandicapped())
                mySlot = getSlot("Handicapped");
            else
                mySlot = getSlot(vehicle.getVehicleSize());

            if (mySlot == null) {
                System.out.println("No parking spot available");
                return false;
            } else {
                //got an available spot
                mySlot.occupySlot(vehicle.getVehicle_id());//sets the Slot to occupied and sets the id of vehicle parked in the slot

                vehicle.setParked(mySlot.getSLOT_NUMBER());//Lets the vehicle know it is parked and which slot it is parked in


                this.TOTAL_VEHICLES_IN_LOT++;
                this.emptySlots--;//reduce the number of empty slots

                System.out.println("Vehicle with ID " + vehicle.getVehicle_id() + " is stored in Slot: " + mySlot.getSLOT_NUMBER());
                System.out.println("Total vehicles in the lot: " + TOTAL_VEHICLES_IN_LOT);
                System.out.println("Empty Slots left: " + emptySlots);
                System.out.println();
                return true;
            }
        }
    }

    //function to unpark a vehicle
    public boolean unpark(Vehicle vehicle) {
        //get the Slot number from the vehicle and unpark it
        try {

            int SlotID = vehicle.getSlotId();
            Slot mySlot = slotList[SlotID - 1];//index is 1 less than SlotID

            //free the slot
            mySlot.freeSlot();
            System.out.println("Slot Freed: " + SlotID);

            //unpark the vehicle
            vehicle.setUnParked();

            this.TOTAL_VEHICLES_IN_LOT--;//decrease the number of vehicles in the slot
            this.emptySlots++;//increase the number of empty slots

            System.out.println("Total vehicles in the lot: " + TOTAL_VEHICLES_IN_LOT);
            System.out.println("Empty Slots left: " + emptySlots);
            System.out.println();

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("The vehicle is not parked in this parking lot.");
        }
        return true;
    }



}
