import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    // 1 em khong hieu tai sao khong co static lai error
    // 2 chỗ <> trước và <> sau new mình có thể để giống nhau hay khác nhau được
    // không ạ?
    // 3 với lại mình truyền 1 số mặc định ví dụ như 10: ... = new
    // ArrayList<Honey>(10)
    // tuy nhiên không làm gì nữa nhưng size của nó vẫn là 0;
    static ArrayList<Honey> honeysList = new ArrayList<Honey>(10);

    public static void addHoney(ArrayList<Honey> honeysList) {
        System.out.println("Enter infomation of a new honey");
        String name, gender, phone, id;
        int age, status;
        System.out.println("Enter name: ");
        sc.nextLine();
        name = sc.nextLine();
        System.out.println("Enter age: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter gender: ");
        gender = sc.nextLine();
        System.out.println("Enter phone: ");
        phone = sc.nextLine();
        System.out.println("Enter honey id: ");
        id = sc.nextLine();
        System.out.println("Enter honey status(0: sulking, 1: in love): ");
        status = sc.nextInt();
        Honey x = new Honey(id, status, name, gender, phone, age);
        honeysList.add(x);
        System.out.println("Succesfully adding a new honey");
    }

    public static void showAllHoneys(ArrayList<Honey> honeysList) {
        if (honeysList.size() < 1) {
            System.out.println("You have not any Honey:(\nPlease find a Honey for yourself :v");
            return;
        }

        System.out.println("=====Honeys Lits=====");
        // em hay su dung method co san va callback
        honeysList.forEach((honey) -> {
            int pos = honeysList.indexOf(honey);
            System.out.println(pos + 1 + ". " + honey.toString());
            honey.favoritesOutput();
        });
    }

    public static void deleteHoneyById(ArrayList<Honey> honeysList) {
        if (honeysList.size() < 1) {
            System.out.println("You have not any Honey:(\nPlease find a Honey for yourself :v");
            return;
        }

        boolean check = false;
        System.out.println("Enter honey id to delete: ");
        sc.nextLine();
        String id = sc.nextLine();

        for(Honey honey : honeysList) {
            if(honey.getId().equals(id)) {
                honeysList.remove(honey);
                System.out.println("Successfully deleting Honey");
                check = true;
                return;
            }
        }

        if (!check) System.out.println("Honeys List have not any Honey which has that id");

        /*
         * honeysList.removeIf(honey -> { System.out.println("Enter id to delete: ");
         * sc.nextLine(); String id = sc.nextLine(); return honey.getId() == id; });
         */
    }

    private static void addFavoritesByHoneyId(ArrayList<Honey> honeysList) {
        if (honeysList.size() < 1) {
            System.out.println("You have not any Honey:(\nPlease find a Honey for yourself :v");
            return;
        }

        boolean check = false;
        System.out.println("Enter honey id to add Favorites: ");
        sc.nextLine();
        String id = sc.nextLine();

        for(Honey honey : honeysList) {
            if(honey.getId().equals(id)) {
                honey.favoritesInput();
                System.out.println("Successfully adding Favorites for Honey which has that id");
                check = true;
                return;
            }
        }

        if (!check) System.out.println("Honeys List have not any Honey which has that id");
    }

    private static void sortHoneyByName(ArrayList<Honey> honeysList) {
        if (honeysList.size() < 1) {
            System.out.println("You have not any Honey:(\nPlease find a Honey for yourself :v");
            return;
        }

        Collections.sort(honeysList, new PersonNameComparator());
    }

    private static void editHoneyById(ArrayList<Honey> honeysList) {
        if (honeysList.size() < 1) {
            System.out.println("You have not any Honey:(\nPlease find a Honey for yourself :v");
            return;
        }

        boolean check = false;
        System.out.println("Enter honey id to add Favorites: ");
        sc.nextLine();
        String id = sc.nextLine();

        for(Honey honey : honeysList) {
            if(honey.getId().equals(id)) {
                editHoney(honey);
                System.out.println("Successfully editing information of Honey which has that id");
                check = true;
                return;
            }
        }

        if (!check) System.out.println("Honeys List have not any Honey which has that id");
    }

    private static void editHoney(Honey honey) {
        System.out.println("Enter the attribute want to edit(name, age, phone, status): ");
        String attribute = sc.next();

        switch (attribute) {
            case "name": {
                System.out.println("Enter the new name: ");
                honey.setName(sc.next());
                break;
            }
            case "age": {
                System.out.println("Enter the new age: ");
                honey.setAge(sc.nextInt());
                break;
            }
            case "phone": {
                System.out.println("Enter the new phone: ");
                honey.setPhone(sc.next());
                break;
            }
            case "status": {
                System.out.println("Enter the new status: ");
                honey.setStatus(sc.nextInt());
                break;
            }
            default: {
                System.out.println("Invalid attribute");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("===============Menu===============");
            System.out.println("1. Add Honey");
            System.out.println("2. Show all Honeys");
            System.out.println("3. Delete Honey by id");
            System.out.println("4. Edit Honey by id");
            System.out.println("5. Add Favorite by honey id");
            System.out.println("6. Sort Honey by name");
            System.out.println("7. Exit");
            System.out.println("==================================");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    addHoney(honeysList);
                    break;
                }
                case 2: {
                    showAllHoneys(honeysList);
                    break;
                }
                case 3: {
                    deleteHoneyById(honeysList);
                    break;
                }
                case 4: {
                    editHoneyById(honeysList);
                    break;
                }
                case 5: {
                    addFavoritesByHoneyId(honeysList);
                    break;
                }
                case 6: {
                    sortHoneyByName(honeysList);
                    break;
                }
                case 7: {
                    System.out.println("================Thankiu================");
                    break;
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 7);
    }
}