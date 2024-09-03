/**This Code Update For Bilisim by Enes Karaoglu
 * Thankyou Enes, 
That's one small step for Enes, one giant leap for BilisimERP */

package com.tr.ek.browser;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.embed.swing.JFXPanel;
import javafx.scene.web.WebEngine;
 
public class BlsSwingBrowser extends FxBrowser {
 
    private JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
 
    private final JPanel panel = new JPanel(new BorderLayout());
    private final JLabel lblStatus = new JLabel();
    
    private final JButton btnGo = new JButton("Go");
    private final JTextField txtURL = new JTextField();
    private final JProgressBar progressBar = new JProgressBar();
 
    public BlsSwingBrowser() {
    	super();
    }
    
    
    public Container blsSwingBrowser() {

    	System.out.println("blsSwingBrowser");
    	try {
			
    	jfxPanel = createScene();
        
        ActionListener al = new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                loadURL(txtURL.getText());
            }
        };
 
        btnGo.addActionListener(al);
        txtURL.addActionListener(al);
 
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
 
        JPanel topBar = new JPanel(new BorderLayout(5, 0));
        topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        topBar.add(txtURL, BorderLayout.CENTER);
        topBar.add(btnGo, BorderLayout.EAST);
 
        JPanel statusBar = new JPanel(new BorderLayout(5, 0));
        statusBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        statusBar.add(lblStatus, BorderLayout.CENTER);
        statusBar.add(progressBar, BorderLayout.EAST);
 
        panel.add(topBar, BorderLayout.NORTH);
        panel.add(jfxPanel, BorderLayout.CENTER);
        panel.add(statusBar, BorderLayout.SOUTH);
        
        getContentPane().add(panel);
 
        
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return getContentPane();
    }

	public JPanel blsSwingBrowserJPanel() {
		System.out.println("blsSwingBrowserJPanel");
		try {

	    	jfxPanel = createScene();      	        
	        panel.add(jfxPanel, BorderLayout.CENTER);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}
	
	public void setLink(String link) {
		System.out.println("setLink:"+link);
		try {
			loadURL(link);
			//panel.setPreferredSize(new Dimension(640, 480));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exit() {
		super.exit();
	}
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
 
            public void run() {
            	BlsSwingBrowser browser = new BlsSwingBrowser();
            	browser.blsSwingBrowserJPanel();
            	//browser.initComponents();
                //browser.setVisible(true);
                browser.loadURL("https://calendar.google.com/calendar/embed?height=600&wkst=2&bgcolor=%23ffffff&ctz=Europe%2FIstanbul&title=%20&src=dHIudHVya2lzaCNob2xpZGF5QGdyb3VwLnYuY2FsZW5kYXIuZ29vZ2xlLmNvbQ&color=%230B8043");
                //browser.loadURL("www.bilisim.com.tr");
            }
        });
    }
    
	
}