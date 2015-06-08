package generated;

/**
 * Holder class for : decision
 * 
 * @author OpenORB Compiler
 */
final public class decisionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal decision value
     */
    public generated.decision value;

    /**
     * Default constructor
     */
    public decisionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public decisionHolder(generated.decision initial)
    {
        value = initial;
    }

    /**
     * Read decision from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = decisionHelper.read(istream);
    }

    /**
     * Write decision into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        decisionHelper.write(ostream,value);
    }

    /**
     * Return the decision TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return decisionHelper.type();
    }

}
