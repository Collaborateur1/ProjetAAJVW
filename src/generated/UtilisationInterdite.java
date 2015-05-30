package generated;

/**
 * Exception definition : UtilisationInterdite
 * 
 * @author OpenORB Compiler
 */
public final class UtilisationInterdite extends org.omg.CORBA.UserException
{
    /**
     * Exception member message
     */
    public String message;

    /**
     * Default constructor
     */
    public UtilisationInterdite()
    {
        super(UtilisationInterditeHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param message message exception member
     */
    public UtilisationInterdite(String message)
    {
        super(UtilisationInterditeHelper.id());
        this.message = message;
    }

    /**
     * Full constructor with fields initialization
     * @param message message exception member
     */
    public UtilisationInterdite(String orb_reason, String message)
    {
        super(UtilisationInterditeHelper.id() +" " +  orb_reason);
        this.message = message;
    }

}
