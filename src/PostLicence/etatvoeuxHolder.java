package PostLicence;

/**
 * Holder class for : etatvoeux
 * 
 * @author OpenORB Compiler
 */
final public class etatvoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal etatvoeux value
     */
    public PostLicence.etatvoeux value;

    /**
     * Default constructor
     */
    public etatvoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public etatvoeuxHolder(PostLicence.etatvoeux initial)
    {
        value = initial;
    }

    /**
     * Read etatvoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = etatvoeuxHelper.read(istream);
    }

    /**
     * Write etatvoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        etatvoeuxHelper.write(ostream,value);
    }

    /**
     * Return the etatvoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return etatvoeuxHelper.type();
    }

}
