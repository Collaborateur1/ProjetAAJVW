package generated;

/**
 * Struct definition : Voeu
 * 
 * @author OpenORB Compiler
*/
public final class Voeu implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member formationVoeu
     */
    public generated.Formation formationVoeu;

    /**
     * Struct member etatVoeu
     */
    public generated.etatvoeux etatVoeu;

    /**
     * Struct member dcsEtudiant
     */
    public generated.decision dcsEtudiant;

    /**
     * Struct member numeroVoeu
     */
    public short numeroVoeu;

    /**
     * Struct member numerogdv
     */
    public short numerogdv;

    /**
     * Default constructor
     */
    public Voeu()
    { }

    /**
     * Constructor with fields initialization
     * @param formationVoeu formationVoeu struct member
     * @param etatVoeu etatVoeu struct member
     * @param dcsEtudiant dcsEtudiant struct member
     * @param numeroVoeu numeroVoeu struct member
     * @param numerogdv numerogdv struct member
     */
    public Voeu(generated.Formation formationVoeu, generated.etatvoeux etatVoeu, generated.decision dcsEtudiant, short numeroVoeu, short numerogdv)
    {
        this.formationVoeu = formationVoeu;
        this.etatVoeu = etatVoeu;
        this.dcsEtudiant = dcsEtudiant;
        this.numeroVoeu = numeroVoeu;
        this.numerogdv = numerogdv;
    }

}
