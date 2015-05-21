package PostLicence;

/**
 * Interface definition : GestionDesVoeux
 * 
 * @author OpenORB Compiler
 */
public class _GestionDesVoeuxStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionDesVoeux
{
    static final String[] _ids_list =
    {
        "IDL:PostLicence/GestionDesVoeux:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = PostLicence.GestionDesVoeuxOperations.class;

    /**
     * Read accessor for numeroGDV attribute
     * @return the attribute value
     */
    public short numeroGDV()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_numeroGDV",true);
                    _input = this._invoke(_output);
                    return _input.read_short();
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_numeroGDV",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    return _self.numeroGDV();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation inscriptionIE
     */
    public void inscriptionIE(String ine, PostLicence.IEtudiant iorEtudiant)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionIE",true);
                    _output.write_string(ine);
                    PostLicence.IEtudiantHelper.write(_output,iorEtudiant);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionIE",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    _self.inscriptionIE( ine,  iorEtudiant);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation rechercherFormation
     */
    public PostLicence.Formation[] rechercherFormation(String motscles)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercherFormation",true);
                    _output.write_string(motscles);
                    _input = this._invoke(_output);
                    PostLicence.Formation[] _arg_ret = PostLicence.seqFormationsHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercherFormation",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    return _self.rechercherFormation( motscles);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation chargerVoeux
     */
    public PostLicence.Voeu[] chargerVoeux(String ine)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("chargerVoeux",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    PostLicence.Voeu[] _arg_ret = PostLicence.seqVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("chargerVoeux",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    return _self.chargerVoeux( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation faireUnVoeu
     */
    public void faireUnVoeu(String ine, PostLicence.Voeu monVoeux, short ordre)
        throws PostLicence.DonneesInvalides, PostLicence.UtilisationInterdite
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("faireUnVoeu",true);
                    _output.write_string(ine);
                    PostLicence.VoeuHelper.write(_output,monVoeux);
                    _output.write_short(ordre);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(PostLicence.UtilisationInterditeHelper.id()))
                    {
                        throw PostLicence.UtilisationInterditeHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("faireUnVoeu",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    _self.faireUnVoeu( ine,  monVoeux,  ordre);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation repondreAuxPropositions
     */
    public void repondreAuxPropositions(String ine, PostLicence.decision choixEtu)
        throws PostLicence.DonneesInvalides, PostLicence.UtilisationInterdite
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("repondreAuxPropositions",true);
                    _output.write_string(ine);
                    PostLicence.decisionHelper.write(_output,choixEtu);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(PostLicence.UtilisationInterditeHelper.id()))
                    {
                        throw PostLicence.UtilisationInterditeHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("repondreAuxPropositions",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    _self.repondreAuxPropositions( ine,  choixEtu);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierVoeu
     */
    public void modifierVoeu(String ine, short numeroVoeu, short ordre)
        throws PostLicence.DonneesInvalides, PostLicence.UtilisationInterdite
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierVoeu",true);
                    _output.write_string(ine);
                    _output.write_short(numeroVoeu);
                    _output.write_short(ordre);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(PostLicence.UtilisationInterditeHelper.id()))
                    {
                        throw PostLicence.UtilisationInterditeHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierVoeu",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    _self.modifierVoeu( ine,  numeroVoeu,  ordre);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation supprimerVoeux
     */
    public void supprimerVoeux(String ine, short numeroVoeu)
        throws PostLicence.DonneesInvalides, PostLicence.UtilisationInterdite
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerVoeux",true);
                    _output.write_string(ine);
                    _output.write_short(numeroVoeu);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(PostLicence.UtilisationInterditeHelper.id()))
                    {
                        throw PostLicence.UtilisationInterditeHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerVoeux",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    _self.supprimerVoeux( ine,  numeroVoeu);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation transmettreDecisionCandidatureRectorat
     */
    public void transmettreDecisionCandidatureRectorat(String ine, PostLicence.Voeu Reponse)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("transmettreDecisionCandidatureRectorat",true);
                    _output.write_string(ine);
                    PostLicence.VoeuHelper.write(_output,Reponse);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(PostLicence.DonneesInvalidesHelper.id()))
                    {
                        throw PostLicence.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("transmettreDecisionCandidatureRectorat",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.GestionDesVoeuxOperations _self = (PostLicence.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    _self.transmettreDecisionCandidatureRectorat( ine,  Reponse);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
