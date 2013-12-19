package nl.taico.fixpack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipAppender {
	// 4MB buffer
    private static final byte[] ZIPBUFFER = new byte[4096 * 1024];

    void copyZip(InputStream input, OutputStream output) throws IOException {
        int bytesRead;
        while ((bytesRead = input.read(ZIPBUFFER))!= -1) {
            output.write(ZIPBUFFER, 0, bytesRead);
        }
    }

    void patchZip(String path, String path2) throws Exception {
        // read the zips
    	File originalFile = new File(path);
        if (!originalFile.exists()){
        	Patch.instance.logr("Error: Cannot find original file \"" + path + "\"!");
        	throw new Exception();
        }
        path = Patch.loc+"backup"+Patch.s+originalFile.getName();
        originalFile.renameTo(new File(path));
        
        ZipFile originalZip = new ZipFile(path);
        ZipFile newZip = new ZipFile(path2);
        
        // write the modded zip with new Name
        //String extension = path.substring(path.length()-4, path.length());
        ZipOutputStream moddedZip = new ZipOutputStream(new FileOutputStream(Patch.loc+originalFile.getName()));

        // copy contents from original zip to the modded zip
        Enumeration<? extends ZipEntry> entries = originalZip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry e = entries.nextElement();
            
            String name = e.getName();
            if(newZip.getEntry(name) == null) {//If it is not in the new zip.
            	//Patch.instance.log("Copying file: " + name);
                moddedZip.putNextEntry(new ZipEntry(name));
                if (!e.isDirectory()) {
                    copyZip(originalZip.getInputStream(e), moddedZip);
                }
                moddedZip.closeEntry();
            }
        }

        // replace the original zip-files with new ones

        Enumeration<? extends ZipEntry> newentries = newZip.entries();
        while (newentries.hasMoreElements()) {
            ZipEntry e = newentries.nextElement();
            String name = e.getName();
            Patch.instance.log("Appending file: " + name);
            moddedZip.putNextEntry(new ZipEntry(name));
            if (!e.isDirectory()) {
                copyZip(newZip.getInputStream(e), moddedZip);
            }
            moddedZip.closeEntry();
        }

        // close
        originalZip.close();
        newZip.close();
        moddedZip.close();
        Patch.instance.log("Patching file " + originalFile.getName() + " complete!");
    }

    
}
