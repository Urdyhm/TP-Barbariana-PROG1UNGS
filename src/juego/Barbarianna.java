package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Barbarianna {
	
	private int x, y;
	private int ancho;
	private int alto;
	private int angulo;
	private int direccion;
	Image img1;
	Image img2;
	Image img3;

	public Barbarianna(int x, int y) 
	{
		this.x = x;
		this.y = y;
		this.ancho=100;
		this.alto=100;
		this.angulo=0;
		this.direccion=1;
		img1 = Herramientas.cargarImagen("barb.png");
		img2 = Herramientas.cargarImagen("rayo.png");
		img3 = Herramientas.cargarImagen("agachada.png");
	}
	
	public void moverArriba() {
		this.y -= 8;
		}
		
	public void moverAbajo() {
		this.y += 5;
	}
	
	public void chocaAbajo() {
		this.y-=5;
	}
	public void chocaArriba() {
		this.y += 5;
	}
	
	public void mover() 
	{
		this.x += 3 * direccion;
		
	}
	
	
	public void saltarPiso() {
		this.y-=15;
	}
	

	public int getAncho() 
	{
		return this.ancho;
	}


	public int getAlto() 
	{
		return this.alto;	
	}
	
	
	public int getX() 
	{
		return this.x;
	}


	public int getY() 
	{
		return this.y;	
	}
	
	public void dibujarse(Entorno entorno) 
	{
		entorno.dibujarImagen(img1, this.x, this.y, this.angulo );
		
	}

	public void disparar(Entorno entorno) {
		
		entorno.dibujarImagen(img2,this.x+50, this.y, this.angulo);
		
	}
	
	public void agachada(Entorno entorno) {
		entorno.dibujarImagen(img3,this.x,this.y,this.angulo);
	}
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
}
