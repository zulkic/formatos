package formatos.entrada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class Entradas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final File folder = new File("/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/");
		listFilesForFolder(folder);
		//leerArchivo();
		
	}
	
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            //listFilesForFolder(fileEntry);
	        } else {
	            leerArchivo(fileEntry.getName(),folder.getAbsolutePath());
	        }
	    }
	}

	

	public static void leerArchivo(String nombreArchivo, String nombreCarpeta){
	    FileReader fr = null;
	    BufferedReader br = null;
	    FileWriter fw = null;
	    BufferedWriter bw = null;
	    //Cadena de texto donde se guardara el contenido del archivo
	    String contenido = "";
	    try
	    {
	    	if(nombreArchivo.contains("Dist"))
	    	{
	    		
		        fr = new FileReader(nombreCarpeta + "/" + nombreArchivo);
		        br = new BufferedReader( fr );
		        File folder = new File(nombreCarpeta+"/giraph");
		        folder.mkdirs();
		        String nombreCarpetaAux = nombreCarpeta + "/giraph/" + nombreArchivo;
		        fw = new FileWriter( nombreCarpetaAux );
		        bw = new BufferedWriter( fw );
		        
		        
		  
		        String linea;
		        String anterior="";
		        while( ( linea = br.readLine() ) != null )
		        {
		        	String[] parts = linea.split(",");
		        	if(anterior.equals(parts[0]))
		        	{
		        		contenido += "\t" + parts[1] + "\t" + parts[2];
		        	}
		        	else {
		        		if(!anterior.equals("")){
		        			contenido += "\n";
		        			bw.write(contenido);
		        			contenido="";
		        		}
		        		contenido += parts[0] + "\t" + "0" + "\t" + parts[1] + "\t" + parts[2];
		        	}
		        	anterior = parts[0];
		        }
		        //contenido +="]]";
		        bw.write(contenido);
	    	}
	    	if(nombreArchivo.contains("Aminoacid"))
	    	{
		        fr = new FileReader(nombreCarpeta + "/" + nombreArchivo);
		        br = new BufferedReader( fr );
		        File folder = new File(nombreCarpeta+"/giraph");
		        folder.mkdirs();
		        String nombreCarpetaAux = nombreCarpeta + "/giraph/" + nombreArchivo;
		        fw = new FileWriter( nombreCarpetaAux );
		        bw = new BufferedWriter( fw );
		        
		        String linea;
		        while( ( linea = br.readLine() ) != null )
		        {
		        	String[] parts = linea.split(",");
		        	contenido = parts[1]+ " ContainsA " + parts[0] + "\n";
		        	bw.write(contenido);
		        }
	    	}
	    	if(nombreArchivo.matches("Het.csv"))
	    	{
		        fr = new FileReader(nombreCarpeta + "/" + nombreArchivo);
		        br = new BufferedReader( fr );
		        File folder = new File(nombreCarpeta+"/giraph");
		        folder.mkdirs();
		        String nombreCarpetaAux = nombreCarpeta + "/giraph/" + nombreArchivo;
		        fw = new FileWriter( nombreCarpetaAux );
		        bw = new BufferedWriter( fw );
		        
		        String linea;
		        while( ( linea = br.readLine() ) != null )
		        {
		        	String[] parts = linea.split(",");
		        	contenido = parts[1]+ " ContainsH " + parts[0] + "\n";
		        	bw.write(contenido);
		        }
	    	}
	    	if(nombreArchivo.matches("AtomAmino.csv"))
	    	{
		        fr = new FileReader(nombreCarpeta + "/" + nombreArchivo);
		        br = new BufferedReader( fr );
		        File folder = new File(nombreCarpeta+"/giraph");
		        folder.mkdirs();
		        String nombreCarpetaAux = nombreCarpeta + "/giraph/" + nombreArchivo;
		        fw = new FileWriter( nombreCarpetaAux );
		        bw = new BufferedWriter( fw );
		        
		        String linea;
		        while( ( linea = br.readLine() ) != null )
		        {
		        	String[] parts = linea.split(",");
		        	contenido = parts[7]+ " ContainsAA " + parts[0] + "\n";
		        	bw.write(contenido);
		        }
	    	}
	    	if(nombreArchivo.matches("AtomHet.csv"))
	    	{
		        fr = new FileReader(nombreCarpeta + "/" + nombreArchivo);
		        br = new BufferedReader( fr );
		        File folder = new File(nombreCarpeta+"/giraph");
		        folder.mkdirs();
		        String nombreCarpetaAux = nombreCarpeta + "/giraph/" + nombreArchivo;
		        fw = new FileWriter( nombreCarpetaAux );
		        bw = new BufferedWriter( fw );
		        
		        String linea;
		        while( ( linea = br.readLine() ) != null )
		        {
		        	String[] parts = linea.split(",");
		        	contenido = parts[7]+ " ContainsAH " + parts[0] + "\n";
		        	bw.write(contenido);
		        }
	    	}

	    	
	 
	    }catch( Exception e ){  }
	    //finally se utiliza para que si todo ocurre correctamente o si ocurre
	    //algun error se cierre el archivo que anteriormente abrimos
	    finally
	    {
	        try{
	            br.close();
	            bw.close();
	        }catch( Exception ex ){}
	    }
	    //Se imprime el contenido
	    
	    //System.out.println( contenido );
	}
}
