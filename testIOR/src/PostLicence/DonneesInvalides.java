package PostLicence;

/**
 * Exception definition : DonneesInvalides
 * 
 * @author OpenORB Compiler
 */
public final class DonneesInvalides extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public DonneesInvalides()
    {
        super(DonneesInvalidesHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public DonneesInvalides(String message)
    {
        super(DonneesInvalidesHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public DonneesInvalides(String orb_reason, String message)
    {
        super(DonneesInvalidesHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
