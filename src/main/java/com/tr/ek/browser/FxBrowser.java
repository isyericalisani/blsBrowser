/**This Code Update For Bilisim by Enes Karaoglu
 * Thankyou Enes, 
That's one small step for Enes, one giant leap for BilisimERP */


package com.tr.ek.browser;

import static javafx.concurrent.Worker.State.FAILED;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
 
public class FxBrowser extends JFrame {
 
    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
 
    private final JPanel panel = new JPanel(new BorderLayout());
    private final JLabel lblStatus = new JLabel();
 
    private final JButton btnGo = new JButton("Go");
    private final JTextField txtURL = new JTextField();
    private final JProgressBar progressBar = new JProgressBar();
 
    public FxBrowser() {
    	super();
    }
 
    
    private void initComponents() {
    	
    	System.out.println("initComponents");
        createScene();
 
        ActionListener al = new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	System.out.println("getText:"+txtURL.getText());
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
 
        setPreferredSize(new Dimension(1024, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
 
    public JFXPanel createScene() {
 
        Platform.runLater(new Runnable() {
            
            public void run() {
 
                WebView view = new WebView();
                engine = view.getEngine();
                
              /*  CookieManager cookieManager =  new CookieManager();
                cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
                CookieHandler.setDefault(cookieManager);
*/
                view.getEngine().setOnAlert(new EventHandler<WebEvent<String>>() {
                    @Override 
                    public void handle(WebEvent<String> event) {
                        System.out.println(event.getData());
                    }
                });  
                 
                engine.titleProperty().addListener(new ChangeListener<String>() {
                    
                    public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            
                            public void run() {
                            	FxBrowser.this.setTitle(newValue);
                            }
                        });
                    }
                });
 
                engine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
                    
                    public void handle(final WebEvent<String> event) {
                        SwingUtilities.invokeLater(new Runnable() {
                            
                            public void run() {
                                lblStatus.setText(event.getData());
                            }
                        });
                    }
                });
 
                engine.locationProperty().addListener(new ChangeListener<String>() {
                    
                    public void changed(ObservableValue<? extends String> ov, String oldValue, final String newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            
                            public void run() {
                                txtURL.setText(newValue);
                            }
                        });
                    }
                });
 
                engine.getLoadWorker().workDoneProperty().addListener(new ChangeListener<Number>() {
                    
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            
                            public void run() {
                                progressBar.setValue(newValue.intValue());
                            }
                        });
                    }
                });
 
                engine.getLoadWorker()
                        .exceptionProperty()
                        .addListener(new ChangeListener<Throwable>() {
 
                            
                            public void changed(ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) {
                                if (engine.getLoadWorker().getState() == FAILED) {
                                    SwingUtilities.invokeLater(new Runnable() {
                                        
                                        public void run() {
                                            JOptionPane.showMessageDialog(
                                            panel,
                                            (value != null)
                                            ? engine.getLocation() + "\n" + value.getMessage()
                                            : engine.getLocation() + "\nUnexpected error.",
                                            "Loading error...",
                                            JOptionPane.ERROR_MESSAGE);
                                        }
                                    });
                                }
                            }
                        });
 
                Scene nScene = new Scene(view);
                jfxPanel.setScene(nScene);
            }
        });
        
        return jfxPanel;
    }
 
    public void loadURL(final String url) {
    	Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            
            public void run() {
                String tmp = toURL(url);
 
                if (tmp == null) {
                    tmp = toURL("http://" + url);
                }
                System.out.println("loadURL tmp:"+tmp);
                engine.load(tmp);
            }
        });
    }
 
    private static String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
            return null;
        }
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
 
            public void run() {
            	try {
					
	
            	FxBrowser browser = new FxBrowser();
            	browser.initComponents();
                browser.setVisible(true);
                browser.loadURL("http://10.9.9.9:5501/#login");
                //browser.loadURL("www.bilisim.com.tr");
                
    			} catch (Exception e) {
    				e.printStackTrace();
					// TODO: handle exception
				}
            }
        });
    }
        
    protected void exit() {
    	Platform.exit();

	}
}