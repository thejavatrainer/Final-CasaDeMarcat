package plata;

public class PlataCash {
    private Double suma;

    public PlataCash(Double suma) {
        this.suma = suma;
    }
    public boolean platacash()
    {
        try {
            System.out.println(" S-a efectuat platacash: "+suma+" cu cash");
            return true;
        }catch (Exception a){
            return false;
        }
    }
}
