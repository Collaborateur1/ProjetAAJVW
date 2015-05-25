package PostLicence;

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
    public PostLicence.Formation formationVoeu;

    /**
     * Struct member etatVoeu
     */
    public PostLicence.etatvoeux etatVoeu;

    /**
     * Struct member dcsEtudiant
     */
    public PostLicence.decision dcsEtudiant;

    /**
     * Struct member numeroVoeu
     */
    public short numeroVoeu;

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
     */
    public Voeu(PostLicence.Formation formationVoeu, PostLicence.etatvoeux etatVoeu, PostLicence.decision dcsEtudiant, short numeroVoeu)
    {
        this.formationVoeu = formationVoeu;
        this.etatVoeu = etatVoeu;
        this.dcsEtudiant = dcsEtudiant;
        this.numeroVoeu = numeroVoeu;
    }

}
