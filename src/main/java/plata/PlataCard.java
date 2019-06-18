package plata;

public class PlataCard {
    private Double suma;

    public PlataCard(Double suma) {
        this.suma = suma;
    }
    public boolean plataCard()
    {
        try {
            System.out.println(" S-a efectuat platacash: "+suma+" de pe card");
            return true;
        }catch (Exception a){
            return false;
        }
    }
}
