package Databases;

import generated.Etudiant;
import generated.Formation;
import generated.Resultat;
import generated.dossierEtudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class DBUniversite {
	Connection conn;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public DBUniversite(String nomUniv)
	{
		//Création de la base de données si non créée

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:"+"BddsnDBUniversite_"+nomUniv+";IGNORECASE=TRUE", "sa", "");
			// Création d'un objet Statement qui va permettre l'execution des requetes
			Statement s = conn.createStatement();

			// On vérifie si la table existe deja
			String query = "select * from ETUDIANT limit 1";
			String query1 = "select * from  FORMATION limit 1";
			String query3 = "select * from RESULTAT limit 1";
			String query4 = "select * from PREREQUIS limit 1";

			try {
				s.executeQuery(query1);

			} catch(Exception e) 
			{
				s.execute("create table FORMATION  ( " +
						" IDFORMATION SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, " +
						" NOMUNIVERSITE VARCHAR( 30 ) NOT NULL , " +
						" NOMFORMATION VARCHAR( 30 ) NOT NULL , " +
						" TYPEFORMATION VARCHAR( 30 ) NOT NULL , " +
						" NOMRECTORAT VARCHAR( 30 ) NOT NULL , " +
						" QUOTA SMALLINT ,PRIMARY KEY(IDFORMATION))");			        	
			}    

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
						" QUOTA SMALLINT ,"+
						" ADRESSE VARCHAR( 50 ) ,PRIMARY KEY(IDETUDIANT))");



			}




			try {
				s.executeQuery(query3);

			} catch(Exception e)
			{
				s.execute("create table RESULTAT  ( " +
						" IDRESULTAT SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, " +
						" INEETUDIANT VARCHAR( 30 ) NOT NULL , " +
						" MOYENNE FLOAT NOT NULL , " +
						" CODEOBTENTION SMALLINT NOT NULL , " +
						" CLASSEMENT SMALLINT NOT NULL ,"+
						" MOYENNE2 FLOAT NOT NULL , " +
						" CODEOBTENTION2 SMALLINT NOT NULL , " +
						" CLASSEMENT2 SMALLINT NOT NULL ,"+
						" MOYENNE3 FLOAT NOT NULL , " +
						" CODEOBTENTION3 SMALLINT NOT NULL , " +
						" CLASSEMENT3 SMALLINT NOT NULL ,"+ 			
						" MOYENNE4 FLOAT NOT NULL , " +
						" CODEOBTENTION4 SMALLINT NOT NULL , " +
						" CLASSEMENT4 SMALLINT NOT NULL ,"+		        			
						" MOYENNE5 FLOAT NOT NULL , " +
						" CODEOBTENTION5 SMALLINT NOT NULL , " +
						" CLASSEMENT5 SMALLINT NOT NULL ,"+	
						" MOYENNE6 FLOAT NOT NULL , " +
						" CODEOBTENTION6 SMALLINT NOT NULL , " +
						" CLASSEMENT6 SMALLINT NOT NULL ,PRIMARY KEY(IDRESULTAT))");
			}


			try {
				s.executeQuery(query4);

			} catch(Exception e)
			{
				s.execute("create table PREREQUIS  ( " +
						" NomFormation VARCHAR( 30 ) NOT NULL , " +
						" Prerequis VARCHAR( 30 ) NOT NULL )");
			}



		} catch(Exception e) {
			// Il y a une erreur
			e.printStackTrace();
		}

	}
	//Ajouter une formation dans la table Formation
	public void ajouterFormation(Formation formation, String[] prerequis) throws SQLException
	{

		Statement s = null;

		try {
			s = conn.createStatement();
			for(int i=0;i<prerequis.length;i++){
				s.executeUpdate("insert into PREREQUIS values ('"+formation.NomFormation+"','"+prerequis[i]+"')");

			}

			s.executeUpdate("insert into FORMATION values (NULL,'"+formation.nomUniv+"','"+formation.NomFormation+"','"+formation.TypeFormation+"','"+formation.nomRectorat+"',"+formation.quota+")");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ajouterEtudiant(String ine, dossierEtudiant detu) throws Exception
	{

		Statement s = null;
		String query ="select * from ETUDIANT WHERE INEETUDIANT='"+ine+"'";

		ResultSet re = null;

		try {
			s = conn.createStatement();


			s.executeUpdate("insert into ETUDIANT values (NULL,'"+detu.etu.nomEtudiant+"','"+
					detu.etu.prenomEtudiant+"','"+detu.etu.ineEtudiant+"','"+detu.etu.nomUniv+"','"+detu.etu.formation.nomUniv+"','"+
					detu.etu.formation.NomFormation+"','"+detu.etu.formation.TypeFormation+"','"+
					detu.etu.formation.nomRectorat+"',"+detu.etu.formation.quota+",'"+
					detu.etu.adresse+"')");

			ajouterResultat(detu.etu.ineEtudiant, detu.listnotes);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Création du profil fictif utile pour consulter

	public ArrayList<dossierEtudiant> ChargerEtudiant() throws SQLException
	{


		String query ="select * from ETUDIANT ";
		Statement s = null;
		ResultSet re = null;

		try {
			s = conn.createStatement();
			re=s.executeQuery(query);

			ArrayList<Etudiant> array=new ArrayList<Etudiant>();
			ArrayList<dossierEtudiant> array2=new ArrayList<dossierEtudiant>();

			while(re.next())
			{
				array.add(new Etudiant(re.getString("NOMETUDIANT"), re.getString("PRENOMETUDIANT"),
						re.getString("INEETUDIANT"), re.getString("NOMUNIVERSITE"),re.getString("ADRESSE") ,
						new Formation(re.getString("NOMUNIVERSITEF"),re.getString("NOMFORMATION"), re.getString("TYPEFORMATION"),
								re.getString("NOMRECTORAT"),re.getShort("QUOTA"))));
			}

			for (int i=0;i<array.size();i++)
			{
				array2.add(new dossierEtudiant(array.get(i),getResultat(array.get(i).ineEtudiant)));

			}

			return array2;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public String[] chargerPrerequis(String nomForm)
	{
		String query ="select * from PREREQUIS WHERE NOMFORMATION='"+nomForm+"'";
		Statement s = null;
		ResultSet re = null;

		try {
			s = conn.createStatement();
			re=s.executeQuery(query);

			ArrayList<String> array = new ArrayList<String>();

			while(re.next())
			{
				array.add(re.getString("PREREQUIS"));
			}
			
			String[] array2 = new String[array.size()];
			for(int i=0;i<array.size();i++)
			{
				array2[i] = array.get(i);
			}

			return array2;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public void ajouterResultat(String ine, Resultat[] result) throws SQLException
	{


		Statement s = null;



		try {
			s = conn.createStatement();
			s.executeUpdate("insert into RESULTAT values (NULL,'"+ine+"',"+result[0].moyenne+","+result[0].codeObtention+","+result[0].classement+","+
					result[1].moyenne+","+result[1].codeObtention+","+result[1].classement+","+
					result[2].moyenne+","+result[2].codeObtention+","+result[2].classement+","+
					result[3].moyenne+","+result[3].codeObtention+","+result[3].classement+","+
					result[4].moyenne+","+result[4].codeObtention+","+result[4].classement+","+
					result[5].moyenne+","+result[5].codeObtention+","+result[5].classement+")");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


	public Resultat[] getResultat(String ine) throws SQLException
	{

		String query ="select * from RESULTAT WHERE INEETUDIANT='"+ine+"'";
		Statement s = null;
		ResultSet eta = null;
		try {


			s = conn.createStatement();
			eta=s.executeQuery(query);
			Resultat[] result= new Resultat[6];

			if(eta.next())
				result[0]= new Resultat((short)1, eta.getFloat("MOYENNE"), eta.getShort("CODEOBTENTION"),  eta.getShort("CLASSEMENT"));

			eta=s.executeQuery(query);
			if(eta.next())
				result[1]= new Resultat((short)2, eta.getFloat("MOYENNE2"), eta.getShort("CODEOBTENTION2"),  eta.getShort("CLASSEMENT2"));

			eta=s.executeQuery(query);
			if(eta.next())
				result[2]= new Resultat((short)3, eta.getFloat("MOYENNE3"), eta.getShort("CODEOBTENTION3"),  eta.getShort("CLASSEMENT3"));

			eta=s.executeQuery(query);
			if(eta.next())
				result[3]= new Resultat((short)4, eta.getFloat("MOYENNE4"), eta.getShort("CODEOBTENTION4"),  eta.getShort("CLASSEMENT4"));

			eta=s.executeQuery(query);
			if(eta.next())
				result[4]= new Resultat((short)5, eta.getFloat("MOYENNE5"), eta.getShort("CODEOBTENTION5"),  eta.getShort("CLASSEMENT5"));

			eta=s.executeQuery(query);
			if(eta.next())
				result[5]= new Resultat((short)6, eta.getFloat("MOYENNE6"), eta.getShort("CODEOBTENTION6"),  eta.getShort("CLASSEMENT6"));

			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<BddHelperFormation> getFormation() throws SQLException
	{

		Statement s = null;
		Statement s2 = null;
		String req="select * from FORMATION";
		String req2;
		ResultSet re=null;
		ResultSet re2=null;
		try {
			s = conn.createStatement();
			s2=conn.createStatement();
			re =s.executeQuery(req);



			ArrayList<Formation> formation=new ArrayList<Formation>();
			while(re.next())
			{formation.add(new Formation(re.getString("NOMUNIVERSITE"), re.getString("NOMFORMATION"),
					re.getString("TYPEFORMATION"), re.getString("NOMRECTORAT"), re.getShort("QUOTA")));	
			}


			ArrayList<BddHelperFormation> formationPrerequis=new ArrayList<BddHelperFormation>();
			BddHelperFormation bdhelper = null;
			for (int i=0; i<formation.size();i++)
			{
				req2="select * from PREREQUIS where NomFormation='"+formation.get(i).NomFormation+"'";
				re2=s2.executeQuery(req2);
				if(re2.next())
				{
					bdhelper=new BddHelperFormation(formation.get(i));
					bdhelper.addPrerequis(re2.getString("Prerequis"));
				}
				while(re2.next())
				{
					bdhelper.addPrerequis(re2.getString("Prerequis"));
				}
				formationPrerequis.add(bdhelper);
			}

			return formationPrerequis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
