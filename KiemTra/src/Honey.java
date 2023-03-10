import java.util.ArrayList;
import java.util.Scanner;

public class Honey extends Person {
    static Scanner sc = new Scanner(System.in);

    private String id;
    private int status, favLength;
    private ArrayList<Favorite> favList = new ArrayList<Favorite>();

    public int getFavLength() {
        return favLength;
    }

    public void setFavLength(int favLength) {
        this.favLength = favLength;
    }

    public ArrayList<Favorite> getFavList() {
        return favList;
    }

    public void setFavList(ArrayList<Favorite> favList) {
        this.favList = favList;
    }

    @Override
    public String toString() {
        String mess = "Honey [id=" + id + ", status=" + status + ", name=" + name + ", gender=" + gender + ", phone=" + phone
                + ", age=" + age + "]";

        return mess;
    }

    public void favoritesInput() {
        System.out.println("Enter number of favorites: ");
        favLength = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < favLength; i++) {
            String f_id, f_name;
            System.out.println("Enter favorite id: "); f_id = sc.nextLine();
            System.out.println("Enter favorite name: "); f_name = sc.nextLine();

            Favorite fav = new Favorite(f_id, f_name);
            favList.add(fav);
        }
    }

    public void favoritesOutput() {
        if (this.favList.size() < 1 ) {
            System.out.println("She/he has not any Favorite:(\nPlease add some Favorites for her/him :v");
            return;
        }

        System.out.println("\tShe/he has ");
        this.favList.forEach(fav -> {
            int pos = this.favList.indexOf(fav);
            System.out.println("\t\t" + (pos + 1) + ". " + fav.toString());
        });
    }

    public Honey(String id, int status) {
        super();
        this.id = id;
        this.status = status;
    }

    public Honey(String id, int status, String name, String gender, String phone, int age) {
        super(name, gender, phone, age);
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Honey() {
        // TODO Auto-generated constructor stub
    }

}
