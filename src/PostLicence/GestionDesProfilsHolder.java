package PostLicence;

/**
 * Holder class for : GestionDesProfils
 * 
 * @author OpenORB Compiler
 */
final public class GestionDesProfilsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionDesProfils value
     */
    public PostLicence.GestionDesProfils value;

    /**
     * Default constructor
     */
    public GestionDesProfilsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionDesProfilsHolder(PostLicence.GestionDesProfils initial)
    {
        value = initial;
    }

    /**
     * Read GestionDesProfils from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionDesProfilsHelper.read(istream);
    }

    /**
     * Write GestionDesProfils into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionDesProfilsHelper.write(ostream,value);
    }

    /**
     * Return the GestionDesProfils TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionDesProfilsHelper.type();
    }

}
