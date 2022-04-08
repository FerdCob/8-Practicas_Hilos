
public class BuferNoSincronizado implements Bufer
{	//DECLARAMOS EL VALOR A COMPARTIR
	int dato = -1;
	
	public void establecer(int valor)
	{	System.err.println( Thread.currentThread().getName() + " Escribe " + valor );
		dato= valor;
	}	

	public int obtener()
	{	System.err.println(Thread.currentThread().getName() + " Lee " + dato);
		return dato;
	}
}