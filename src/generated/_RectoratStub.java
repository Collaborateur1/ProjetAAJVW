package generated;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class _RectoratStub extends org.omg.CORBA.portable.ObjectImpl
        implements Rectorat
{
    static final String[] _ids_list =
    {
        "IDL:PostLicence/Rectorat:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = generated.RectoratOperations.class;

    /**
     * Read accessor for nomRectorat attribute
     * @return the attribute value
     */
    public String nomRectorat()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_nomRectorat",true);
                    _input = this._invoke(_output);
                    return _input.read_string();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_nomRectorat",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    return _self.nomRectorat();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation transfertDossier
     */
    public void transfertDossier(generated.dossierEtudiant dossierEtu, generated.Voeu voeu)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("transfertDossier",true);
                    generated.dossierEtudiantHelper.write(_output,dossierEtu);
                    generated.VoeuHelper.write(_output,voeu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("transfertDossier",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.transfertDossier( dossierEtu,  voeu);
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
     * Operation envoyerListeVoeuxGDV
     */
    public void envoyerListeVoeuxGDV(generated.Voeu[] lv, generated.Etudiant etu)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("envoyerListeVoeuxGDV",true);
                    generated.seqVoeuxHelper.write(_output,lv);
                    generated.EtudiantHelper.write(_output,etu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("envoyerListeVoeuxGDV",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.envoyerListeVoeuxGDV( lv,  etu);
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
     * Operation envoyerDecisionCandidatureRectorat
     */
    public void envoyerDecisionCandidatureRectorat(String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("envoyerDecisionCandidatureRectorat",true);
                    _output.write_string(ine);
                    generated.VoeuHelper.write(_output,voeu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("envoyerDecisionCandidatureRectorat",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.envoyerDecisionCandidatureRectorat( ine,  voeu);
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
     * Operation envoyerDecisionCandidatureUniv
     */
    public void envoyerDecisionCandidatureUniv(generated.Etudiant etu, generated.Voeu voeu)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("envoyerDecisionCandidatureUniv",true);
                    generated.EtudiantHelper.write(_output,etu);
                    generated.VoeuHelper.write(_output,voeu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("envoyerDecisionCandidatureUniv",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.envoyerDecisionCandidatureUniv( etu,  voeu);
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
     * Operation inscriptionUniv
     */
    public void inscriptionUniv(generated.Universite iorLUniversite, String nomUniv)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionUniv",true);
                    generated.UniversiteHelper.write(_output,iorLUniversite);
                    _output.write_string(nomUniv);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionUniv",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.inscriptionUniv( iorLUniversite,  nomUniv);
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
     * Operation inscriptionGDV
     */
    public void inscriptionGDV(generated.GestionDesVoeux Gdv)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionGDV",true);
                    generated.GestionDesVoeuxHelper.write(_output,Gdv);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionGDV",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.inscriptionGDV( Gdv);
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
     * Operation repondrePropositionVoeux
     */
    public void repondrePropositionVoeux(String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("repondrePropositionVoeux",true);
                    _output.write_string(ine);
                    generated.VoeuHelper.write(_output,voeu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("repondrePropositionVoeux",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.repondrePropositionVoeux( ine,  voeu);
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
     * Operation deliberationJury
     */
    public void deliberationJury()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("deliberationJury",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deliberationJury",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.deliberationJury();
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
     * Operation getFicheEtudiant
     */
    public generated.Etudiant getFicheEtudiant(String ine)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getFicheEtudiant",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    generated.Etudiant _arg_ret = generated.EtudiantHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getFicheEtudiant",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    return _self.getFicheEtudiant( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajoutPrerequis
     */
    public void ajoutPrerequis(String nomFormation, String[] prerequis)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajoutPrerequis",true);
                    _output.write_string(nomFormation);
                    generated.ListePrerequisHelper.write(_output,prerequis);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajoutPrerequis",_opsClass);
                if (_so == null)
                   continue;
                generated.RectoratOperations _self = (generated.RectoratOperations) _so.servant;
                try
                {
                    _self.ajoutPrerequis( nomFormation,  prerequis);
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
