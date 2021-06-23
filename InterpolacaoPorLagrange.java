import java.util.*;
//import jfreechart.src.main.java.org.jfree.*;
// Data de criação:22/06/2021
// Autores: Gabriel Barbosa da Silva e Gabriel de Lara Ribeiro

public class InterpolacaoPorLagrange{

    //***************************** Calculo do Ponto Interpolado ****************************************** */
    public static void Px(int numVars, float[] x, float[] y, float pontoXnovo){
        
        float phi = 0L;
        for(int i=0; i<numVars; i++){
            phi += ( y[i]*Lk(i, numVars, x, pontoXnovo) );
        }

        System.out.printf("F( %.9f ) = %.9f %n %n", pontoXnovo, phi);
    }
    //****************************************************************************************************** */

    //***************************** Calculo dos Lk na função interpoladora ********************************* */
    public static float Lk(int count, int numVars, float[] x, float pontoXnovo){
        //****************** */
        float l = 1L;
        for(int k=0; k<numVars; k++){
            if(k!=count){
                l *=( (pontoXnovo-x[k])/(x[count]-x[k]) );
            }
        }
        return l;
    }
    //****************************************************************************************************** */

    //***************************************** MOSTRAR VALORES DE X *************************************** */
    public static void MostrarX(float[] x, int numVars){
        System.out.print("[");
        for(int m=0; m<numVars; m++){
            System.out.print(" " + x[m] + " ");
        }
        System.out.print("]");
    }
    //****************************************************************************************************** */

    //***************************************** MOSTRAR VALORES DE Y *************************************** */
    public static void MostrarY(float[] y, int numVars){
        System.out.print("[");
        for(int m=0; m<numVars; m++){
            System.out.print(" " + y[m] + " ");
        }
        System.out.print("]");
    }
    //****************************************************************************************************** */

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //Entrada do número de variáveis
        int numVars = entrada.nextInt();
        float x[] = new float[numVars];
        float y[] = new float[numVars];

        //Entradas de x
        System.out.print("Digite os valores de x: \n");
        for(int i=0; i<numVars; i++){
            x[i] = entrada.nextFloat();
        }
        //Entradas de y
        System.out.print("Digite os valores de y: \n");
        for(int i=0; i<numVars; i++){
            y[i] = entrada.nextFloat();
        }

        //**************************** Show Infos ******************************************* */
        /*

        System.out.print("************************************************************************\n");
        System.out.print("Numero de valores: " + numVars + "\n");
        System.out.print("Valores em x: ");
        MostrarX(x, numVars);
        System.out.print("\nValores em y: ");
        MostrarY(y, numVars);
        System.out.print("************************************************************************\n");

        */
        //*********************************************************************************** */
        
        System.out.println("Digite um ponto em X para encontrar o Y pela funcao Interpolada: ");
        float pontoXnovo = 0L;
        pontoXnovo = entrada.nextFloat();
        System.out.print("\nPonto em X dado: " + pontoXnovo + "\n");
        Px(numVars, x, y, pontoXnovo);

        while(pontoXnovo != 0){
            System.out.println("Digite um ponto em X para encontrar o Y pela funcao Interpolada: ");
            pontoXnovo = 0L;
            pontoXnovo = entrada.nextFloat();
            if(pontoXnovo == 0){break;}
            System.out.print("\nPonto em X dado: " + pontoXnovo + "\n");
            Px(numVars, x, y, pontoXnovo);
        }

        entrada.close();
    }
}
