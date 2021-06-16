/*
 * 2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
 */
public class Room {
    private int quantity;
    private boolean wc;
    private boolean eat;
    private boolean wifi;
    private boolean isFree;
    private int roomNumber;

    public Room(int quantity, boolean wc, boolean eat, boolean wifi, int roomNumber) {
        this.quantity = quantity;
        this.wc = wc;
        this.eat = eat;
        this.wifi = wifi;
        this.isFree = true;
        this.roomNumber = roomNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isWc() {
        return wc;
    }

    public void setWc(boolean wc) {
        this.wc = wc;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Количество мест=" + quantity +
                ", сан.узел=" + (wc ? "есть" : "нет") +
                ", питаение=" + (eat ? "есть" : "нет")+
                ", wifi=" + (wifi ? "есть" : "нет") +
                ", забронировано=" + (isFree ? "да" : "нет") +
                ", номер команты=" + roomNumber;
    }
}
