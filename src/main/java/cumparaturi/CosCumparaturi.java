package cumparaturi;

import product.Product;

import java.util.ArrayList;
import java.util.Collection;

public class CosCumparaturi {
    Collection<Product> cosCumparaturi;

    public CosCumparaturi() {
        this.cosCumparaturi = new ArrayList<Product>();
    }

    private void addProducToCosCumparaturi(Product produs) {
        this.cosCumparaturi.add(produs);

    }

    public void initCosCumparaturi() {

        this.cosCumparaturi.add(new Product("cola", 30, 1));
        this.cosCumparaturi.add(new Product("Ciocolata Neagra", 20, 2));
    }

    public int getlenghCosCumparaturi()

    {
        return cosCumparaturi.size();

    }

    public Double calculSumaTotalaCosCumparaturi() {
        Double sumaTotala = 0.0;
        for (Product produs : cosCumparaturi) {
           sumaTotala=sumaTotala+produs.returnPrice();

        }
        return sumaTotala;
    }

    public Double calculSumaTotalaCosCumparaturiPlusReducereTenPercent() {

        return calculSumaTotalaCosCumparaturi()*0.9;
    }
    public Double calculSumaTotalaCosCumparaturiPlusReducereTwentyPercent() {

        return calculSumaTotalaCosCumparaturi()*0.8;
    }

    @Override
    public String toString() {
        String rez = "CosCumparaturi" + "\n";
        int i=0;

        for (Product list : cosCumparaturi) {
            rez = rez + list.toString() + " Slot: " + i + "\n";
            i++;
        }
        return rez;
    }

}
