package formatos.entrada;


import org.json.JSONObject;

public class People {

	private String gigante="";
	private int id;
	private JSONObject json;

	public People(int id, JSONObject json)
	{
		this.id= id;
		this.json= json;

	}


	public String toString()
	{
		String all = this.id +"\t" + this.json ;
		return all + gigante;
	}

	public void addNeighboord(String neighbor, String etiqueta)
	{

		if(etiqueta.equals("friend"))
			gigante += "\t" + neighbor + "\t" + "{\"_label\":\"friend\",\"distance\":1}";
		else
			gigante += "\t" + neighbor + "\t" + "{\"_label\":\"like\"}";
	}

}
