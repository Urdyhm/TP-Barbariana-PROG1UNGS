package juego;


import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Image fondo;
	private Image fondo_win;
	private Image fondo_lose;
	Barbarianna barbarianna;
	Pisos pisos;
	Rayo rayo;
	RayoLaser rayoLaser;
	Velociraptor velociraptor;
	Commodore128kb com128;
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		entorno = new Entorno(this, "Castlevania Barbarianna Viking Edition", 800,600);
		
		// Inicializar lo que haga falta para el juego
		barbarianna = new Barbarianna(20, 550);
		fondo = Herramientas.cargarImagen("Bunker-de-Watten-med.png");
		fondo_win = Herramientas.cargarImagen("win.png");
		fondo_lose = Herramientas.cargarImagen("lose.png");
		pisos = new Pisos(300,400);
		rayo = null;
		rayoLaser = null;
		com128 = new Commodore128kb (400,80);
		velociraptor = null;
		velociraptor = new Velociraptor( 720,575,-1); // 720,575,-1
	
		// ...

		// Inicia el juego!
		entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		
		entorno.dibujarImagen(this.fondo, entorno.ancho()/2, entorno.alto()/2, 0, 1.5);
		pisos.dibujarse(entorno);
		com128.dibujarse(entorno);
		
		if (velociraptor!=null) {
			
			velociraptor.moverLados(entorno);
			if(velociraptor.getDireccion()==-1) {
				velociraptor.izquierda(entorno);}
			
			if(velociraptor.getDireccion()==1) {
					velociraptor.derecha(entorno);
				}
		
			if (pisos.colisionaCon(velociraptor)==false && 
					velociraptor.getY()<entorno.alto()-25) {
				velociraptor.caida();
				}
			
			if ( rayo !=null && rayo.colisionaCon(velociraptor)) {
					rayo = null;
					velociraptor = null;
					}
			while ( rayoLaser == null) {
				rayoLaser = new RayoLaser (velociraptor.getX(), velociraptor.getY()-20, 1);
			}

			if (rayoLaser != null) {
				rayoLaser.disparar(entorno);
				rayoLaser.mover();
				if (velociraptor.getDireccion()==1) {
					rayoLaser.setDireccion(1);}
				if (velociraptor.getDireccion()==-1){
					rayoLaser.setDireccion(-1);							
					}
				if(rayoLaser.getX()>entorno.ancho() + 20 || rayoLaser.getX()<-20 || velociraptor==null) {
					rayoLaser = null;			
				}
			}
			if ( velociraptor.colisionaCon(barbarianna) || rayoLaser.colisionaCon(barbarianna) && rayoLaser != null ) {
					entorno.dibujarImagen(fondo_lose,entorno.ancho()/2, entorno.alto()/2, 0, 1.5);
					entorno.removeAll();
				}
		}

		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && barbarianna.getX() > 30 && pisos.colisionaCon(barbarianna)==false) {
			barbarianna.mover();}
		if (entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
			barbarianna.setDireccion(-1);
		}
		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA) && pisos.colisionaCon(barbarianna)==false 
				&& barbarianna.getX() < entorno.ancho() - 30) {
			barbarianna.mover();}
		if (entorno.sePresiono(entorno.TECLA_DERECHA)) {
			barbarianna.setDireccion(1);
		}
		
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA) && barbarianna.getY() > 50 && pisos.colisionaAbajoCon(barbarianna)==false) {
			barbarianna.moverArriba();}
		
		if (entorno.estaPresionada(entorno.TECLA_ABAJO) && barbarianna.getY()<entorno.alto()-60 ) {
			barbarianna.moverAbajo();}
		
		if (barbarianna.getY()<(entorno.alto()-50) && pisos.colisionaCon(barbarianna)==false) {
			barbarianna.moverAbajo();
			//}else {
			//barbarianna.moverAbajo();
			}
		
		if (pisos.colisionaArribaCon(barbarianna)) {
			barbarianna.chocaAbajo();
		}
		if (pisos.colisionaAbajoCon(barbarianna)) {
			barbarianna.chocaArriba();
		}
		
		if(entorno.estaPresionada(entorno.TECLA_CTRL) && entorno.estaPresionada(entorno.TECLA_ARRIBA)==false 
				&& pisos.colisionaAbajoCon(barbarianna)==false) {
			barbarianna.saltarPiso();
		}
		
		if (entorno.estaPresionada(entorno.TECLA_SHIFT)){
			barbarianna.agachada(entorno);
		}else{
			barbarianna.dibujarse(entorno);
		}
		
		
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)
				&& rayo == null){
			rayo = new Rayo (barbarianna.getX(), barbarianna.getY()); 
			}
		
		if (rayo != null) {
			rayo.disparar(entorno);
			rayo.mover();
			 if (barbarianna.getDireccion()==1) {
					rayo.setDireccion(1);}
			 if (barbarianna.getDireccion()==-1) {
					rayo.setDireccion(-1);	
					}		
			 if( rayo.getX()>entorno.ancho()+10 || rayo.getX()<-10) {
				    rayo = null;			
			}
		}
			
			 
		if (com128.colisionaCon(barbarianna)) {
			entorno.dibujarImagen(fondo_win,entorno.ancho()/2, entorno.alto()/2, 0, 1.5);
			entorno.removeAll();
		}
		
		
}
		
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
