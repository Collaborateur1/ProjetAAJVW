package generated;

/**
 * Struct definition : Etudiant
 * 
 * @author OpenORB Compiler
*/
public final class Etudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member nomEtudiant
     */
    public String nomEtudiant;

    /**
     * Struct member prenomEtudiant
     */
    public String prenomEtudiant;

    /**
     * Struct member ineEtudiant
     */
    public String ineEtudiant;

    /**
     * Struct member nomUniv
     */
    public String nomUniv;

    /**
     * Struct member adresse
     */
    public String adresse;

    /**
     * Struct member formation
     */
    public generated.Formation formation;

    /**
     * Default constructor
     */
    public Etudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param nomEtudiant nomEtudiant struct member
     * @param prenomEtudiant prenomEtudiant struct member
     * @param ineEtudiant ineEtudiant struct member
     * @param nomUniv nomUniv struct member
     * @param adresse adresse struct member
     * @param formation formation struct member
     */
    public Etudiant(String nomEtudiant, String prenomEtudiant, String ineEtudiant, String nomUniv, String adresse, generated.Formation formation)
    {
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.ineEtudiant = ineEtudiant;
        this.nomUniv = nomUniv;
        this.adresse = adresse;
        this.formation = formation;
    }

}
