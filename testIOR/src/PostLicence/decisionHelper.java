package PostLicence;

/** 
 * Helper class for : decision
 *  
 * @author OpenORB Compiler
 */ 
public class decisionHelper
{
    /**
     * Insert decision into an any
     * @param a an any
     * @param t decision value
     */
    public static void insert(org.omg.CORBA.Any a, PostLicence.decision t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract decision from an any
     * @param a an any
     * @return the extracted decision value
     */
    public static PostLicence.decision extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the decision TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "OUIdefinitif";
            _members[1] = "OUImais";
            _members[2] = "NONdefinitif";
            _members[3] = "NONmais";
            _tc = orb.create_enum_tc(id(),"decision",_members);
        }
        return _tc;
    }

    /**
     * Return the decision IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/decision:1.0";

    /**
     * Read decision from a marshalled stream
     * @param istream the input stream
     * @return the readed decision value
     */
    public static PostLicence.decision read(org.omg.CORBA.portable.InputStream istream)
    {
        return decision.from_int(istream.read_ulong());
    }

    /**
     * Write decision into a marshalled stream
     * @param ostream the output stream
     * @param value decision value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, PostLicence.decision value)
    {
        ostream.write_ulong(value.value());
    }

}
