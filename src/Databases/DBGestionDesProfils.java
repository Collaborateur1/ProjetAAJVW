package Databases;

import generated.Etudiant;
import generated.Formation;
import generated.dossierEtudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class DBGestionDesProfils {
	Connection conn;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public DBGestionDesProfils()
	{
		//Création de la base de données si non créé
	
			try {
				 Class.forName("org.h2.Driver");
			    conn = DriverManager.getConnection("jdbc:h2:"+"BddsnDBGestionDesProfils"+";IGNORECASE=TRUE", "sa", "");
			    // on cree un objet Statement qui va permettre l'execution des requetes
		        Statement s = conn.createStatement();
		
		        // On regarde si la table existe deja
		        String query = "select * from ETUDIANT limit 1";
		       
		       
		        try {
		        	s.executeQuery(query);
		        	
		        } catch(Exception e) {
		        	// Dans le cas où elle n'existe pas, on l'a crée
		        	System.out.println("creation table");
		        	
		        	s.execute("create table ETUDIANT  ( " +
		        			" IDETUDIANT SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, " +
		        			" NOMETUDIANT VARCHAR( 30 ) NOT NULL , " +
		        			" PRENOMETUDIANT VARCHAR( 30 ) NOT NULL , " +
		        			" INEETUDIANT VARCHAR( 30 ) NOT NULL , " +
		        			" NOMUNIVERSITE VARCHAR( 30 ) NOT NULL , " +
		        			" NOMUNIVERSITEF VARCHAR( 30 ) NOT NULL , " +
		        			" NOMFORMATION VARCHAR( 30 ) NOT NULL , " +
		        			" TYPEFORMATION VARCHAR( 30 ) NOT NULL , " +
		        			" NOMRECTORAT VARCHAR( 30 ) NOT NULL , " +
		        			" MOTSDEPASSE VARCHAR( 30 ) NOT NULL , " +
		        			" QUOTA SMALLINT ,"+
		        			" ADRESSE VARCHAR( 50 ) ,PRIMARY KEY(IDETUDIANT))");
		      
		        	
		        	
		        }
                         
		        
		   			} catch(Exception e) {
		   				// Il y a une erreur
		   				e.printStackTrace();
		   			}
			
			
			
	}	

	public void ajouterEtudiant(String ine, Etudiant detu, String mdp) throws Exception
	{
		
		 Statement s = null;
		 String query ="select * from ETUDIANT WHERE INEETUDIANT='"+ine+"'";
		 
		 ResultSet re = null;
		 
		try {
			s = conn.createStatement();

			 
			s.executeUpdate("insert into ETUDIANT values (NULL,'"+detu.nomEtudiant+"','"+
			detu.prenomEtudiant+"','"+detu.ineEtudiant+"','"+detu.nomUniv+"','"+detu.formation.nomUniv+"','"+
			detu.formation.NomFormation+"','"+detu.formation.TypeFormation+"','"+
			detu.formation.nomRectorat+"','"+mdp+"',"+detu.formation.quota+",'"+
			detu.adresse+"')");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public ArrayList<BDDEtudiantHelper> ChargerEtudiant() throws SQLException
		{
	        	
			
			 String query ="select * from ETUDIANT ";
			 
			 Statement s = null;
			 ResultSet re = null;
			
			try {
				s = conn.createStatement();
				 re=s.executeQuery(query);
				 
				 ArrayList<BDDEtudiantHelper> array=new ArrayList<BDDEtudiantHelper>();
					
				while(re.next())
				{
					array.add(new BDDEtudiantHelper(re.getString("NOMETUDIANT"), re.getString("PRENOMETUDIANT"),
					re.getString("INEETUDIANT"), re.getString("NOMUNIVERSITE"),re.getString("NOMUNIVERSITEF") ,
					re.getString("NOMFORMATION"), re.getString("TYPEFORMATION"),
					re.getString("NOMRECTORAT"),re.getString("MOTDEPASSE"),re.getShort("QUOTA"),re.getString("ADRESSE")));
				}
				
				return array;				
				
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return null;
		}
	
	
	//connecter un profil grace à son identifiant et son mot de passe
	
}
