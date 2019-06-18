package product;

import cumparaturi.CosCumparaturi;

import java.util.ArrayList;
import java.util.Collection;

public class StackOfPoducts {
    Collection<Product> stackOfPoducts;

    public StackOfPoducts() {
        this.stackOfPoducts = new ArrayList<Product>();
    }

    public void initialfillProduct(Product produs) {
        this.stackOfPoducts.add(produs);

    }

    public StackOfPoducts initStackOfPoducts() {
        StackOfPoducts casademarcatinit = new StackOfPoducts();
        casademarcatinit.initialfillProduct(new Product("Cola",30,10));
        casademarcatinit.initialfillProduct(new Product("Apa Plata",20,10));
        casademarcatinit.initialfillProduct(new Product("Ciocolata Neagra",20,10));
        casademarcatinit.initialfillProduct(new Product("Apa Plata",20,10));
        casademarcatinit.initialfillProduct(new Product("Apa Minerala",20,10));
        return casademarcatinit;
    }
    public void removeFromStackOfProducts(CosCumparaturi cos)
    {
        for (Product list : stackOfPoducts) {
            for (int i=0;i<cos.   i++;)

        }

    }

    @Override
    public String toString() {
        String rez = "StackOfPoducts" + "\n";
        int i=0;

        for (Product list : stackOfPoducts) {
            rez = rez + list.toString() + " Slot: " + i + "\n";
            i++;
        }
        return rez;
    }

}


