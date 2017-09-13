
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enriquejosegaleanotalavera
 */
public class AdminstrarPersona implements Serializable{

	public final long SerializableUID = 555L;
	
	private ArrayList<Usuario> persona = null;
	private File pathLocation = null;

	public AdminstrarPersona(String path){
		pathLocation = new File(path);
	}

	public ArrayList<Usuario> getP() {
		return persona;
	}

	public void setP(ArrayList<Usuario> p) {
		this.persona = persona;
	}

	public File getPathLocation() {
		return pathLocation;
	}

	public void setPathLocation(File pathLocation) {
		this.pathLocation = pathLocation;
	}

	public ArrayList<Usuario> cargarArchivo() {
		try {
			persona = new ArrayList();
			Usuario temp;
			if (pathLocation.exists()) {
				FileInputStream entrada = new FileInputStream(pathLocation);
				ObjectInputStream objeto = new ObjectInputStream(entrada);
				try {
					while ((temp = (Usuario) objeto.readObject()) != null) {
						persona.add(temp);
					}
				} catch (EOFException e) {
				}
				objeto.close();
				entrada.close();
			}//End if
		} catch (Exception e) {
		}
		return persona;
	}

	public void escribirArchivo() {
		FileOutputStream fw = null;
		ObjectOutputStream bw = null;
		try {
			fw = new FileOutputStream(pathLocation);
			bw = new ObjectOutputStream(fw);
			for (Usuario t : persona) {
				bw.writeObject(t);
			}
			bw.flush();
		} catch (Exception e) {

		} finally {
			try {
				bw.close();
				fw.close();
			} catch (Exception e) {
			}
		}
	}

}
