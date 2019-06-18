import cumparaturi.CosCumparaturi;
import plata.PlataCash;
import product.Product;
import product.StackOfPoducts;

public class CasaMarcat {
    public static void main(String[] args) {


        StackOfPoducts stoc = new StackOfPoducts();
        stoc=stoc.initStackOfPoducts();
        System.out.println(stoc);

        CosCumparaturi cos= new CosCumparaturi();
        cos.initCosCumparaturi();
        System.out.println(cos);

        Double sumaPlata = cos.calculSumaTotalaCosCumparaturiPlusReducereTenPercent();
        PlataCash platacash = new PlataCash(sumaPlata);
        if (platacash.platacash())
        {

        }

    }
}
