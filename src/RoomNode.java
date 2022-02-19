public class RoomNode<T> {

    Boolean room;
    String door;

    /**
     * Initializes the lock room node.
     */
    public RoomNode() {
        room = true;
        door = "open";
    }
    public RoomNode(boolean theLock) {
        room = theLock;
        door = "locked";
    }
    public RoomNode(String thePlayer) {
        room = true;
        door = thePlayer;
    }

    /**
     * Get room.
     * @return availability of room
     */
    public Boolean getRoom(){
        return room;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }
    /**
     * set room
     * @param room key
     */
    public void setRoom(Boolean room) {
        this.room = null;
    }

    /**
     * Checks if answer correct, then locks
     * based on answer.
     * @param theAnswer answer in form of integer.
     */
    public void checkLock(int theAnswer){
        room = theAnswer == 1;
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
        else if(room) {
            return "open";
        }
        return "close";
    }
}
