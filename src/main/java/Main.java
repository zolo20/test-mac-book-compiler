import java.util.Scanner;

/*
 *  ***Гостиница***
 *  1) Гостиница
 *  2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
 *
 *   *Задание для лабораторной работы №4*
 *   Освободить комнату
 *   Вывести свойства комнаты
 *   Показать комнаты с WiFi
 *   Показать комнаты с WC
 *   Показать комнаты с Eat
 *   Показать комнаты по кол-ву спальных мест
 *   Отобразить список команд
 * */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room(1, false, false, true, 11),
                new Room(2, true, true, false, 12),
                new Room(1, false, true, true, 13),
                new Room(3, true, false, false, 21),
                new Room(2, false, false, false, 22),
                new Room(1, true, true, true, 23),
                new Room(3, false, true, false, 31),
                new Room(3, true, true, false, 32),
                new Room(1, false, false, true, 33),
        };
        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("Введите команду");
            command = scanner.nextLine();
            if (command.equals("free_room")) {
                System.out.println("Введите номер комнаты");
                Room room = hotel.freeRoom(scanner.nextInt());

                if (room == null) {
                    System.out.println("Такой комнаты не существует");
                }
            } else if (command.equals("reserveRoom")) {
                System.out.print("Введите номер комнаты для бронирования: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.reserveRoom(roomNumber);
            } else if (command.equals("get_prop_room")) {
                System.out.println("Введите номер комнаты");
                Room room = hotel.getPropRoom(scanner.nextInt());

                if (room == null) {
                    System.out.println("Такой комнаты не существует");
                } else {
                    System.out.println(room);
                }
            } else if (command.equals("rooms_has_wifi")) {
                hotel.getRoomsHasWifi();
            } else if (command.equals("rooms_has_wc")) {
                hotel.getRoomsHasWC();
            } else if (command.equals("rooms_has_eat")) {
                hotel.getRoomsHasEat();
            } else if (command.equals("rooms_by_quantity")) {
                System.out.println("Введите количесвто спальных мест");
                hotel.getRoomsByQuantity(scanner.nextInt());
            } else if (command.equals("help")) {
                System.out.println("free_room");
                System.out.println("reserveRoom");
                System.out.println("get_prop_room");
                System.out.println("rooms_has_wifi");
                System.out.println("rooms_has_wc");
                System.out.println("rooms_has_eat");
                System.out.println("rooms_by_quantity");
                System.out.println("exit");
            } else if (command.equals("exit")) {
                break;
            }
        }

    }
}
