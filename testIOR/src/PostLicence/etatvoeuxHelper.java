package PostLicence;

/** 
 * Helper class for : etatvoeux
 *  
 * @author OpenORB Compiler
 */ 
public class etatvoeuxHelper
{
    /**
     * Insert etatvoeux into an any
     * @param a an any
     * @param t etatvoeux value
     */
    public static void insert(org.omg.CORBA.Any a, PostLicence.etatvoeux t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract etatvoeux from an any
     * @param a an any
     * @return the extracted etatvoeux value
     */
    public static PostLicence.etatvoeux extract(org.omg.CORBA.Any a)
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
     * Return the etatvoeux TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[6];
            _members[0] = "soumis";
            _members[1] = "nonValide";
            _members[2] = "valide";
            _members[3] = "accepter";
            _members[4] = "refuser";
            _members[5] = "listeDattente";
            _tc = orb.create_enum_tc(id(),"etatvoeux",_members);
        }
        return _tc;
    }

    /**
     * Return the etatvoeux IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:PostLicence/etatvoeux:1.0";

    /**
     * Read etatvoeux from a marshalled stream
     * @param istream the input stream
     * @return the readed etatvoeux value
     */
    public static PostLicence.etatvoeux read(org.omg.CORBA.portable.InputStream istream)
    {
        return etatvoeux.from_int(istream.read_ulong());
    }

    /**
     * Write etatvoeux into a marshalled stream
     * @param ostream the output stream
     * @param value etatvoeux value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, PostLicence.etatvoeux value)
    {
        ostream.write_ulong(value.value());
    }

}
