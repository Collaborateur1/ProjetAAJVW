package Databases;

import generated.Formation;
import generated.Voeu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

public class DBGestionDesVoeux {
	Connection conn;
	public DBGestionDesVoeux(){
	//Création de la base de données si non créée
	
		try {
			 Class.forName("org.h2.Driver");
		    conn = DriverManager.getConnection("jdbc:h2:"+"BddsnDBGestionDesVoeux"+";IGNORECASE=TRUE", "sa", "");
		    // on cree un objet Statement qui va permettre l'execution des requetes
	        Statement s = conn.createStatement();
	
	        // On regarde si la table existe deja
	        String query = "select * from VOEU 1";
	       
	       
	        try {
	        	s.executeQuery(query);
	        	
	        } catch(Exception e) {
	        	// Dans le cas où elle n'existe pas, on l'a crée
	        	System.out.println("creation table");
	        	
	        	s.execute("create table VOEU  ( " +
	        			" IDVOEU SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, " +
	        			" INEETUDIANT VARCHAR( 30 ) NOT NULL , " +
	        			" NOMUNIVERSITE VARCHAR( 30 ) NOT NULL , " +
	        			" NOMFORMATION VARCHAR( 30 ) NOT NULL , " +
	        			" TYPEFORMATION VARCHAR( 30 ) NOT NULL , " +
	        			" NOMRECTORAT VARCHAR( 30 ) NOT NULL , " +
	        			" QUOTA SMALLINT ,"+
	        			"ETATVOEUX VARCHAR( 30 ) NOT NULL,"+
	        			"DECISION VARCHAR( 30 ) NOT NULL,"+ 
	        			"NUMEROVOEU SMALLINT,"+
	        			"NUMEROGDV SMALLINT,PRIMARY KEY(IDVOEU))");			 
	        	
	        }
               
	        
	        
	   			} catch(Exception e) {
	   				// Il y a une erreur
	   				e.printStackTrace();
	   			}
		
		

}	
	
	public Hashtable<String, ArrayList<Voeu>> Chargervoeu() throws SQLException
	{
        	
		
		 String query ="select * from VOEU ";
		 
		 Statement s = null;
		 ResultSet re = null;
		
		try {
			s = conn.createStatement();
			 re=s.executeQuery(query);
			 
			 BddHelperVoeu helpV= new BddHelperVoeu();
				
			while(re.next())
			{
				
				helpV.ajouterVoeu(re.getString("INEETUDIANT"), re.getString("NOMUNIVERSITE"), re.getString("NOMFORMATION"),
				re.getString("TYPEFORMATION"), re.getString("NOMRECTORAT"), re.getShort("QUOTA"),re.getString("ETATVOEUX"),
				re.getString("DECISION"), re.getShort("NUMEROVOEU"), re.getShort("NUMEROGDV"));
				
				
			}
			
			return helpV.getListeVoeuxEtudiant();				
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	public void ajouterVoeux(Voeu vx, String ine) throws SQLException
	{
		
		 Statement s = null;
		 
		try {
			s = conn.createStatement();
	
			s.executeUpdate("insert into VOEU values (NULL,'"+ine+"','"+vx.formationVoeu.nomUniv+"','"+
			                vx.formationVoeu.NomFormation+"','"+vx.formationVoeu.TypeFormation+"','"+
					        vx.formationVoeu.nomRectorat+"',"+vx.formationVoeu.quota+",'"+
					        String.valueOf(vx.etatVoeu)+"','"+String.valueOf(vx.dcsEtudiant)+"',"+
			                vx.numeroVoeu+","+vx.numerogdv+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void supprimerVoeux(Voeu vx, String ine) throws SQLException
	{
		
		 Statement s = null;
	
		try {
			s = conn.createStatement();
			s.executeUpdate("DELETE FROM VOEU WHERE INEETUDIANT='"+ine+"' AND NUMEROVOEU="+vx.numeroVoeu);
			
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modifierEtatVoeux(Voeu vx, String ine) throws SQLException
	{
		
		 Statement s = null;
	
		try {
			s = conn.createStatement();
			s.executeUpdate("UPDATE  VOEU set ETATVOEUX='"+vx.etatVoeu+"' WHERE INEETUDIANT='"+ine+"' AND NUMEROVOEU="+vx.numeroVoeu);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modifierDecisionVoeux(Voeu vx, String ine) throws SQLException
	{
		
		 Statement s = null;
	
		try {
			s = conn.createStatement();
			s.executeUpdate("UPDATE  VOEU set DECISION='"+vx.dcsEtudiant+"' WHERE INEETUDIANT='"+ine+"' AND NUMEROVOEU="+vx.numeroVoeu);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void supprimerAllVoeux(Voeu vx, String ine) throws SQLException
	{
		
		 Statement s = null;
	
		try {
			s = conn.createStatement();
			s.executeUpdate("DELETE FROM VOEU WHERE INEETUDIANT='"+ine+"'");
			
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
