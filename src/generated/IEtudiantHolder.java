package generated;

/**
 * Holder class for : IEtudiant
 * 
 * @author OpenORB Compiler
 */
final public class IEtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal IEtudiant value
     */
    public generated.IEtudiant value;

    /**
     * Default constructor
     */
    public IEtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public IEtudiantHolder(generated.IEtudiant initial)
    {
        value = initial;
    }

    /**
     * Read IEtudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = IEtudiantHelper.read(istream);
    }

    /**
     * Write IEtudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        IEtudiantHelper.write(ostream,value);
    }

    /**
     * Return the IEtudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return IEtudiantHelper.type();
    }

}
