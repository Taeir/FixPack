package nl.taico.fixpack;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class Frame extends javax.swing.JFrame {
	public static final String version = "0.6";
	public static Frame instance;
	/**
	 * Creates new form FixPack
	 */
	public Frame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */                     
	private void initComponents() {
		dlgFileChoose = new JFileChooser();
		frameAbout = new JFrame();
        lblAboutText = new JLabel();
        btnAboutAgree = new JButton();
        btnAboutDisagree = new JButton();
        lblAbout = new JLabel();
        btnAboutCC = new javax.swing.JButton();
        btnAboutNEI = new javax.swing.JButton();
        btnAboutTS = new javax.swing.JButton();
        btnAboutWM = new javax.swing.JButton();
        btnAboutIC2 = new javax.swing.JButton();
        btnAboutMFFS = new javax.swing.JButton();
        btnAboutWR = new javax.swing.JButton();
        lblAboutWebsites = new javax.swing.JLabel();
		panelMain = new JPanel();
		directory = new JTextField();
		btnSelectDir = new JButton();
		lblSelectedDir = new JLabel();
		lblMain = new JLabel();
		panelConsole = new JPanel();
		lblConsole = new JLabel();
		scrollPaneConsole = new JScrollPane();
		console = new JTextPane();
		btnPatch = new JButton();
		btnAbout = new JButton();
		btnExit = new JButton();

		lblAbout.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblAbout.setText("About/Legal stuff");
		
        lblAboutText.setText("<html>\nTaeir's FixPack for Tekkit was made by Taeir<br><br>\n<b>All credit for the mods goes to the original developers.</b><br><br>\nThis Pack contains modifications and/or patches for the following Tekkit Classic mods:<br>\n- Dan200's ComputerCraft<br>\n- Chickenbones NotEnoughItems<br>\n- Immibis' TubeStuff<br>\n- Balkon's WeaponMod<br>\n- Alblaka's IndustrialCraft2<br>\n- ModularForcefieldSystems<br>\n- WirelessRedstone<br>\n<br>\nThis package does NOT contain any of the original mod files, only modified ones made by me (Taeir).<br>\n<br>\nI am not responsible for any loss of data or other computer problems caused by using this program.<br>\nIt is recommended to make a backup of your Tekkit server files before patching.<br>\n<br>\nIf you have any problems, you can PM me on bukkitdev.<br>\nUsername: Taeir<br>\n</html>");

        btnAboutAgree.setText("I agree to the conditions mentioned above");
        btnAboutAgree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAboutAgreeClick(evt);
            }
        });

        this.setResizable(false);
        frameAbout.setResizable(false);
        
        btnAboutCC.setText("ComputerCraft");
        btnAboutCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutCCActionPerformed(evt);
            }
        });

        btnAboutNEI.setText("NotEnoughItems");
        btnAboutNEI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutNEIActionPerformed(evt);
            }
        });

        btnAboutTS.setText("TubeStuff");
        btnAboutTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutTSActionPerformed(evt);
            }
        });

        btnAboutWM.setText("WeaponMod");
        btnAboutWM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutWMActionPerformed(evt);
            }
        });

        btnAboutIC2.setText("IndustrialCraft2");
        btnAboutIC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutIC2ActionPerformed(evt);
            }
        });

        btnAboutMFFS.setText("ModularForcefieldSystems");
        btnAboutMFFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutMFFSActionPerformed(evt);
            }
        });

        btnAboutWR.setText("WirelessRedstone");
        btnAboutWR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutWRActionPerformed(evt);
            }
        });

        lblAboutWebsites.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAboutWebsites.setText("Websites/Forum Pages");
        
        btnAboutDisagree.setText("I disagree to the conditions mentioned above");
        btnAboutDisagree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutDisagreeClick(evt);
            }
        });

        this.setTitle("Taeir's FixPack for Tekkit Classic v"+version);
        this.setLocationByPlatform(true);
        
        frameAbout.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frameAbout.setTitle("About");
        frameAbout.setLocationByPlatform(true);

        javax.swing.GroupLayout frameAboutLayout = new javax.swing.GroupLayout(frameAbout.getContentPane());
        frameAbout.getContentPane().setLayout(frameAboutLayout);
        frameAboutLayout.setHorizontalGroup(
            frameAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameAboutLayout.createSequentialGroup()
                .addGroup(frameAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameAboutLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAboutText, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frameAboutLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblAbout)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(frameAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameAboutLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(frameAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAboutMFFS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAboutCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAboutNEI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAboutTS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAboutWM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAboutIC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAboutWR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblAboutWebsites))
                .addGap(28, 28, 28))
            .addGroup(frameAboutLayout.createSequentialGroup()
                .addComponent(btnAboutAgree, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAboutDisagree, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frameAboutLayout.setVerticalGroup(
            frameAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAbout)
                    .addComponent(lblAboutWebsites))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAboutText, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addGroup(frameAboutLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAboutCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAboutNEI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAboutTS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAboutWM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAboutIC2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAboutMFFS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAboutWR)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAboutAgree)
                    .addComponent(btnAboutDisagree))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMain.setFont(new java.awt.Font("Tahoma", 0, 18));
		lblMain.setText("Taeir's Pack of Fixes for Tekkit Classic");
        
        lblSelectedDir.setText("Selected Folder:");
        
        btnSelectDir.setText("Choose Mods Folder");
		btnSelectDir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSelectDirClick(evt);
			}
		});

		dlgFileChoose.setDialogType(JFileChooser.CUSTOM_DIALOG);
		dlgFileChoose.setApproveButtonText("Select");
		dlgFileChoose.setApproveButtonToolTipText("Select the current folder");
		dlgFileChoose.setCurrentDirectory(new java.io.File("C:\\"));
		dlgFileChoose.setDialogTitle("Select a folder");
		dlgFileChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		lblConsole.setText("Console");

		console.setEditable(false);
		console.setFont(new java.awt.Font("Lucida Console", 0, 11));
		((DefaultCaret) console.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		scrollPaneConsole.setViewportView(console);

		javax.swing.GroupLayout panelConsoleLayout = new javax.swing.GroupLayout(panelConsole);
        panelConsole.setLayout(panelConsoleLayout);
        panelConsoleLayout.setHorizontalGroup(
            panelConsoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsoleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneConsole)
                    .addGroup(panelConsoleLayout.createSequentialGroup()
                        .addComponent(lblConsole)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelConsoleLayout.setVerticalGroup(
            panelConsoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsoleLayout.createSequentialGroup()
                .addComponent(lblConsole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelConsole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(lblSelectedDir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(directory, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectDir)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectedDir)
                    .addComponent(directory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

		btnPatch.setText("Start Patching");
		btnPatch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPatchClick(evt);
			}
		});

		btnAbout.setText("About");
		btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutClick(evt);
            }
        });

		btnExit.setText("Exit");
		btnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExitClick(evt);
			}
		});

		javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblMain, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMain, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPatch)
                    .addComponent(btnAbout)
                    .addComponent(btnExit))
                .addContainerGap(16, Short.MAX_VALUE))
        );

		pack();
	}

	private void btnSelectDirClick(ActionEvent evt) {
		int returnVal = dlgFileChoose.showOpenDialog(this);

		if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
			directory.setText(dlgFileChoose.getSelectedFile().getAbsolutePath());
		}
	}

	private void btnPatchClick(ActionEvent evt) {
		btnPatch.setEnabled(false);
		PatchTask task = new PatchTask();
		task.execute();
	}
	private void btnAboutClick(ActionEvent evt) {
        frameAbout.pack();
        frameAbout.setVisible(true);
    }
	private void btnExitClick(ActionEvent evt) {
		this.dispose();
	}
	
	private boolean first = true;
	private void btnAboutAgreeClick(ActionEvent evt) {
		if (first){
			instance.setVisible(true);
			btnAboutAgree.setText("OK");
			btnAboutDisagree.setEnabled(false);
			btnAboutDisagree.setText("You have already agreed");
			frameAbout.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			first = false;
		}
        frameAbout.dispose();
    }

	private void btnAboutCCActionPerformed(java.awt.event.ActionEvent evt) {                                           
        openLink("http://www.computercraft.info/");
    }                                          

    private void btnAboutNEIActionPerformed(java.awt.event.ActionEvent evt) {                                            
        openLink("http://www.minecraftforum.net/topic/909223-162-smp-chickenbones-mods/");
    }                                           

    private void btnAboutTSActionPerformed(java.awt.event.ActionEvent evt) {                                           
        openLink("http://www.minecraftforum.net/topic/1001131-162-immibiss-mods-smp-now-with-857-less-version-numbers-in-this-title/");
    }                                          

    private void btnAboutWMActionPerformed(java.awt.event.ActionEvent evt) {                                           
        openLink("http://www.minecraftforum.net/topic/211517-162forge-balkons-weaponmod-v113-now-with-flintlock-pistol/");
    }                                          

    private void btnAboutIC2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        openLink("http://www.industrial-craft.net/");
    }                                           

    private void btnAboutMFFSActionPerformed(java.awt.event.ActionEvent evt) {                                             
        openLink("http://universalelectricity.com/mffs/");
    }                                            

    private void btnAboutWRActionPerformed(java.awt.event.ActionEvent evt) {                                           
        openLink("http://www.minecraftforum.net/topic/909223-162-smp-chickenbones-mods/");
    }                                          

    private void btnAboutDisagreeClick(ActionEvent evt){
    	frameAbout.dispose();
    	instance.dispose();
    }
    private void openLink(String link){
        URI uri;
        try {
            uri = new URI(link);
        } catch (URISyntaxException ex) {
            return;
        }
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (IOException ex) {}
        }
    }

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		new Patch();
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				instance = new Frame();
				instance.frameAbout.pack();
				instance.frameAbout.setVisible(true);
			}
		});
	}

	private class PatchTask extends SwingWorker<Void, String> {
		@Override
		protected Void doInBackground() {
			if (directory.getText() == null || directory.getText().equals("")){
				Patch.instance.logr("You haven't selected a folder!");
				btnPatch.setEnabled(true);
				return null;
			}
			Patch.instance.startPatch(directory.getText());
			btnPatch.setEnabled(true);
			return null;
		}

		@Override
		protected void process(List<String> values) {}
	}
	
	private JLabel lblMain;
	private JLabel lblSelectedDir;
	private JTextField directory;
	private JFileChooser dlgFileChoose;
	private JButton btnSelectDir;

	private JPanel panelMain;
	private JPanel panelConsole;
	private JScrollPane scrollPaneConsole;
	private JLabel lblConsole;
	public JTextPane console;
	
	private JButton btnPatch;
	private JButton btnAbout;
	private JButton btnExit;
	
	
	private JFrame frameAbout;
	private JLabel lblAboutText;
    private JLabel lblAbout;
	private JButton btnAboutAgree;
	private JButton btnAboutDisagree;
	private javax.swing.JLabel lblAboutWebsites;
	private javax.swing.JButton btnAboutCC;
    private javax.swing.JButton btnAboutIC2;
    private javax.swing.JButton btnAboutMFFS;
    private javax.swing.JButton btnAboutNEI;
    private javax.swing.JButton btnAboutTS;
    private javax.swing.JButton btnAboutWM;
    private javax.swing.JButton btnAboutWR;
}
