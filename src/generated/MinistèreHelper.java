package generated;

/** 
 * Helper class for : Ministère
 *  
 * @author OpenORB Compiler
 */ 
public class MinistèreHelper
{
    /**
     * Insert Ministère into an any
     * @param a an any
     * @param t Ministère value
     */
    public static void insert(org.omg.CORBA.Any a, generated.Ministère t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Ministère from an any
     * @param a an any
     * @return the extracted Ministère value
     */
    public static generated.Ministère extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return generated.MinistèreHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Ministère TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Ministère");
        }
        return _tc;
    }

    /**
     * Return the Ministère IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/Ministère:1.0";

    /**
     * Read Ministère from a marshalled stream
     * @param istream the input stream
     * @return the readed Ministère value
     */
    public static generated.Ministère read(org.omg.CORBA.portable.InputStream istream)
    {
        return(generated.Ministère)istream.read_Object(generated._MinistèreStub.class);
    }

    /**
     * Write Ministère into a marshalled stream
     * @param ostream the output stream
     * @param value Ministère value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, generated.Ministère value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Ministère
     * @param obj the CORBA Object
     * @return Ministère Object
     */
    public static Ministère narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Ministère)
            return (Ministère)obj;

        if (obj._is_a(id()))
        {
            _MinistèreStub stub = new _MinistèreStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Ministère
     * @param obj the CORBA Object
     * @return Ministère Object
     */
    public static Ministère unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Ministère)
            return (Ministère)obj;

        _MinistèreStub stub = new _MinistèreStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
