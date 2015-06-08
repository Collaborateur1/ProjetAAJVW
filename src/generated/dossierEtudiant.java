package generated;

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
    public generated.Etudiant etu;

    /**
     * Struct member listnotes
     */
    public generated.Resultat[] listnotes;

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
    public dossierEtudiant(generated.Etudiant etu, generated.Resultat[] listnotes)
    {
        this.etu = etu;
        this.listnotes = listnotes;
    }

}
