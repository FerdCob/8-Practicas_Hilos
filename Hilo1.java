package javaapplication15;
 
import java.util.Random;
import javax.swing.JOptionPane;

public class Hilo1 implements Runnable //Nuestra clase es un hilo o proceso
{	//MIEBRO DE CLASE O ATRIBUTOS
	//private final int tiempoInactividad;
        //Thread t = new Thread (new Ejemplo());
        //t.start();
   //public Hilo1( String nombre ) //CONSTRUCTOR
   // {	super(nombre); 	//se asigna n/ombre al proceso
    //	tiempoInactividad = (int)(Math.random()*5001);
    //  tiempoInactividad =(int)6200; //ejemplo
    //}   
    //Sobre-escritura método run()
    
        String Nombre;
        int tiempoInactividad;
        Random generador = new Random();
        //Thread t = new Thread (new Ejemplo());
        //t.start()
    
    public Hilo1(String nom){
    Nombre = nom;
    tiempoInactividad = generador.nextInt(5000);
    }
    
    public void run()
    {	// COMO LA EJECUCIÓN ES CONTROLADA Y DESPACHADA POR 
    	// SISTEMA OPERATIVO, ES POSIBLE QUE HALLA ERROR
    	// POR LO TANTO SE MANEJA EL CAPTURADOR DE EXCEPCIONES 
    	// Y CONTROL DE ERRORES
    	try
    	{	//System.err.println(getName() + " Estara inactivo "+ tiempoInactividad);
    		//Thread.sleep( tiempoInactividad );
    		//System.err.println(getName() + " Despertando y finalizando");
            System.out.println(Nombre+" estara inactivo por "+ tiempoInactividad+" milisegudos");
            Thread.sleep( tiempoInactividad );
        }
    	//EN CASO DE INTERRUPCION DEL PROCESO, SE CAPTURA EL ERROR
    	catch(InterruptedException excepcion)
    	{	
            System.out.println("Proceso finalizado con error"+ Nombre);
            excepcion.printStackTrace();
                //excepcion.printStackTrace(); //Se imprime el error
    		//JOptionPane.showMessageDialog(null,"Se interrumpió el proceso");
    	}
        
    System.out.println(Nombre+"ha despertado, y ahora finalizado");
    }
//FIN DEL RUN 
    //el metodo star lanza al estado listo el procesos es decir 
    //lo manda a la pila de ejecucion 
    public static void main (String[] args) 
    {	
        Thread hilo1 = new Thread(new Hilo1 ("Procesos 1"));
         Thread hilo2 = new Thread(new Hilo1 ("Procesos 2"));
          Thread hilo3 = new Thread(new Hilo1 ("Procesos 3"));
           Thread hilo4 = new Thread(new Hilo1 ("Procesos 4"));
        
        hilo1.setPriority(10);
           
        hilo1.start();
    	hilo2.start();
    	hilo3.start();
    	hilo4.start();
           
	} 
}//Fin de la clase Hilo