package PostLicence;

/** 
 * Helper class for : LoadBalancerEtudiant
 *  
 * @author OpenORB Compiler
 */ 
public class LoadBalancerEtudiantHelper
{
    /**
     * Insert LoadBalancerEtudiant into an any
     * @param a an any
     * @param t LoadBalancerEtudiant value
     */
    public static void insert(org.omg.CORBA.Any a, PostLicence.LoadBalancerEtudiant t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract LoadBalancerEtudiant from an any
     * @param a an any
     * @return the extracted LoadBalancerEtudiant value
     */
    public static PostLicence.LoadBalancerEtudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return PostLicence.LoadBalancerEtudiantHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the LoadBalancerEtudiant TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"LoadBalancerEtudiant");
        }
        return _tc;
    }

    /**
     * Return the LoadBalancerEtudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/LoadBalancerEtudiant:1.0";

    /**
     * Read LoadBalancerEtudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed LoadBalancerEtudiant value
     */
    public static PostLicence.LoadBalancerEtudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        return(PostLicence.LoadBalancerEtudiant)istream.read_Object(PostLicence._LoadBalancerEtudiantStub.class);
    }

    /**
     * Write LoadBalancerEtudiant into a marshalled stream
     * @param ostream the output stream
     * @param value LoadBalancerEtudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, PostLicence.LoadBalancerEtudiant value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to LoadBalancerEtudiant
     * @param obj the CORBA Object
     * @return LoadBalancerEtudiant Object
     */
    public static LoadBalancerEtudiant narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof LoadBalancerEtudiant)
            return (LoadBalancerEtudiant)obj;

        if (obj._is_a(id()))
        {
            _LoadBalancerEtudiantStub stub = new _LoadBalancerEtudiantStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to LoadBalancerEtudiant
     * @param obj the CORBA Object
     * @return LoadBalancerEtudiant Object
     */
    public static LoadBalancerEtudiant unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof LoadBalancerEtudiant)
            return (LoadBalancerEtudiant)obj;

        _LoadBalancerEtudiantStub stub = new _LoadBalancerEtudiantStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
