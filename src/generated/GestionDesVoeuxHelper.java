package generated;

/** 
 * Helper class for : GestionDesVoeux
 *  
 * @author OpenORB Compiler
 */ 
public class GestionDesVoeuxHelper
{
    /**
     * Insert GestionDesVoeux into an any
     * @param a an any
     * @param t GestionDesVoeux value
     */
    public static void insert(org.omg.CORBA.Any a, generated.GestionDesVoeux t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionDesVoeux from an any
     * @param a an any
     * @return the extracted GestionDesVoeux value
     */
    public static generated.GestionDesVoeux extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return generated.GestionDesVoeuxHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionDesVoeux TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionDesVoeux");
        }
        return _tc;
    }

    /**
     * Return the GestionDesVoeux IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/GestionDesVoeux:1.0";

    /**
     * Read GestionDesVoeux from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionDesVoeux value
     */
    public static generated.GestionDesVoeux read(org.omg.CORBA.portable.InputStream istream)
    {
        return(generated.GestionDesVoeux)istream.read_Object(generated._GestionDesVoeuxStub.class);
    }

    /**
     * Write GestionDesVoeux into a marshalled stream
     * @param ostream the output stream
     * @param value GestionDesVoeux value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.GestionDesVoeux value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionDesVoeux
     * @param obj the CORBA Object
     * @return GestionDesVoeux Object
     */
    public static GestionDesVoeux narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionDesVoeux)
            return (GestionDesVoeux)obj;

        if (obj._is_a(id()))
        {
            _GestionDesVoeuxStub stub = new _GestionDesVoeuxStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionDesVoeux
     * @param obj the CORBA Object
     * @return GestionDesVoeux Object
     */
    public static GestionDesVoeux unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionDesVoeux)
            return (GestionDesVoeux)obj;

        _GestionDesVoeuxStub stub = new _GestionDesVoeuxStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
