import cumparaturi.CosCumparaturi;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import product.StackOfPoducts;

import static org.junit.Assert.assertEquals;

public class casaMarcatTest {
    @Test
    public void testMain() {

        StackOfPoducts stoc = new StackOfPoducts();
        stoc=stoc.initStackOfPoducts();
        CosCumparaturi cos= new CosCumparaturi();
        cos.initCosCumparaturi();
        double sumaPlata;
        sumaPlata=cos.calculSumaTotalaCosCumparaturiPlusReducereTenPercent();
        Assert.assertEquals("plata s-a efectuat", 45, sumaPlata, 0.000001);
        }
    }
