package generated;

/** 
 * Helper class for : Minist�re
 *  
 * @author OpenORB Compiler
 */ 
public class Minist�reHelper
{
    /**
     * Insert Minist�re into an any
     * @param a an any
     * @param t Minist�re value
     */
    public static void insert(org.omg.CORBA.Any a, generated.Minist�re t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Minist�re from an any
     * @param a an any
     * @return the extracted Minist�re value
     */
    public static generated.Minist�re extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return generated.Minist�reHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Minist�re TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Minist�re");
        }
        return _tc;
    }

    /**
     * Return the Minist�re IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/Minist�re:1.0";

    /**
     * Read Minist�re from a marshalled stream
     * @param istream the input stream
     * @return the readed Minist�re value
     */
    public static generated.Minist�re read(org.omg.CORBA.portable.InputStream istream)
    {
        return(generated.Minist�re)istream.read_Object(generated._Minist�reStub.class);
    }

    /**
     * Write Minist�re into a marshalled stream
     * @param ostream the output stream
     * @param value Minist�re value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.Minist�re value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Minist�re
     * @param obj the CORBA Object
     * @return Minist�re Object
     */
    public static Minist�re narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Minist�re)
            return (Minist�re)obj;

        if (obj._is_a(id()))
        {
            _Minist�reStub stub = new _Minist�reStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Minist�re
     * @param obj the CORBA Object
     * @return Minist�re Object
     */
    public static Minist�re unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Minist�re)
            return (Minist�re)obj;

        _Minist�reStub stub = new _Minist�reStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
