package juegoCraps;

/**
 * ModelCraps apply craps rules.
 * estado = 1 Natural winner
 * estado = 2 Craps loser
 * estado = 3 Establish Punto
 * estado = 4 Punto winner
 * estado = 5 Punto loser
 * @author Sergio Carmona
 * @version V.1.0.0 date 5/12/2021
 */
public class ModelCraps {
    private Dado dado1, dado2;
    private int tiro, punto, estado, flag;
    private String[] estadoToString;
    private int[] caras;

    /**
     * Class Constructor
     */
    public ModelCraps(){
        dado1 = new Dado();
        dado2 = new Dado();
        caras = new int[2];
        estadoToString = new String[2];
        flag = 0;
    }

    /**
     * Establish the tiro value according to each dice
     */
    public void calcularTiro(){
        caras[0] = dado1.getCara();
        caras[1] = dado2.getCara();
        tiro = caras[0] + caras[1];
    }

    /**
     * Establish game state according to estado atribute value
     * estado = 1 Natural winner
     * estado = 2 Craps loser
     * estado = 3 Establish Punto
     */
    public void determinarJuego(){
        if(flag==0){
            if(tiro==7 || tiro==11){
                estado = 1;
            }else{
                if(tiro==3 || tiro==2 || tiro==12){
                    estado=2;
                }else{
                    estado=3;
                    punto=tiro;
                    flag = 1;
                }
            }
        }else{
            //ronda punto
            rondaPunto();
        }

    }

    /**
     * Establish game state according to estado atribute value
     * estado = 4 Punto winner
     * estado = 5 Punto loser
     */
    private void rondaPunto() {
        if(tiro==punto){
            estado=4;
            flag=0;
        }else{
            if(tiro==7){
                estado=5;
                flag=0;
            }else{
                estado=6;
            }

        }

    }

    public int getTiro() {
        return tiro;
    }

    public int getPunto() {
        return punto;
    }

    /**
     * Establish message game state according to estado atribute value
     * @return Message for the View class
     */
    public String[] getEstadoToString() {
        switch(estado){
            case 1: estadoToString[0]="Tiro de salida = "+tiro;
                    estadoToString[1]="Sacaste Natural, has ganado!!";
                    break;
            case 2: estadoToString[0]="Tiro de salida = "+tiro;
                    estadoToString[1]="Sacaste Craps, has perdido!!";
                    break;
            case 3: estadoToString[0]="Tiro de salida = "+tiro
                                      +"\nPunto = "+punto;
                    estadoToString[1]="Estableciste Punto en "+punto+"" +
                                    ". Debes seguir lanzando!!"+
                                    "\n Pero si sacas 7 antes que "+punto+" perder??s";
                    break;
            case 4: estadoToString[0]="Tiro de salida = "+punto
                                      +"\nPunto = "+punto
                                      +"\nValor del nuevo Tiro = "+tiro;
                    estadoToString[1]="Volviste a sacar "+punto+", has ganado!!";
                    break;
            case 5: estadoToString[0]="Tiro de salida = "+punto
                    +"\nPunto = "+punto
                    +"\nValor del nuevo Tiro = "+tiro;
                    estadoToString[1]="Sacaste 7 antes que "+punto+", has perdido!!";
                    break;
            case 6: estadoToString[0]="Tiro de salida = "+punto
                    +"\nPunto = "+punto
                    +"\nValor del nuevo Tiro = "+tiro;
                estadoToString[1]="Estas en Punto y debes seguir lanzando!!"+
                                  "\npero si sacas 7 antes que "+punto+" perder??s";
                break;
        }
        return estadoToString;
    }

    public int[] getCaras() {
        return caras;
    }
}
