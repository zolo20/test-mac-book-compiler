public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms(){
        String freeRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) freeRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера свободных комнат "+freeRoomsList);
    }

    public void reserveRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                room.setFree(false);
                info = ("Комната номер "+roomNumber+" успешно забронированна");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                info = "Комната "+roomNumber+" занята";
                break;
            }
        }
        System.out.println(info);
    }

    public Room freeRoom(int roomNumber) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getRoomNumber() == roomNumber) {
                rooms[i].setFree(true);
                return rooms[i];
            }
        }

        return null;
    }

    public Room getPropRoom(int roomNumber) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getRoomNumber() == roomNumber) {
                return rooms[i];
            }
        }

        return null;
    }

    public void getRoomsHasWifi() {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWifi()) {
                System.out.println(rooms[i]);
            }
        }
    }

    public void getRoomsHasWC() {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWc()) {
                System.out.println(rooms[i]);
            }
        }
    }

    public void getRoomsHasEat() {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isEat()) {
                System.out.println(rooms[i]);
            }
        }
    }

    public void getRoomsByQuantity(int quantity) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getQuantity() == quantity) {
                System.out.println(rooms[i]);
            }
        }
    }
}
