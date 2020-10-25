/*Exemple Primer Mínim
Apartat 1 i apartat 2.1

restaurant s'han de definir 5 operacions

- llistat de productes ordenats per preu (ascendent)
- llistat de productes ordenats per número de vendes (descendent)
- realitzar una comanda per part d'un usuari identificat
- servir una comanda (en orde d'arribada de comandes)
- llistat de comandes d'un usuari que ja hagin sigut realitzades
*/

import java.util.List;

public interface Gestor {

    public void addUser(String idUser, String name);
    //no està definida l'operació per obtenir un usari, només a la classe i ha d'estar també en la interfície
    public User getUser(String idUser);
    //definim l'operació afegir producte
    public void addProduct(String name, String description, double prize);

    //5 operacions demanades ordenades segons l'esquema de dalt
    public List<Product> productsByPrize();
    public List<Product> productsBySales();
    public void addOrder(Order o);
    public Order getOrder();
    public List<Order> ordersByUser(String idUser);



}
