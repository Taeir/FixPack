package nl.taico.fixpack;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Patch {
	static Patch instance;
	Patch(){
		instance = this;
		StyleConstants.setForeground(red, Color.RED);
		StyleConstants.setForeground(green, new Color(0, 166, 0));
		StyleConstants.setForeground(orange, new Color(223, 130, 0));
		//StyleConstants.setBold(bold, true);
		
		this.zipAppender = new ZipAppender();
	}
	
	private SimpleAttributeSet red = new SimpleAttributeSet();
	private SimpleAttributeSet orange = new SimpleAttributeSet();
	private SimpleAttributeSet green = new SimpleAttributeSet();
	//private SimpleAttributeSet bold = new SimpleAttributeSet();
	
	static String loc;

	ZipAppender zipAppender;
	static final String s = File.separator;
	static HashMap<String, String> versions = new HashMap<String, String>();
	
	static {
		versions.put("cc", "2");
		versions.put("ic2", "1");
		versions.put("nei", "8");
		versions.put("wr", "4");
		versions.put("mffs", "4");
		versions.put("weaponsmod", "9");
		versions.put("tubestuff", "0");
		versions.put("railcraft", "2");
		versions.put("redpower", "2");
		versions.put("eepatch", "1_7_2");
	}
	
	void startPatch(String location){
		if (location.endsWith(s)) loc = location;
		else loc = location + s;
		File tempFolder = new File(loc+"temp");
		tempFolder.mkdir();
		File backupFolder = new File(loc+"backup");
		backupFolder.mkdir();
		String patched = "";
		String failed = "";
		String skipped = "";
		log("----------------------------------------------------------------------------------------");
		log("                               Patching ComputerCraft...                                ");
		log("----------------------------------------------------------------------------------------");
		byte outcome = computerCraft();
		if (outcome==0){
			log("");
			log("Patching ComputerCraft Failed!", red);
			failed += "ComputerCraft, ";
		} else if (outcome==1){
			log("");
			log("ComputerCraft Patch successfully applied!", green);
			patched += "ComputerCraft, ";
		} else {
			skipped += "ComputerCraft, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		//log("----------------------------------------------------------------------------------------");
		log("");
		log("----------------------------------------------------------------------------------------");
		log("                            Patching Balkons Weapon Mod...                             ");
		log("----------------------------------------------------------------------------------------");
		outcome = weaponMod();
		if (outcome==0){
			log("");
			log("Patching Balkons Weapon Mod Failed!", red);
			failed += "WeaponMod, ";
		} else if (outcome==1){
			log("");
			log("Balkons Weapon Mod was patched Successfully!", green);
			patched += "WeaponMod, ";
		} else {
			skipped += "WeaponMod, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		
		//log("----------------------------------------------------------------------------------------");
		log("");
		log("----------------------------------------------------------------------------------------");
		log("                          Patching ModularForceFieldSystem...                           ");
		log("----------------------------------------------------------------------------------------");
		outcome = MFFS();
		if (outcome==0){
			log("");
			log("Patching ModularForceFieldSystem Failed!", red);
			failed += "MFFS, ";
		} else if (outcome==1){
			log("");
			log("ModularForceFieldSystem was patched Successfully!", green);
			patched += "MFFS, ";
		} else {
			skipped += "MFFS, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		//log("----------------------------------------------------------------------------------------");
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                              Patching IndustrialCraft2...                              ");
		log("----------------------------------------------------------------------------------------");
		outcome = IC2();
		if (outcome==0){
			log("");
			log("Patching IndustrialCraft2 Failed!", red);
			failed += "IC2, ";
		} else if (outcome==1){
			log("");
			log("IndustrialCraft2 was patched Successfully!", green);
			patched += "IC2, ";
		} else {
			skipped += "IC2, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                               Patching NotEnoughItems...                               ");
		log("----------------------------------------------------------------------------------------");
		outcome = NEI();
		if (outcome==0){
			log("");
			log("Patching NotEnoughItems Failed!", red);
			failed += "NEI, ";
		} else if (outcome==1){
			log("");
			log("NotEnoughItems was patched Successfully!", green);
			patched += "NEI, ";
		} else {
			skipped += "NEI, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                                  Patching RailCraft...                                 ");
		log("----------------------------------------------------------------------------------------");
		outcome = RailCraft();
		if (outcome==0){
			log("");
			log("Patching RailCraft Failed!", red);
			failed += "RailCraft, ";
		} else if (outcome==1){
			log("");
			log("RailCraft was patched Successfully!", green);
			patched += "RailCraft, ";
		} else {
			skipped += "RailCraft, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                                  Patching RedPower...                                  ");
		log("----------------------------------------------------------------------------------------");
		outcome = RedPower();
		if (outcome==0){
			log("");
			log("Patching RedPower Failed!", red);
			failed += "RedPower, ";
		} else if (outcome==1){
			log("");
			log("RedPower was patched Successfully!", green);
			patched += "RedPower, ";
		} else {
			skipped += "RedPower, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                                  Patching TubeStuff...                                 ");
		log("----------------------------------------------------------------------------------------");
		outcome = TubeStuff();
		if (outcome==0){
			log("");
			log("Patching TubeStuff Failed!", red);
			failed += "TubeStuff, ";
		} else if (outcome==1){
			log("");
			log("TubeStuff was patched Successfully!", green);
			patched += "TubeStuff, ";
		} else {
			skipped += "TubeStuff, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                            Patching WirelessRedstone Mod...                            ");
		log("----------------------------------------------------------------------------------------");
		outcome = WR();
		if (outcome==0){
			log("");
			log("Patching WirelessRedstone Failed!", red);
			failed += "WirelessRedstone, ";
		} else if (outcome==1){
			log("");
			log("WirelessRedstone was patched Successfully!", green);
			patched += "WirelessRedstone, ";
		} else {
			skipped += "WirelessRedstone, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                                  Installing EEPatch...                                 ");
		log("----------------------------------------------------------------------------------------");
		outcome = EEPatch();
		if (outcome==0){
			log("");
			log("Installing EEPatch Failed!", red);
			failed += "EEPatch, ";
		} else if (outcome==1){
			log("");
			log("EEPatch was installed Successfully!", green);
			patched += "EEPatch, ";
		} else {
			skipped += "EEPatch, ";
		}
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                             Cleaning Up Temporary Files...                             ");
		log("----------------------------------------------------------------------------------------");
		try {
			delete(tempFolder);
		} catch (IOException e) {
			log("Warning: Cannot delete temp folder. Please delete it yourself!", orange);
		}
		
		if (patched.length() != 0) patched = patched.substring(0, patched.length()-2);
		else patched = "None";
		
		if (failed.length() != 0) failed = failed.substring(0, failed.length()-2);
		else failed = "None";
		
		if (skipped.length() != 0) skipped = skipped.substring(0, skipped.length()-2);
		else skipped = "None";
		
		//log("----------------------------------------------------------------------------------------");
		log("");
		
		log("----------------------------------------------------------------------------------------");
		log("                                        Results                                         ");
		log("----------------------------------------------------------------------------------------");
		log("Patching complete!");
		log("");
		log("Patched mods: " + patched, green);
		log("Skipped mods: " + skipped, orange);
		log("Failed mods: " + failed, red);
		log("----------------------------------------------------------------------------------------");
		
	}
	
	byte weaponMod(){
		File patched = new File(loc+"BalkonsWeaponMod1.2.5_patched"+versions.get("weaponsmod"));
		if (patched.exists()){
			log("Balkons Weapon Mod was already patched. Skipping Balkons Weapon Mod Patch...", orange);
			return 2;
		}
		
		File wmFile = new File(loc+"temp"+s+"WeaponsMod_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/WeaponsMod.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/WeaponsMod.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"BalkonsWeaponMod1.2.5.jar", loc+"temp"+s+"WeaponsMod_Patch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch BalkonsWeaponMod1.2.5.jar");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	byte MFFS(){
		File patched = new File(loc+"mffs_rev7_for_1.2.5-bukkit_patched"+versions.get("mffs"));
		if (patched.exists()){
			log("The ModularForceFieldSystem mod was already patched. Skipping ModularForceFieldSystem Patch...", orange);
			return 2;
		}
		File wmFile = new File(loc+"temp"+s+"MFFS_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/MFFS.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/MFFS.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"mffs_rev7_for_1.2.5-bukkit.zip", loc+"temp"+s+"MFFS_Patch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch mffs_rev7_for_1.2.5-bukkit.zip");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	byte IC2(){
		File patched = new File(loc+"industrialcraft2-1.97-mcpc1.2.5-r7_patched"+versions.get("ic2"));
		if (patched.exists()){
			log("IndustrialCraft2 was already patched. Skipping IndustrialCraft2 Patch...", orange);
			return 2;
		}
		File wmFile = new File(loc+"temp"+s+"IC2_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/IC2.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/IC2.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"industrialcraft2-1.97-mcpc1.2.5-r7.zip", loc+"temp"+s+"IC2_Patch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch industrialcraft2-1.97-mcpc1.2.5-r7.zip");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	byte NEI(){
		File patched = new File(loc+"NotEnoughItems-Bukkit 1.2.2.3r3_patched"+versions.get("nei"));
		if (patched.exists()){
			log("NotEnoughItems was already patched. Skipping NotEnoughItems Patch...", orange);
			return 2;
		}
		File wmFile = new File(loc+"temp"+s+"NEI_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/NEI.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/NEI.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"NotEnoughItems-Bukkit 1.2.2.3r3.zip", loc+"temp"+s+"NEI_Patch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch NotEnoughItems-Bukkit 1.2.2.3r3.zip");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	byte TubeStuff(){
		File patched = new File(loc+"tubestuff_49.1.2_for_1.2.5-bukkit_patched"+versions.get("tubestuff"));
		if (patched.exists()){
			log("TubeStuff was already patched. Skipping TubeStuff Patch...", orange);
			return 2;
		}
		File wmFile = new File(loc+"temp"+s+"TubeStuff_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/TubeStuff.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/TubeStuff.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"tubestuff_49.1.2_for_1.2.5-bukkit.jar", loc+"temp"+s+"TubeStuff_Patch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch tubestuff_49.1.2_for_1.2.5-bukkit.jar");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	byte WR(){
		File patched = new File(loc+"WR-CBE Core-Bukkit 1.2.2.3r2.zip_patched"+versions.get("wr"));
		if (patched.exists()){
			log("WirelessRedstone was already patched. Skipping WirelessRedstone Patch...", orange);
			return 2;
		}
		File wmFile = new File(loc+"temp"+s+"WR_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/WR.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/WR.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"WR-CBE Core-Bukkit 1.2.2.3r2.zip.zip", loc+"temp"+s+"WR_Patch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch WR-CBE Core-Bukkit 1.2.2.3r2.zip.zip");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}

	byte computerCraft(){
		File patched = new File(loc+"ComputerCraft"+s+"lua"+s+"rom"+s+"patched"+versions.get("cc")+s);
		if (patched.exists()){
			log("ComputerCraft was already patched. Skipping ComputerCraft Patch...", orange);
			return 2;
		}
		
		BufferedReader input = null;
		File file = new File(loc+"ComputerCraft"+s+"lua"+s+"rom"+s+"startup"+s);
		if (!file.exists()){
			logr("Error: ComputerCraft file cannot be found! (" + file.getAbsolutePath() + ")");
			return 0;
		}
		
		try {
			input = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e2) {
			logr("Error: ComputerCraft file cannot be found! (" + file.getAbsolutePath() + ")");
			return 0;
		}
		
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			while ((line = input.readLine()) != null){
				lines.add(line);
			}
			input.close();
		} catch (IOException e) {
			logr("Error: Cannot read ComputerCraft file! (" + file.getAbsolutePath() + ")");
			try {
				input.close();
			} catch (IOException e1) {}
			return 0;
		}
		boolean rebootPatch = true, rsCrashPatch = true;
		int crashUpgrade = -1, cu2;
		for (String curline : lines){
			if (curline == null) continue;
			if (curline.contains("os.reboot = nil") || curline.contains("os.reboot=nil")) rebootPatch = false;
			else if (curline.contains("bypassAntiRedstoneCrashBug = rs.setOutput") || curline.contains("rs.setOutput = function(side, bool)")) rsCrashPatch = false;
			
			if (!rebootPatch && !rsCrashPatch) break;
		}
		cu2 = lines.lastIndexOf("bypassAntiRedstoneCrashBug = rs.setOutput");
		crashUpgrade = lines.lastIndexOf("    bypassAntiRedstoneCrashBug(side, bool)");
		
		if (!rebootPatch && !rsCrashPatch && crashUpgrade == -1){
			log("ComputerCraft file already contains patches. Skipping ComputerCraft Patch...", orange);
			try {
				patched.createNewFile();
			} catch (IOException e) {
				logr("Error: Unable to write patched file!");
				return 1;
			}
			return 2;
		}

		
		if (rebootPatch){
			log("Adding reboot patch...");
			lines.add(0, "os.reboot = nil");
			log("Reboot patch added.");
		} else {
			log("Reboot patch already found, skipping reboot patch...");
		}
		
		
		if (rsCrashPatch) {
			String s = (new RandomString(10)).nextString();
			log("Adding redstone crash patch...");
			lines.add(s+"bypassAntiRedstoneCrashBug = rs.setOutput");
			lines.add("rs.setOutput = function(side, bool)");
			lines.add("    sleep(0.05)");
			lines.add("    "+s+"bypassAntiRedstoneCrashBug(side, bool)");
			lines.add("end");
			log("Redstone crash patch added.");
		} else {
			log("Redstone crash patch already found, skipping redstone crash patch...");
		}
		
		if (crashUpgrade != -1 && cu2 != -1){
			log("Upgrading redstone crash patch...");
			String s = (new RandomString(10)).nextString();
			lines.set(cu2, s+lines.get(cu2));
			lines.set(crashUpgrade, "    "+s+lines.get(crashUpgrade).replace("    ",""));
			log("Redstone crash patch upgraded.");
		}
		
		
		
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
			for (String line2 : lines){
				output.append(line2);
				output.newLine();
			}
			output.close();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	byte RailCraft(){
		File patched = new File(loc+"Railcraft-5.3.3-MCPC-1.2.5-r8_patched"+versions.get("railcraft"));
		if (patched.exists()){
			log("RailCraft was already patched. Skipping RailCraft Patch...", orange);
			return 2;
		}
		File wmFile = new File(loc+"temp"+s+"Railcraft_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/Railcraft.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/Railcraft.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"Railcraft-5.3.3-MCPC-1.2.5-r8.zip", loc+"temp"+s+"Railcraft_Patch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch Railcraft-5.3.3-MCPC-1.2.5-r8.zip");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	byte RedPower(){
		File patched = new File(loc+"redpower-all-2.0p5b2-mcpc1.2.5-r15_patched"+versions.get("redpower"));
		if (patched.exists()){
			log("RedPower was already patched. Skipping RedPower Patch...", orange);
			return 2;
		}
		File wmFile = new File(loc+"temp"+s+"RedPower_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/redpower.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/redpower.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"redpower-all-2.0p5b2-mcpc1.2.5-r15.zip", loc+"temp"+s+"RedPower_Patch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch redpower-all-2.0p5b2-mcpc1.2.5-r15.zip");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	byte EEPatch(){
		File patched = new File(loc+"eepatch"+versions.get("eepatch"));
		if (patched.exists()){
			log("EEPatch was already installed. Skipping EEPatch...", orange);
			return 2;
		}
		File wmFile = new File(loc+"temp"+s+"EEPatch_Patch.zip");
		if (wmFile.exists()) wmFile.delete();

		InputStream jarURL = Patch.class.getResourceAsStream("/Patches/EEPatch.zip");
		try {
			copyFile(jarURL, wmFile);
		} catch (Exception ex) {
			logr(ex);
		}
		
		try {
			jarURL.close();
		} catch (IOException e) {
			logr("Error: Cannot close file /Patches/EEPatch.zip!");
			return 0;
		}
		
		try {
			zipAppender.patchZip(loc+"EE2ServerV1.4.6.5-bukkit-mcpc-1.2.5-r5.zip", loc+"temp"+s+"EEPatch.zip");
		} catch (Exception e) {
			logr("Error: Cannot Patch EE2ServerV1.4.6.5-bukkit-mcpc-1.2.5-r5.zip");
			return 0;
		}
		
		try {
			patched.createNewFile();
		} catch (IOException e) {
			logr("Error: Unable to write patched file!");
			return 1;
		}
		
		return 1;
	}
	
	void log(String string){
		StyledDocument doc = Frame.instance.console.getStyledDocument();
		try
    	{
    		doc.insertString(doc.getLength(), string + "\n", null);
    	}
    	catch(Exception e) { System.out.println(e); }
	}
	void log(String string, SimpleAttributeSet color){
		StyledDocument doc = Frame.instance.console.getStyledDocument();
		try
    	{
    		doc.insertString(doc.getLength(), string + "\n", color);
    	}
    	catch(Exception e) { System.out.println(e); }
	}
	void logr(Exception ex){
		for (StackTraceElement current : ex.getStackTrace()){
			log(current.toString(), red);
		}
	}
	void logr(String string){
		log(string, red);
	}

	@SuppressWarnings("null")
	void copyFile(InputStream in, File out) throws Exception {
		InputStream fis = in;
		FileOutputStream fos = new FileOutputStream(out);
		try {
			byte[] buf = new byte[1024];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	void delete(File file) throws IOException{
		if(file.isDirectory()){
			//directory is empty, then delete it
			if(file.list().length==0){
				file.delete();
				log("Deleting directory: " + file.getAbsolutePath());
			} else {
				//list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					//construct the file structure
					File fileDelete = new File(file, temp);
					//recursive delete
					delete(fileDelete);
				}

				//check the directory again, if empty then delete it
				if(file.list().length==0){
					file.delete();
					log("Deleting directory: " + file.getAbsolutePath());
				}
			}
		} else {
			//if file, then delete it
			file.delete();
			log("Deleting file: " + file.getAbsolutePath());
		}
	}

}

