
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author enriquejosegaleanotalavera
 */
public class Solicitud implements Serializable{
	public final long SerializableUID = 665L;
	private Usuario emisor;
	private Usuario receptor;

	public Solicitud(Usuario emisor, Usuario receptor) {
		this.emisor = emisor;
		this.receptor = receptor;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	@Override
	public String toString() {
		return emisor + " ";
	}
	

}
