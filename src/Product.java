public class Product {

    //variables classe Producte
    private final String name, description;
    private double prize;
    private int numVendes;

    //constructor inicialitzant les diferents variables
    public Product(String name, String description, double prize) {
        this.name = name;
        this.description = description;
        this.prize = prize;
        this.numVendes = 0;
    }

    //mètode toString perque sigui més amigable pel usuari

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prize=" + prize +
                '}';
    }

    //afegim getters i setters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public int getNumVendes() {
        return numVendes;
    }

    public void setNumVendes(int numVendes) {
        this.numVendes = numVendes;
    }
}
