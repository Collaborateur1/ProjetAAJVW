package generated;

/**
 * Holder class for : LoadBalancerEtudiant
 * 
 * @author OpenORB Compiler
 */
final public class LoadBalancerEtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LoadBalancerEtudiant value
     */
    public generated.LoadBalancerEtudiant value;

    /**
     * Default constructor
     */
    public LoadBalancerEtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LoadBalancerEtudiantHolder(generated.LoadBalancerEtudiant initial)
    {
        value = initial;
    }

    /**
     * Read LoadBalancerEtudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LoadBalancerEtudiantHelper.read(istream);
    }

    /**
     * Write LoadBalancerEtudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LoadBalancerEtudiantHelper.write(ostream,value);
    }

    /**
     * Return the LoadBalancerEtudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LoadBalancerEtudiantHelper.type();
    }

}
