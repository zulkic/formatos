package formatos.entrada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Implementador {

	/**
	 * @param args
	 */
	
    public static void cargarProteinChain() throws FileNotFoundException, IOException {
        String protein, chain;
        String archivoP = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/Protein.csv";
        String archivoC = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/Chain.csv";
        String archivoSalida = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/giraph1/proteinChain.csv";
        FileReader fp = new FileReader(archivoP);
        FileReader fc = new FileReader(archivoC);
        BufferedReader bp = new BufferedReader(fp);
        BufferedReader bc = new BufferedReader(fc);
        String linea;
        FileWriter fw = new FileWriter(archivoSalida);
        BufferedWriter bw = new BufferedWriter(fw);
        
        while((protein = bp.readLine())!=null && (chain = bc.readLine())!=null) {
        	JSONObject jo = new JSONObject();
        	String[] proteinCut = protein.split(",");
        	String[] chainCut = chain.split(",");
        	jo.put("seqres", chainCut[2]);
        	jo.put("num_het", chainCut[3]);
        	jo.put("num_amino", chainCut[4]);
        	jo.put("mod_date", proteinCut[5]);
        	jo.put("technique", proteinCut[4]);
        	jo.put("dep_date", proteinCut[3]);
        	jo.put("classification", proteinCut[2]);
        	jo.put("title", proteinCut[1]);
        	jo.put("proteinId", proteinCut[0]);
        	jo.put("_label", "proteinChain");
        	linea = chainCut[0] + "\t" + jo.toString() ;
        	bw.write(linea);
        	bw.newLine();
        }
        bp.close();
        bc.close();
        bw.close();
    }
    
    public static void cargarAminoacid() throws FileNotFoundException, IOException {
        String aminoacid;
        String archivoA = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/Aminoacid.csv";
        String archivoSalida = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/giraph1/Aminoacid.csv";
        FileReader fa = new FileReader(archivoA);
        BufferedReader ba = new BufferedReader(fa);
        String linea;
        FileWriter fw = new FileWriter(archivoSalida);
        BufferedWriter bw = new BufferedWriter(fw);
        
        while((aminoacid = ba.readLine())!=null) {
        	JSONObject jo = new JSONObject();
        	String[] aminoacidCut = aminoacid.split(",");
        	jo.put("symbol", aminoacidCut[2]);
        	jo.put("proteinId", aminoacidCut[3]);
        	if(aminoacidCut.length == 5)
        		jo.put("next_amino", aminoacidCut[4]);
        	jo.put("_label", "aminoacid");
        	linea = aminoacidCut[0] + "\t" + jo.toString() + "\t" + aminoacidCut[1] + "\t{\"_label\":\"isContainForAminoacid\"}" ;
        	bw.write(linea);
        	bw.newLine();
        }
        ba.close();
        bw.close();
    }
    
    public static void cargarHetam() throws FileNotFoundException, IOException {
        String aminoacid;
        String archivoA = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/Het.csv";
        String archivoSalida = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/giraph1/Het.csv";
        FileReader fa = new FileReader(archivoA);
        BufferedReader ba = new BufferedReader(fa);
        String linea;
        FileWriter fw = new FileWriter(archivoSalida);
        BufferedWriter bw = new BufferedWriter(fw);
        
        while((aminoacid = ba.readLine())!=null) {
        	JSONObject jo = new JSONObject();
        	String[] aminoacidCut = aminoacid.split(",");
        	jo.put("symbol", aminoacidCut[2]);
        	jo.put("proteinId", aminoacidCut[3]);
        	jo.put("num_atom", aminoacidCut[4]);
        	jo.put("_label", "het");
        	linea = aminoacidCut[0] + "\t" + jo.toString() + "\t" + aminoacidCut[1] + "\t{\"_label\":\"isContainForHetam\"}" ;
        	bw.write(linea);
        	bw.newLine();
        }
        ba.close();
        bw.close();
    }
    
    public static void cargarAtomAmino() throws FileNotFoundException, IOException {
        String aminoacid;
        String archivoA = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/AtomAmino.csv";
        String archivoSalida = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/giraph1/AtomAmino.csv";
        FileReader fa = new FileReader(archivoA);
        BufferedReader ba = new BufferedReader(fa);
        String linea;
        FileWriter fw = new FileWriter(archivoSalida);
        BufferedWriter bw = new BufferedWriter(fw);
        
        while((aminoacid = ba.readLine())!=null) {
        	JSONObject jo = new JSONObject();
        	String[] aminoacidCut = aminoacid.split(",");
        	jo.put("symbol", aminoacidCut[1]);
        	jo.put("number", aminoacidCut[2]);
        	jo.put("x", aminoacidCut[3]);
        	jo.put("y", aminoacidCut[4]);
        	jo.put("z", aminoacidCut[5]);
        	jo.put("element", aminoacidCut[6]);
        	jo.put("_label", "atomAmino");
        	linea = aminoacidCut[0] + "\t" + jo.toString() + "\t" + aminoacidCut[7] + "\t{\"_label\":\"isContainForAtomAmino\"}" ;
        	bw.write(linea);
        	bw.newLine();
        }
        ba.close();
        bw.close();
    }
    
    public static void cargarAtomHet() throws FileNotFoundException, IOException {
        String aminoacid;
        String archivoA = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/AtomHet.csv";
        String archivoSalida = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/giraph1/AtomHet.csv";
        FileReader fa = new FileReader(archivoA);
        BufferedReader ba = new BufferedReader(fa);
        String linea;
        FileWriter fw = new FileWriter(archivoSalida);
        BufferedWriter bw = new BufferedWriter(fw);
        
        while((aminoacid = ba.readLine())!=null) {
        	JSONObject jo = new JSONObject();
        	String[] aminoacidCut = aminoacid.split(",");
        	jo.put("symbol", aminoacidCut[1]);
        	jo.put("number", aminoacidCut[2]);
        	jo.put("x", aminoacidCut[3]);
        	jo.put("y", aminoacidCut[4]);
        	jo.put("z", aminoacidCut[5]);
        	jo.put("element", aminoacidCut[6]);
        	jo.put("_label", "atomHet");
        	linea = aminoacidCut[0] + "\t" + jo.toString() + "\t" + aminoacidCut[7] + "\t{\"_label\":\"isContainForAtomHet\"}" ;
        	bw.write(linea);
        	bw.newLine();
        }
        ba.close();
        bw.close();
    }
    
    public static void cargarDistanciaAminoHet() throws FileNotFoundException, IOException {
        String aminoacid;
        String archivoA = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/Dist2.csv";
        String archivoSalida = "/media/hduser/9E3A33E13A33B55D/Francisco/20151007-PDB-CSV/giraph1/Dist2.csv";
        FileReader fa = new FileReader(archivoA);
        BufferedReader ba = new BufferedReader(fa);
        String linea;
        FileWriter fw = new FileWriter(archivoSalida);
        BufferedWriter bw = new BufferedWriter(fw);
        
        while((aminoacid = ba.readLine())!=null) {
        	JSONObject jo = new JSONObject();
        	String[] aminoacidCut = aminoacid.split(",");
        	jo.put("distance", aminoacidCut[2]);
        	jo.put("_label", "distanciaAminoHet");
        	linea = aminoacidCut[0] + "\t"  + aminoacidCut[1] + "\t" + jo.toString(); 
        	bw.write(linea);
        	bw.newLine();
        	linea = aminoacidCut[1] + "\t"  + aminoacidCut[0] + "\t" + jo.toString();
        	bw.write(linea);
        	bw.newLine();
        }
        ba.close();
        bw.close();
    }
 
    public static void main(String[] args) throws IOException {
    	System.out.println("Generando ProteinChain");
        cargarProteinChain();
        System.out.println("Generando Aminoacid");
        cargarAminoacid();
        System.out.println("Generando Hetam");
        cargarHetam();
        System.out.println("Generando AtomAmino");
        cargarAtomAmino();
        System.out.println("Generando AtomHet");
        cargarAtomHet();
        System.out.println("Generando distancias de aminosHetams");
        cargarDistanciaAminoHet();
        
    }
}
