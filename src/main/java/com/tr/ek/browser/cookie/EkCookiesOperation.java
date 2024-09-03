package com.tr.ek.browser.cookie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpCookie;
import java.net.Proxy.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;

public class EkCookiesOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 private List<HttpCookie> cookies = new ArrayList<>();
	
	  public void RestoreCookieStoreFromFile(){
		    try {
		        File file = new File("ekCookie");
		        if (file.exists()) {
		            System.out.println("RESTORE COOKIES");
		            FileReader fileReader = new FileReader("ekCookie");
		            String json = new String(Files.readAllBytes(Paths.get("ekCookie")));
		            Gson gson = new GsonBuilder().create();
		            java.lang.reflect.Type type = new TypeToken<List<EkCookiesClass>>() {
		            }.getType();
		            cookies = gson.fromJson(json, type);

		        }
		        } catch(FileNotFoundException e){
		            //file not found
		            e.printStackTrace();
		        } catch(IOException e){
		            // cant create object stream
		            e.printStackTrace();
		        }


		}

		private void saveCookieStoreToFile(String location){
		    try {
		        Gson gson = new GsonBuilder().create();
		        String jsonCookie = gson.toJson(cookies);
		        Files.writeString(Path.of("ekCookie"),jsonCookie);

		    } catch (FileNotFoundException e) {
		        // file not found
		        System.out.println("Can't Save File");
		        e.printStackTrace();
		    } catch (IOException e) {
		        System.out.println("Can't Save File OUTSTREAM");
		        // can't create output stream
		        e.printStackTrace();
		    }
		}*/

}
