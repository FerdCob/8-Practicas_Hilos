
//se define la clase productor como un proceso
public class Productor extends Thread
{	//DECLARACIÓN DE ATRIBUTOS O MIEMBROS DE CLASE
	private Bufer ubicacionCompartida;
	
	//EN EL CONSTRUCTOR SE RECIBE EL OBJETO COMPARTIDO MEDIANTE UN PARAMETRO
    public Productor( Bufer compartido ) 
    {	super("Productor");
    	ubicacionCompartida = compartido;
    }
    
    public void run()
    {	for(int numero=1; numero<=4; numero++)
    	{	//SE INACTIVA EL PROCESO DE 0 A 3 SEGUNDOS
    		try
    		{	Thread.sleep( (int)(Math.random()*3001 ) );
    			//asignamos el valor al bufercompartido
    			ubicacionCompartida.establecer( numero );
    		}catch(InterruptedException problema)
    		{	problema.printStackTrace(); //imprime el rastreo de pila
    		}
    	}//fin del for
    	System.err.println( getName() + " Termino de producir. Finalizado" );
    }//fin del run
}//fin de la clase