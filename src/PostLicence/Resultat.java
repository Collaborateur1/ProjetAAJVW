package PostLicence;

/**
 * Struct definition : Resultat
 * 
 * @author OpenORB Compiler
*/
public final class Resultat implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member semestre
     */
    public short semestre;

    /**
     * Struct member moyenne
     */
    public float moyenne;

    /**
     * Struct member codeObtention
     */
    public short codeObtention;

    /**
     * Struct member classement
     */
    public short classement;

    /**
     * Default constructor
     */
    public Resultat()
    { }

    /**
     * Constructor with fields initialization
     * @param semestre semestre struct member
     * @param moyenne moyenne struct member
     * @param codeObtention codeObtention struct member
     * @param classement classement struct member
     */
    public Resultat(short semestre, float moyenne, short codeObtention, short classement)
    {
        this.semestre = semestre;
        this.moyenne = moyenne;
        this.codeObtention = codeObtention;
        this.classement = classement;
    }

}
