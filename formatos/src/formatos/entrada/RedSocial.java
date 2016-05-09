package formatos.entrada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


import org.json.JSONObject;

public class RedSocial {



	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		HashMap <String, People> peoples = new HashMap<String, People>();	
		FileReader fr = new FileReader("/home/hduser/Descargas/GDBench-master/GDGenerator/dist/people.csv");
		BufferedReader bf = new BufferedReader(fr);
		String sCadena;
		boolean contador= true;
		String part1 = "";
		String part2 = "";
		String part3 = "";
		String part4 = "";
		while ((sCadena = bf.readLine())!=null) {
			if(contador){
				String[] parts = sCadena.split(",");
				part1 = parts[0]; 
				part2 = parts[1];
				part3 = parts[2]; 
				part4 = parts[3];
				contador=false;
			}
			else
			{
				JSONObject jo = new JSONObject();
				String[] parts2 =  sCadena.split(",");
				jo.put(part4, parts2[3]);
				jo.put(part3, parts2[2]);
				jo.put(part2, parts2[1]);
				jo.put("_label","people");
				People people = new People(Integer.parseInt(parts2[0]), jo);
				peoples.put(parts2[0], people);
			}
		}
		bf.close();
		fr.close();
		FileReader fr1 = new FileReader("/home/hduser/Descargas/GDBench-master/GDGenerator/dist/friends.csv");
		bf = new BufferedReader(fr1);
		contador= true;
		while ((sCadena = bf.readLine())!=null) {
			if(contador){
				contador= false;
			}
			else{
				String[] parts = sCadena.split(",");
				People p1 = peoples.get(parts[1]);
				p1.addNeighboord(parts[2],"friend");
				peoples.put(parts[1], p1);
				
				People p2 = peoples.get(parts[2]);
				p2.addNeighboord(parts[1],"friend");
				peoples.put(parts[2], p2);
			}		
		}
		bf.close();
		fr1.close();
		
		
		fr1 = new FileReader("/home/hduser/Descargas/GDBench-master/GDGenerator/dist/likes.csv");
		bf = new BufferedReader(fr1);
		contador= true;
		while ((sCadena = bf.readLine())!=null) {
			if(contador){
				contador= false;
			}
			else{
				String[] parts = sCadena.split(",");
				People p1 = peoples.get(parts[1]);
				p1.addNeighboord(parts[2],"like");
				peoples.put(parts[1], p1);
			}
		}
		bf.close();
		fr1.close();
		
		FileWriter fichero = new FileWriter("/home/hduser/Descargas/GDBench-master/GDGenerator/dist/prueba.csv");
		BufferedWriter bw = new BufferedWriter(fichero);
		for (People people : peoples.values()) {
			bw.write(people.toString());
			bw.newLine();
		}
		
		fr1 = new FileReader("/home/hduser/Descargas/GDBench-master/GDGenerator/dist/webpages.csv");
		bf = new BufferedReader(fr1);
		contador=true;
		while ((sCadena = bf.readLine())!=null) {
			if(contador){
				contador= false;
			}
			else{
				JSONObject jo = new JSONObject();
				String[] parts = sCadena.split(",");
				jo.put("url", parts[1]);
				jo.put("creation", parts[2]);
				jo.put("_label", "webpages");
				bw.write(parts[0] + "\t" + jo.toString());
				bw.newLine();
			}
		}
		bf.close();
		fr1.close();
		bw.close();
		fichero.close();
	}

}
