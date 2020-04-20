package co.komp.principal;

import co.komp.connection.Conector;

public class Principal {
	
	public static void main(String[] args) {
		Conector con = new Conector();
		con.connect();
		con.consult();
		con.close();
	}
	
}
