import java.util.LinkedList;
import java.util.List;

//més endavant serà recomenable crear un Hash pels usuaris en comptes de fer una llista (taules de dispersió)
/*informació JDBC
Hashmap es una implementació de la interfície Map<K,V>/<Clau/Valor>
operacions principals:
- put(afegir un valor a una determinada clau)
- get(dona'm valor associat a la clau que t'acabo d'indicar)
l'ordre d'aquesta taula el determina la funció de Hash / inconvenient a l'hora de fer un ordre
* */
public class User {

    //no és eficient utilitzar estructura de vectors, ja que hi ha usuaris que no aniran pràcticament mai al bar
    //i altres que tenen milers de comandes per tant farem nodes o llista encadenada
    //historic de comandes
    List <Order> orderList;
    private final String nif;
    private final String name;

    public User(String nif, String name) {
        this.nif = nif;
        this.name = name;
        this.orderList=new LinkedList<Order>();
    }

    //afegir ordre / respectant contracte de llista
    public void addOrder(Order o){
        this.orderList.add(o);

    }

    //faltarien getters i setters


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    //getNif per donar en la consola la informació de l'usuari
    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }
}
