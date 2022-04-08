public class BuferSincronizado implements Bufer
{	
	//Dato compartido por los subprocesos producto y consumidor
	private int  bufer=-1;
	private boolean disponible = false;
	
   public synchronized void establecer(int valor) //setbufer()
    {  	while(disponible) //DISPONIBLE EN FALSE  = BUFER VACIO
    	{
	        try{	
	        	wait();
	        }catch(InterruptedException ex){}
	    }
	    System.err.println(Thread.currentThread().getName()+" Escribe " + valor);
	    bufer = valor;
	    disponible=true;
	    notify();	//NOTIFICA A LOS DEMAS PROCESOS EN ESPERA LIBERACION DE RECURSO	
    }//fin establecer sincronizado
    
    
    public synchronized int obtener()//getBufer
    {	while(!disponible) //DISPONIBLE VERDADERO= BUFER LLENO
    	{   try{
	            wait();
	        }catch(InterruptedException ex) {  	}
    	}
     	System.err.println(Thread.currentThread().getName()+" Leer " + bufer);
	    disponible=false;
	    notify();	//NOTIFICA A LOS DEMAS PROCESOS EN ESPERA LIBERACION DE RECURSO
	    return bufer;
    }//fin obtener sincronizado     
}//fin BuferSincronizado