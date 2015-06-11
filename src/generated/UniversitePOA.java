package generated;

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

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_academieUniversite",
                    new Operation__get_academieUniversite());
            operationMap.put("_get_nomUniversite",
                    new Operation__get_nomUniversite());
            operationMap.put("_get_villeUniversite",
                    new Operation__get_villeUniversite());
            operationMap.put("deliberationFinal",
                    new Operation_deliberationFinal());
            operationMap.put("deliberationJury",
                    new Operation_deliberationJury());
            operationMap.put("envoyerCandidature",
                    new Operation_envoyerCandidature());
            operationMap.put("envoyerCandidatureD",
                    new Operation_envoyerCandidatureD());
            operationMap.put("estEtudiant",
                    new Operation_estEtudiant());
            operationMap.put("getFicheEtudiant",
                    new Operation_getFicheEtudiant());
            operationMap.put("madDossier",
                    new Operation_madDossier());
            operationMap.put("repondrePropositionvoeux",
                    new Operation_repondrePropositionvoeux());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
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
        generated.Voeu arg1_in = generated.VoeuHelper.read(_is);

        try
        {
            envoyerCandidature(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_envoyerCandidatureD(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.dossierEtudiant arg0_in = generated.dossierEtudiantHelper.read(_is);
        String arg1_in = _is.read_string();
        generated.Voeu arg2_in = generated.VoeuHelper.read(_is);

        try
        {
            envoyerCandidatureD(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_madDossier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        generated.dossierEtudiant _arg_result = madDossier(arg0_in);

        _output = handler.createReply();
        generated.dossierEtudiantHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_repondrePropositionvoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.Voeu arg1_in = generated.VoeuHelper.read(_is);

        try
        {
            repondrePropositionvoeux(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getFicheEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            generated.Etudiant _arg_result = getFicheEtudiant(arg0_in);

            _output = handler.createReply();
            generated.EtudiantHelper.write(_output,_arg_result);

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_estEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = estEtudiant(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

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

    private org.omg.CORBA.portable.OutputStream _invoke_deliberationFinal(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        deliberationFinal();

        _output = handler.createReply();

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                UniversitePOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_nomUniversite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_nomUniversite(_is, handler);
        }
    }

    private static final class Operation__get_villeUniversite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_villeUniversite(_is, handler);
        }
    }

    private static final class Operation__get_academieUniversite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_academieUniversite(_is, handler);
        }
    }

    private static final class Operation_envoyerCandidature extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_envoyerCandidature(_is, handler);
        }
    }

    private static final class Operation_envoyerCandidatureD extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_envoyerCandidatureD(_is, handler);
        }
    }

    private static final class Operation_madDossier extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_madDossier(_is, handler);
        }
    }

    private static final class Operation_repondrePropositionvoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_repondrePropositionvoeux(_is, handler);
        }
    }

    private static final class Operation_getFicheEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getFicheEtudiant(_is, handler);
        }
    }

    private static final class Operation_estEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_estEtudiant(_is, handler);
        }
    }

    private static final class Operation_deliberationJury extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_deliberationJury(_is, handler);
        }
    }

    private static final class Operation_deliberationFinal extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_deliberationFinal(_is, handler);
        }
    }

}
