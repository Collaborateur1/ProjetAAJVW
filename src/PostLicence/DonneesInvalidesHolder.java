package PostLicence;

/**
 * Holder class for : DonneesInvalides
 * 
 * @author OpenORB Compiler
 */
final public class DonneesInvalidesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal DonneesInvalides value
     */
    public PostLicence.DonneesInvalides value;

    /**
     * Default constructor
     */
    public DonneesInvalidesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DonneesInvalidesHolder(PostLicence.DonneesInvalides initial)
    {
        value = initial;
    }

    /**
     * Read DonneesInvalides from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DonneesInvalidesHelper.read(istream);
    }

    /**
     * Write DonneesInvalides into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DonneesInvalidesHelper.write(ostream,value);
    }

    /**
     * Return the DonneesInvalides TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DonneesInvalidesHelper.type();
    }

}
