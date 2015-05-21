package PostLicence;

/**
 * Interface definition : IEtudiant
 * 
 * @author OpenORB Compiler
 */
public abstract class IEtudiantPOA extends org.omg.PortableServer.Servant
        implements IEtudiantOperations, org.omg.CORBA.portable.InvokeHandler
{
    public IEtudiant _this()
    {
        return IEtudiantHelper.narrow(_this_object());
    }

    public IEtudiant _this(org.omg.CORBA.ORB orb)
    {
        return IEtudiantHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:PostLicence/IEtudiant:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("majEtatVoeux")) {
                return _invoke_majEtatVoeux(_is, handler);
        } else if (opName.equals("notifier")) {
                return _invoke_notifier(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_notifier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        notifier(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_majEtatVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        PostLicence.Voeu[] arg0_in = PostLicence.seqVoeuxHelper.read(_is);

        majEtatVoeux(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
