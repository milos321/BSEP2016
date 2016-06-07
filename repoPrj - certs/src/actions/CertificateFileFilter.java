package actions;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class CertificateFileFilter extends FileFilter {
	
	@Override
	public String getDescription() {
		return "X.509 Certificate Files (*.cer)";
	}

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || 
                f.getName().toLowerCase().endsWith(".cer"));
	}

}
