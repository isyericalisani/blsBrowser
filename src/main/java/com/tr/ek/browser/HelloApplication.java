package com.tr.ek.browser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import javafx.concurrent.Worker.State;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        System.out.println("Demo for firebugLite");

        WebView myWebView = new WebView();
        myWebView.minHeight(1050);
        myWebView.prefWidth(1950);
        myWebView.prefHeight(1070);
        myWebView.minWidth(1050);
        final WebEngine myWebEngine = myWebView.getEngine();
        myWebEngine.getLoadWorker().stateProperty()
                .addListener((obs, oldValue, newValue) -> {
                    if (newValue == State.SUCCEEDED) {
                        System.out.println("finished loading");
                        myWebEngine.executeScript("var firebug=document.createElement('script');firebug.setAttribute('src','https://lupatec.eu/getfirebug/firebug-lite-compressed.js');document.body.appendChild(firebug);(function(){if(window.firebug.version){firebug.init();}else{setTimeout(arguments.callee);}})();void(firebug);");
                    }
                });
        myWebEngine.load("http://docs.oracle.com/javafx/2/get_started/animation.htm");
        VBox myBox = new VBox(myWebView);
        Scene myScene = new Scene(myBox, 1050, 600);
        myStage.setScene(myScene);
        myStage.show();
    }
}