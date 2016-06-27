/**
 * Created by jonathan on 6/9/2016.
 */

public abstract class Vehicle {

    private int vehicle_id;
    private SIZE vehicle_size;
    private boolean parked;
    private boolean handicapped;
    private int slotID=0;

    Vehicle()
    {

    }
    Vehicle(int id, SIZE size) {
        vehicle_id = id;
        vehicle_size = size;
        parked=false;
        handicapped=false;
    }

    //constructor for handicapped vehicles
    Vehicle(int id, String s)
    {
        vehicle_id=id;
        vehicle_size=SIZE.Normal;
        parked=false;
        handicapped=true;
    }

    public void setParked(int slotID) {
        parked=true;
        this.slotID=slotID;
    }
    public void setUnParked() {
        parked=false;
        this.slotID=0;//reset the slotID
    }

    public boolean isHandicapped(){ return handicapped;}

    public int getSlotId(){ return slotID;  }

    public int getVehicle_id(){return this.vehicle_id;}
    public SIZE getVehicleSize(){return vehicle_size;}

}


