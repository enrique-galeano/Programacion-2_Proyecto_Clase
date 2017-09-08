
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enriquejosegaleanotalavera
 */
public class AdminstrarPersona {

	private ArrayList<Usuario> listaPerson = new ArrayList();
	private File f = null;

	public AdminstrarPersona(String path){
		f = new File(path);
	}	
	public ArrayList<Usuario> getListaPerson() {
		return listaPerson;
	}

	public void setListaPerson(ArrayList<Usuario> listaPerson) {
		this.listaPerson = listaPerson;
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}

	@Override
	public String toString() {
		return "AdminstrarPersona{" + "listaPerson=" + listaPerson + '}';
	}

	public void EscribirArchivo() throws IOException {
		FileWriter fw =null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(f, false);
			bw = new BufferedWriter(fw);
			
			for (Usuario us : listaPerson) {
				bw.write(us.getNombreCompleto() + ";");
				bw.write(us.getNickname() + ";");
				bw.write(us.getPassword() + ";");
				bw.write(us.getPais() + ";");
				bw.write(us.getFechaDeNacimiento() + ";");
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (Exception e) {
		}
	}
	
	public void cargarArchivo(){
		Date d1 = new Date();
		for (Usuario l : listaPerson) {
			d1 = l.getFechaDeNacimiento();
		}
		if (f.exists()) {
			Scanner sc = null;
			listaPerson = new ArrayList();
			
			try {
				sc = new Scanner(f);
				sc.useDelimiter(";");
				while (sc.hasNext()) {					
					listaPerson.add(new Usuario(sc.next(), sc.next(), sc.next(), sc.next(), d1));
				}
			} catch (Exception e) {
			}
		}
	}

}
