package PostLicence;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public abstract class UniversitePOA extends org.omg.PortableServer.Servant
        implements UniversiteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Universite _this()
    {
        return UniversiteHelper.narrow(_this_object());
    }

    public Universite _this(org.omg.CORBA.ORB orb)
    {
        return UniversiteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:PostLicence/Universite:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_academieUniversite")) {
                return _invoke__get_academieUniversite(_is, handler);
        } else if (opName.equals("_get_nomUniversite")) {
                return _invoke__get_nomUniversite(_is, handler);
        } else if (opName.equals("_get_villeUniversite")) {
                return _invoke__get_villeUniversite(_is, handler);
        } else if (opName.equals("deliberationJury")) {
                return _invoke_deliberationJury(_is, handler);
        } else if (opName.equals("envoyerCandidature")) {
                return _invoke_envoyerCandidature(_is, handler);
        } else if (opName.equals("envoyerCandidatureD")) {
                return _invoke_envoyerCandidatureD(_is, handler);
        } else if (opName.equals("madDossier")) {
                return _invoke_madDossier(_is, handler);
        } else if (opName.equals("repondrePropositionvoeux")) {
                return _invoke_repondrePropositionvoeux(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_nomUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = nomUniversite();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_villeUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = villeUniversite();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_academieUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = academieUniversite();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_envoyerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        PostLicence.Voeu arg1_in = PostLicence.VoeuHelper.read(_is);

        try
        {
            envoyerCandidature(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (PostLicence.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            PostLicence.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_envoyerCandidatureD(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        PostLicence.dossierEtudiant arg0_in = PostLicence.dossierEtudiantHelper.read(_is);
        String arg1_in = _is.read_string();
        PostLicence.Voeu arg2_in = PostLicence.VoeuHelper.read(_is);

        try
        {
            envoyerCandidatureD(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (PostLicence.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            PostLicence.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_madDossier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        PostLicence.dossierEtudiant _arg_result = madDossier(arg0_in);

        _output = handler.createReply();
        PostLicence.dossierEtudiantHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_repondrePropositionvoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        PostLicence.Voeu arg1_in = PostLicence.VoeuHelper.read(_is);

        try
        {
            repondrePropositionvoeux(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (PostLicence.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            PostLicence.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_deliberationJury(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        deliberationJury();

        _output = handler.createReply();

        return _output;
    }

}
