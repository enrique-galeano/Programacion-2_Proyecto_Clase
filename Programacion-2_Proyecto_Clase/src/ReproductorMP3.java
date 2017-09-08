
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enriquejosegaleanotalavera
 */
public class ReproductorMP3 {

	FileInputStream fs;
	BufferedInputStream bs;

	public Player player;
	public long pauselocation;
	public long songTotalLength;
	public String saveFile;

	public void Pause() {
		if (player != null) {
			try {
				pauselocation = fs.available();
				player.close();
				
			} catch (IOException ex) {
			}
		}
	}

	public void Stop() {
		if (player != null) {
			player.close();
			pauselocation = 0;
			songTotalLength = 0;
		}
	}
	public void Resume() {
		try {
			fs = new FileInputStream(saveFile);
			bs = new BufferedInputStream(fs);
			
			player = new Player(bs);
			
			fs.skip(songTotalLength -  pauselocation);
			
		} catch (FileNotFoundException | JavaLayerException ex) {
			//Logger.getLogger(ReproductorMP3.class.getName()).log(Level.SEVERE, null, ex);

		} catch (IOException ex) {
			//Logger.getLogger(ReproductorMP3.class.getName()).log(Level.SEVERE, null, ex);
		}

		new Thread() {
			@Override
			public void run() {
				try {
					player.play();
				} catch (JavaLayerException ex) {
				}
			}
		}.start();
	}

	public void Play(String path) {
		try {
			
			fs = new FileInputStream(path);
			bs = new BufferedInputStream(fs);
			player = new Player(bs);
			songTotalLength=fs.available();
			saveFile = path + " ";
		} catch (FileNotFoundException | JavaLayerException ex) {
			//Logger.getLogger(ReproductorMP3.class.getName()).log(Level.SEVERE, null, ex);

		} catch (IOException ex) {
	
		}

		new Thread() {
			@Override
			public void run() {
				try {
					player.play();
				} catch (JavaLayerException ex) {
				}
			}
		}.start();
	}
}
