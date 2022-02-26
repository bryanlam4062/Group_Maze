/**
 * Room.java
 *
 * class that holds locks and room names.
 *
 * @author Bryan Lam
 * @version Winter 2022
 */
public class Room {

    private Boolean key;
    private String door;

    /**
     * Initializes the lock room.
     */
    public Room() {
        key = true;
        door = "open";
    }

    /**
     * Second Initializes the lock room.
     * locks room.
     * @param theLock boolean
     */
    public Room(boolean theLock) {
        key = theLock;
        door = "locked";
    }

    /**
     * Third Initializes the lock room.
     * player name.
     * @param thePlayer String
     */
    public Room(String thePlayer) {
        key = true;
        door = thePlayer;
    }

    /**
     * Get key.
     * @return availability of room
     */
    public Boolean getKey(){
        return key;
    }

    /**
     * Set key,
     * @param theKey String key
     */
    public void setKey(final boolean theKey) {
        key = theKey;
    }

    /**
     * Get door.
     * @return the door
     */
    public String getDoor() {
        return door;
    }

    /**
     * Set door.
     * @param door the door
     */
    public void setDoor(String door) {
        this.door = door;
    }

    /**
     * Print the boolean into string.
     * @return boolean in string form.
     */
    public String toString() {
        if(door.equalsIgnoreCase("Player")) {
            return "Player";
        }
        else if(door.equalsIgnoreCase("end")) {
            return "end";
        }
        else if(key) {
            return "open";
        }
        return "close";
    }
}
