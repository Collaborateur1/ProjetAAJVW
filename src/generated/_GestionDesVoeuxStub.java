package generated;

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

    private final static Class _opsClass = generated.GestionDesVoeuxOperations.class;

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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
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
    public void inscriptionIE(String ine, generated.IEtudiant iorEtudiant)
        throws generated.DonneesInvalides
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
                    generated.IEtudiantHelper.write(_output,iorEtudiant);
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
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
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
    public generated.Formation[] rechercherFormation(String motscles)
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
                    generated.Formation[] _arg_ret = generated.seqFormationsHelper.read(_input);
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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
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
    public generated.Voeu[] chargerVoeux(String ine)
        throws generated.DonneesInvalides
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
                    generated.Voeu[] _arg_ret = generated.seqVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
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
    public generated.Voeu[] faireUnVoeu(String ine, generated.Voeu monVoeux, short ordre)
        throws generated.DonneesInvalides, generated.UtilisationInterdite
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
                    generated.VoeuHelper.write(_output,monVoeux);
                    _output.write_short(ordre);
                    _input = this._invoke(_output);
                    generated.Voeu[] _arg_ret = generated.seqVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(generated.UtilisationInterditeHelper.id()))
                    {
                        throw generated.UtilisationInterditeHelper.read(_exception.getInputStream());
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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    return _self.faireUnVoeu( ine,  monVoeux,  ordre);
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
    public void repondreAuxPropositions(String ine, generated.decision choixEtu, short numeroVoeu)
        throws generated.DonneesInvalides, generated.UtilisationInterdite
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
                    generated.decisionHelper.write(_output,choixEtu);
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
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(generated.UtilisationInterditeHelper.id()))
                    {
                        throw generated.UtilisationInterditeHelper.read(_exception.getInputStream());
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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    _self.repondreAuxPropositions( ine,  choixEtu,  numeroVoeu);
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
    public generated.Voeu[] modifierVoeu(String ine, short numeroVoeu, short ordre)
        throws generated.DonneesInvalides, generated.UtilisationInterdite
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
                    generated.Voeu[] _arg_ret = generated.seqVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(generated.UtilisationInterditeHelper.id()))
                    {
                        throw generated.UtilisationInterditeHelper.read(_exception.getInputStream());
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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    return _self.modifierVoeu( ine,  numeroVoeu,  ordre);
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
    public generated.Voeu[] supprimerVoeux(String ine, short numeroVoeu)
        throws generated.DonneesInvalides, generated.UtilisationInterdite
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
                    generated.Voeu[] _arg_ret = generated.seqVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(generated.UtilisationInterditeHelper.id()))
                    {
                        throw generated.UtilisationInterditeHelper.read(_exception.getInputStream());
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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    return _self.supprimerVoeux( ine,  numeroVoeu);
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
    public void transmettreDecisionCandidatureRectorat(String ine, generated.Voeu Reponse)
        throws generated.DonneesInvalides
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
                    generated.VoeuHelper.write(_output,Reponse);
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
                    if (_exception_id.equals(generated.DonneesInvalidesHelper.id()))
                    {
                        throw generated.DonneesInvalidesHelper.read(_exception.getInputStream());
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
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
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

    /**
     * Operation possedeVoeux
     */
    public boolean possedeVoeux(String ine)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("possedeVoeux",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("possedeVoeux",_opsClass);
                if (_so == null)
                   continue;
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    return _self.possedeVoeux( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation existFormation
     */
    public boolean existFormation(String nomFormation)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("existFormation",true);
                    _output.write_string(nomFormation);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("existFormation",_opsClass);
                if (_so == null)
                   continue;
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    return _self.existFormation( nomFormation);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation lancementVague
     */
    public void lancementVague(short numero)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("lancementVague",true);
                    _output.write_short(numero);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("lancementVague",_opsClass);
                if (_so == null)
                   continue;
                generated.GestionDesVoeuxOperations _self = (generated.GestionDesVoeuxOperations) _so.servant;
                try
                {
                    _self.lancementVague( numero);
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
