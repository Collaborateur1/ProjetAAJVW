package PostLicence;

/**
 * Holder class for : seqVoeux
 * 
 * @author OpenORB Compiler
 */
final public class seqVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal seqVoeux value
     */
    public PostLicence.Voeu[] value;

    /**
     * Default constructor
     */
    public seqVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public seqVoeuxHolder(PostLicence.Voeu[] initial)
    {
        value = initial;
    }

    /**
     * Read seqVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = seqVoeuxHelper.read(istream);
    }

    /**
     * Write seqVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        seqVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the seqVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return seqVoeuxHelper.type();
    }

}
