package generated;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public abstract class RectoratPOA extends org.omg.PortableServer.Servant
        implements RectoratOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Rectorat _this()
    {
        return RectoratHelper.narrow(_this_object());
    }

    public Rectorat _this(org.omg.CORBA.ORB orb)
    {
        return RectoratHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:PostLicence/Rectorat:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_nomRectorat",
                    new Operation__get_nomRectorat());
            operationMap.put("deliberationJury",
                    new Operation_deliberationJury());
            operationMap.put("envoyerDecisionCandidatureRectorat",
                    new Operation_envoyerDecisionCandidatureRectorat());
            operationMap.put("envoyerDecisionCandidatureUniv",
                    new Operation_envoyerDecisionCandidatureUniv());
            operationMap.put("envoyerListeVoeuxGDV",
                    new Operation_envoyerListeVoeuxGDV());
            operationMap.put("getFicheEtudiant",
                    new Operation_getFicheEtudiant());
            operationMap.put("inscriptionGDV",
                    new Operation_inscriptionGDV());
            operationMap.put("inscriptionUniv",
                    new Operation_inscriptionUniv());
            operationMap.put("repondrePropositionVoeux",
                    new Operation_repondrePropositionVoeux());
            operationMap.put("transfertDossier",
                    new Operation_transfertDossier());
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
    private org.omg.CORBA.portable.OutputStream _invoke__get_nomRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = nomRectorat();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_transfertDossier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.dossierEtudiant arg0_in = generated.dossierEtudiantHelper.read(_is);
        generated.Voeu arg1_in = generated.VoeuHelper.read(_is);

        transfertDossier(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_envoyerListeVoeuxGDV(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.Voeu[] arg0_in = generated.seqVoeuxHelper.read(_is);
        generated.Etudiant arg1_in = generated.EtudiantHelper.read(_is);

        try
        {
            envoyerListeVoeuxGDV(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_envoyerDecisionCandidatureRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.Voeu arg1_in = generated.VoeuHelper.read(_is);

        try
        {
            envoyerDecisionCandidatureRectorat(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_envoyerDecisionCandidatureUniv(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.Etudiant arg0_in = generated.EtudiantHelper.read(_is);
        generated.Voeu arg1_in = generated.VoeuHelper.read(_is);

        try
        {
            envoyerDecisionCandidatureUniv(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionUniv(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.Universite arg0_in = generated.UniversiteHelper.read(_is);
        String arg1_in = _is.read_string();

        inscriptionUniv(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionGDV(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        generated.GestionDesVoeux arg0_in = generated.GestionDesVoeuxHelper.read(_is);

        inscriptionGDV(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_repondrePropositionVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        generated.Voeu arg1_in = generated.VoeuHelper.read(_is);

        try
        {
            repondrePropositionVoeux(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (generated.DonneesInvalides _exception)
        {
            _output = handler.createExceptionReply();
            generated.DonneesInvalidesHelper.write(_output,_exception);
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

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                RectoratPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_nomRectorat extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_nomRectorat(_is, handler);
        }
    }

    private static final class Operation_transfertDossier extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_transfertDossier(_is, handler);
        }
    }

    private static final class Operation_envoyerListeVoeuxGDV extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_envoyerListeVoeuxGDV(_is, handler);
        }
    }

    private static final class Operation_envoyerDecisionCandidatureRectorat extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_envoyerDecisionCandidatureRectorat(_is, handler);
        }
    }

    private static final class Operation_envoyerDecisionCandidatureUniv extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_envoyerDecisionCandidatureUniv(_is, handler);
        }
    }

    private static final class Operation_inscriptionUniv extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_inscriptionUniv(_is, handler);
        }
    }

    private static final class Operation_inscriptionGDV extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_inscriptionGDV(_is, handler);
        }
    }

    private static final class Operation_repondrePropositionVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_repondrePropositionVoeux(_is, handler);
        }
    }

    private static final class Operation_deliberationJury extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_deliberationJury(_is, handler);
        }
    }

    private static final class Operation_getFicheEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getFicheEtudiant(_is, handler);
        }
    }

}
