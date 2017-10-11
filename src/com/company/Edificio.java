
public class Edificio
{
	boolean[][] botones_encendidos;
	boolean[] puertas_abiertas;
	int[] estado; // 1 sub, 0 reposo, -1 bajando
	int numero_pisos;
	int numero_ascensores;
	int[] piso_semaforo;
	int[] pasajeros;
	Semaphore[] puertas;
	Semaphore[] entrar_salir;
	Semaphore[][]botones;
	List<int> peticiones;  
	
	
	class Ascensor extends Thread
	{
		int numero_ascensor;
		Ascensor (int numero_ascensor)
		{
			this.numero_ascensor=numero_ascensor;
		}
		public void run()
		{
			while(true)
			{
			if(estado[numero_ascensor])
			}
		}
	}
	class Persona extends Thread
	{
		Persona ()
		{
			
		}
		public void run()
		{
			int destino=3;
			int actual=0;
			int orientacion;
			if(destino-actual<0)
			{
			orientacion=1;
			}
			else
			{
			orientacion=0;
			}
			boolean en_ascensor=false;
			while(actual!=destino)
			{
				while(!en_ascensor)
				{
					try 
					{
						botones[orientacion][actual].acquire();
						if(botones_encendidos[orientacion][actual])
						botones[orientacion][actual].release();
						//for(int x=0; x<10;x++
					} 
					catch (InterruptedException e) 
					{
					}
					
				}
			}
		}
	}
	
	public void ejecutar()
	{
		numero_pisos=10;
		numero_ascensores=10;
		puertas = new Semaphore[numero_ascensores];
		puertas_abiertas=new boolean[numero_ascensores];
		entrar_salir=new Semaphore[numero_ascensores];
		botones =new Semaphore[2][numero_ascensores];
		botones_encendidos=new boolean[2][numero_pisos];
		pasajeros =new int[numero_ascensores];
		estado=new int[numero_ascensores];
		
		
		for(int x=0;x<2;x++)
		{
			for(int y=0;y<10;y++)
			{
				botones[x][y]=new Semaphore(1);
				botones_encendidos[x][y]=false;
			}
		}
		for(int x=0;x<10;x++)
		{
			puertas[x]=new Semaphore(1);
			entrar_salir[x]=new Semaphore(1);
			estado[x]=0;
		}
		
		
		
	}
}
