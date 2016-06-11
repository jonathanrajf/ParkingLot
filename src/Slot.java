import java.util.Enumeration;

/**
 * Created by jonathan on 6/9/2016.
 */
public class Slot {

    private int SLOT_NUMBER;
    private SIZE size;
    private boolean occupied;
    private boolean handicapped;
    private int vehicle_id;//id of vehicle in the slot

    //Constructor
    Slot(int slotNumber,SIZE size)
    {
        this.size=size;
        this.occupied=false;
        handicapped=false;
        SLOT_NUMBER=slotNumber;
        vehicle_id=0;
    }

    public SIZE getSize()
    {
        return this.size;
    }

    public boolean isFree()
    {
        return (!occupied);
    }

    public void occupySlot(int vehicle_id)
    {
        this.occupied=true;
        this.vehicle_id=vehicle_id;
    }

    public void freeSlot()
    {
        this.occupied=false;
        this.vehicle_id=0;
    }

    public void setHandicapped()
    {
        handicapped=true;
    }

    public boolean isHandicapped()
    {
        return handicapped;
    }

    public int getVehicle_id() {return vehicle_id;};

    public int getSLOT_NUMBER(){return SLOT_NUMBER;}

}
