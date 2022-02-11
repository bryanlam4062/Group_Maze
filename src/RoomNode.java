public class RoomNode<T> {

    Boolean room = true;

    /**
     * Initializes the lock room node.
     */
    public RoomNode() {
        room = true;
    }
    /**
     * Get room.
     * @return availability of room
     */
    public Boolean getRoom() {
        return room;
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
        if(room) {
            return "true";
        }
        return "false";
    }
}
