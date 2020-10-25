import java.util.*;

public class GestorImpl implements Gestor{

    //declarem contenidor de productes / catàleg productes
    List<Product> products;

    //fem una cua d'ordres
    Queue<Order> orders;

    //Hashmap usuaris
    HashMap<String,User> users;

    //si no inicialitzem tots els components totes funcions serien excepcions!
    //restringim la cua a 15 en el restaurant per tema COVID
    public GestorImpl() {
        this.products = new ArrayList<Product>();
        //this.orders = new LaMevaCua<Order>(15);
        //LinkedList en el JDBC implementa Queue, List, Deque i totes les seves respectives propietats
        this.orders = new LinkedList<>();
        this.users = new HashMap<String, User>();
    }

    @Override
    public void addUser(String idUser, String name) {
        this.users.put(idUser, new User(idUser, name));

        //si NO constructor = excepcions!! --> NullPointerException

    }

    //funció que ens proporciona un usuari
    public User getUser(String idUser){
        //obtenim usuari que està definit amb aquesta clau
        User user = this.users.get(idUser);
        return user;
    }

    //operació afegir producte
    @Override
    public void addProduct(String name, String description, double prize) {
        //s'ha d'inicialitzar estructura de dades
        //this.products.add(new Product(name,description,prize));
    }

    //sempre implementes mètodes de la interfície Gestor
    //interfície = especifiques, clase = codifiques
    @Override
    public List<Product> productsByPrize() {
        //fer un sort() ja que s'ha d'ordenador per ordre de preu (ascendent)

        //comparem per ordenar / ordre per preu
        //Llista és una colecció / ordenem posant un comparador en els productes
        //ho transforem després en una lambda
        Collections.sort(this.products, (o1, o2) -> {

            //s'ha de tenir precaució amb els números decimals que posem
            //si volem fer l'ordre invers hem de multiplicar tot el int *-1 o donar la volta a la resta
            return (int)(o1.getPrize()-o2.getPrize());
        });

        return this.products;
    }

    @Override
    public List<Product> productsBySales() {
        Collections.sort(this.products, new Comparator<Product>() {

            //com de moment numVendes està inicialitzat a 0 no ens llistarà correctament
            @Override
            public int compare(Product o1, Product o2) {
                return (int)(o1.getNumVendes()-o2.getNumVendes());
            }
        });
        return this.products;
    }

    /*Toni fa ordre:
    * - 3 cafès amb llet
    * - 1 donut
    * - 1 xocolatina
    * user: "Toni"
    * */
    @Override
    public void addOrder(Order o) {
        //quan Toni arriba a la cua del bar l'afegim
        this.orders.add(o);
    }

    @Override
    public Order getOrder() {
        /* funció peek: agafa el primer element de la part superior de la pila
        * posteriorment processem la comanda
        * al final utilitzem poll ja que el peek recupera el primer element pero no l'esborra
        * cosa que el poll SÍ elimina el primer element quan el té
        * */
        Order o = this.orders.poll();
        process(o);
        //primer sabem qui és l'usuari?
        //User u = o.getUser();

        //afegir dins d'usuari l'ordre que s'ha completat
        //u.addUser(o);

        return o;
    }

    private void process(Order o) {
        //implementem mètode process
        //anirem actualitzant el número de vendes
        //tinc tots els items
        //afegeixo quantitat
        int q;

        //for(Item i: o.items){
            //q=i.q;
            //product = i.p:


            //product.numVendes(q);
        }

    @Override
    public List<Order> ordersByUser(String idUser) {
        return null;
    }

    public static void main(){
        Gestor g = new GestorImpl();
        g.addUser("45487890A","Héctor");

        //obtenim informació sobre l'usuari afegit fa poc
        User u = g.getUser("45487890A");
        //imprimim en pantalla
        System.out.println(u.getName());


        //afegim producte
        g.addProduct("xocolatina", "aa", 0.8);
        g.addProduct("bocata vegetal", "aa", 5);
        g.addProduct("bocata fuet", "aa", 2.35);

        //obtenir productes ordenats per preu
        List<Product> llista = g.productsBySales();

        for(Product p: llista){
            System.out.println(p);
        }
    }

}
