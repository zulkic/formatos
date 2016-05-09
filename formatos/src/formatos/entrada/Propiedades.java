package formatos.entrada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Propiedades {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final File folder = new File("/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/");
		listFilesForFolder(folder);
		
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
	    ArrayList<String> hierros = new ArrayList<String>();

    	if(nombreArchivo.equals("Het.csv"))
    	{
    	    try
    	    {
		        fr = new FileReader(nombreCarpeta + "/" + nombreArchivo);
		        br = new BufferedReader( fr );
		        File folder = new File(nombreCarpeta+"/giraph");
		        folder.mkdirs();
		        String nombreCarpetaAux = nombreCarpeta + "/giraph/busqueda.csv" ;
		        fw = new FileWriter( nombreCarpetaAux );
		        bw = new BufferedWriter( fw );
		        String linea;
		        String valor="FE2";
		        while( ( linea = br.readLine() ) != null )
		        {
		        	String[] parts = linea.split(",");
		        	if(valor.equals(parts[2]))
		        	{
		        		bw.write(parts[0]+"\n");
		        		hierros.add(parts[0]);
		        	}
		        }
    	    }catch( Exception e ){ 
    	    	e.printStackTrace();
    	    }
    	    finally
    	    {
    	        try{
    	            br.close();
    	            bw.close();
    	        }catch( Exception ex ){
    	        	ex.printStackTrace();
    	        }
    	    }
    	    
    	    try
    	    {
		        fr = new FileReader(nombreCarpeta + "/giraph/" + "Dist2.csv");
		        br = new BufferedReader( fr );
		        File folder = new File(nombreCarpeta+"/giraph");
		        folder.mkdirs();
		        String nombreCarpetaAux = nombreCarpeta + "/giraph/DistanciasFE.csv" ;
		        fw = new FileWriter( nombreCarpetaAux );
		        bw = new BufferedWriter( fw );
		        String linea;
		        while( ( linea = br.readLine() ) != null )
		        {
		        	String[] parts = linea.split("\t");
		        	int valor =0;
		        	for (int i = 0; i < hierros.size() && valor==0; i++) {
		        		if(parts[2].equals(hierros.get(i))) {
		        			valor=1;
		        		}
					}
	        		if(valor==1) {
	        			bw.write(parts[0] + "\t" + parts[1]+ "\t" + parts[2]+"FE2\t" + parts[3]+"\n");
	        		}
	        		else{
	        			bw.write(parts[0] + "\t" + parts[1]+ "\t" + parts[2]+"\t" + parts[3]+"\n");
	        		}
		        }
    	    }catch( Exception e ){ 
    	    	e.printStackTrace();
    	    }
    	    finally
    	    {
    	        try{
    	            br.close();
    	            bw.close();
    	        }catch( Exception ex ){
    	        	ex.printStackTrace();
    	        }
    	    }
    	}
	}
}
