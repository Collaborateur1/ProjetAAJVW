package generated;

/** 
 * Helper class for : GestionDesProfils
 *  
 * @author OpenORB Compiler
 */ 
public class GestionDesProfilsHelper
{
    /**
     * Insert GestionDesProfils into an any
     * @param a an any
     * @param t GestionDesProfils value
     */
    public static void insert(org.omg.CORBA.Any a, generated.GestionDesProfils t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionDesProfils from an any
     * @param a an any
     * @return the extracted GestionDesProfils value
     */
    public static generated.GestionDesProfils extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return generated.GestionDesProfilsHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionDesProfils TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionDesProfils");
        }
        return _tc;
    }

    /**
     * Return the GestionDesProfils IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/GestionDesProfils:1.0";

    /**
     * Read GestionDesProfils from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionDesProfils value
     */
    public static generated.GestionDesProfils read(org.omg.CORBA.portable.InputStream istream)
    {
        return(generated.GestionDesProfils)istream.read_Object(generated._GestionDesProfilsStub.class);
    }

    /**
     * Write GestionDesProfils into a marshalled stream
     * @param ostream the output stream
     * @param value GestionDesProfils value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.GestionDesProfils value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionDesProfils
     * @param obj the CORBA Object
     * @return GestionDesProfils Object
     */
    public static GestionDesProfils narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionDesProfils)
            return (GestionDesProfils)obj;

        if (obj._is_a(id()))
        {
            _GestionDesProfilsStub stub = new _GestionDesProfilsStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionDesProfils
     * @param obj the CORBA Object
     * @return GestionDesProfils Object
     */
    public static GestionDesProfils unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionDesProfils)
            return (GestionDesProfils)obj;

        _GestionDesProfilsStub stub = new _GestionDesProfilsStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
