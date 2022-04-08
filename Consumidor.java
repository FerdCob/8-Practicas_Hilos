
public class Consumidor extends Thread
{	//DECLARACIÓN DE ATRIBUTOS O MIEMBROS DE CLASE
	private Bufer ubicacionCompartida;

    public Consumidor( Bufer compartido ) 
    {	super("Consumidor");
    	ubicacionCompartida = compartido;
    }
    
    public void run()
    {	int suma=0;
    	//LEEMOS LOS DATOS COMPARTIDOS
    	for(int cuenta=1; cuenta <=4; cuenta++)
    	{	try
    		{	//INACTIVAMOS EL PROCESO DE 0 A 3 SEGUNDOS ALEATORIAMENTE
    			Thread.sleep((int)(Math.random()*3001));
    			suma += ubicacionCompartida.obtener();
    		}catch(InterruptedException problema)
    			{	//se imprime error de la pila de procesos	
    				problema.printStackTrace();
    			}
    	}//fin del for
    	System.err.println( getName() + " Leyó valores. Suma = " + suma);
    	System.err.println(getName() + " Finalizado");
    }//fin del run
}//fin de clase consumidor