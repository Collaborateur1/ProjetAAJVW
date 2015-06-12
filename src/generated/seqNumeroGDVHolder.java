package generated;

/**
 * Holder class for : seqNumeroGDV
 * 
 * @author OpenORB Compiler
 */
final public class seqNumeroGDVHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal seqNumeroGDV value
     */
    public short[] value;

    /**
     * Default constructor
     */
    public seqNumeroGDVHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public seqNumeroGDVHolder(short[] initial)
    {
        value = initial;
    }

    /**
     * Read seqNumeroGDV from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = seqNumeroGDVHelper.read(istream);
    }

    /**
     * Write seqNumeroGDV into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        seqNumeroGDVHelper.write(ostream,value);
    }

    /**
     * Return the seqNumeroGDV TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return seqNumeroGDVHelper.type();
    }

}
