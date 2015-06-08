package generated;

/** 
 * Helper class for : IEtudiant
 *  
 * @author OpenORB Compiler
 */ 
public class IEtudiantHelper
{
    /**
     * Insert IEtudiant into an any
     * @param a an any
     * @param t IEtudiant value
     */
    public static void insert(org.omg.CORBA.Any a, generated.IEtudiant t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract IEtudiant from an any
     * @param a an any
     * @return the extracted IEtudiant value
     */
    public static generated.IEtudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return generated.IEtudiantHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the IEtudiant TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"IEtudiant");
        }
        return _tc;
    }

    /**
     * Return the IEtudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/IEtudiant:1.0";

    /**
     * Read IEtudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed IEtudiant value
     */
    public static generated.IEtudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        return(generated.IEtudiant)istream.read_Object(generated._IEtudiantStub.class);
    }

    /**
     * Write IEtudiant into a marshalled stream
     * @param ostream the output stream
     * @param value IEtudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.IEtudiant value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to IEtudiant
     * @param obj the CORBA Object
     * @return IEtudiant Object
     */
    public static IEtudiant narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof IEtudiant)
            return (IEtudiant)obj;

        if (obj._is_a(id()))
        {
            _IEtudiantStub stub = new _IEtudiantStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to IEtudiant
     * @param obj the CORBA Object
     * @return IEtudiant Object
     */
    public static IEtudiant unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof IEtudiant)
            return (IEtudiant)obj;

        _IEtudiantStub stub = new _IEtudiantStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
