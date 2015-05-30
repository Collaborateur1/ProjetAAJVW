package generated;

/**
 * Holder class for : Ministère
 * 
 * @author OpenORB Compiler
 */
final public class MinistèreHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Ministère value
     */
    public generated.Ministère value;

    /**
     * Default constructor
     */
    public MinistèreHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MinistèreHolder(generated.Ministère initial)
    {
        value = initial;
    }

    /**
     * Read Ministère from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MinistèreHelper.read(istream);
    }

    /**
     * Write Ministère into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MinistèreHelper.write(ostream,value);
    }

    /**
     * Return the Ministère TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MinistèreHelper.type();
    }

}
