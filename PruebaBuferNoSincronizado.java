

public class PruebaBuferNoSincronizado
{
 	public static void main (String[] args) 
 	{	
 		
 		//CREAMOS EL OBJETO COMPARTIDO
 		Bufer datoCompartido = new BuferNoSincronizado();
 	
 		
 		//CREAMOS LOS PROCESOS
 		Productor p = new Productor( datoCompartido );
 		Consumidor c = new Consumidor( datoCompartido );
 		
 		//LANZAMOS LOS PROCESOS A S.O. PARA SU EJECUCIÓN O DESPACHO
 		p.start();
 		c.start();	
 		
 	
	}//fin del main
    
}//fin prueba 
	
 	
 		