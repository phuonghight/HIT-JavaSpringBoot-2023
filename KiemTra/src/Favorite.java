public class Favorite {
    private String id, name;

    @Override
    public String toString() {
        return "favorite: [id=" + id + ", name=" + name + "]";
    }

    public Favorite(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Favorite() {
        // TODO Auto-generated constructor stub
    }

}
