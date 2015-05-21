package PostLicence;

/**
 * Struct definition : dossierEtudiant
 * 
 * @author OpenORB Compiler
*/
public final class dossierEtudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member etu
     */
    public PostLicence.Etudiant etu;

    /**
     * Struct member listnotes
     */
    public PostLicence.Resultat[] listnotes;

    /**
     * Default constructor
     */
    public dossierEtudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param etu etu struct member
     * @param listnotes listnotes struct member
     */
    public dossierEtudiant(PostLicence.Etudiant etu, PostLicence.Resultat[] listnotes)
    {
        this.etu = etu;
        this.listnotes = listnotes;
    }

}
