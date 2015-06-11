package generated;

/**
 * Struct definition : Formation
 * 
 * @author OpenORB Compiler
*/
public final class Formation implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member nomUniv
     */
    public String nomUniv;

    /**
     * Struct member NomFormation
     */
    public String NomFormation;

    /**
     * Struct member TypeFormation
     */
    public String TypeFormation;

    /**
     * Struct member nomRectorat
     */
    public String nomRectorat;

    /**
     * Struct member quota
     */
    public short quota;

    /**
     * Default constructor
     */
    public Formation()
    { }

    /**
     * Constructor with fields initialization
     * @param nomUniv nomUniv struct member
     * @param NomFormation NomFormation struct member
     * @param TypeFormation TypeFormation struct member
     * @param nomRectorat nomRectorat struct member
     * @param quota quota struct member
     */
    public Formation(String nomUniv, String NomFormation, String TypeFormation, String nomRectorat, short quota)
    {
        this.nomUniv = nomUniv;
        this.NomFormation = NomFormation;
        this.TypeFormation = TypeFormation;
        this.nomRectorat = nomRectorat;
        this.quota = quota;
    }

}
