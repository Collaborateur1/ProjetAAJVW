package PostLicence;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public class _UniversiteStub extends org.omg.CORBA.portable.ObjectImpl
        implements Universite
{
    static final String[] _ids_list =
    {
        "IDL:PostLicence/Universite:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = PostLicence.UniversiteOperations.class;

    /**
     * Read accessor for nomUniversite attribute
     * @return the attribute value
     */
    public String nomUniversite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_nomUniversite",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_nomUniversite",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.UniversiteOperations _self = (PostLicence.UniversiteOperations) _so.servant;
                try
                {
                    return _self.nomUniversite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for villeUniversite attribute
     * @return the attribute value
     */
    public String villeUniversite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_villeUniversite",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_villeUniversite",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.UniversiteOperations _self = (PostLicence.UniversiteOperations) _so.servant;
                try
                {
                    return _self.villeUniversite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for academieUniversite attribute
     * @return the attribute value
     */
    public String academieUniversite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_academieUniversite",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_academieUniversite",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.UniversiteOperations _self = (PostLicence.UniversiteOperations) _so.servant;
                try
                {
                    return _self.academieUniversite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation envoyerCandidature
     */
    public void envoyerCandidature(String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("envoyerCandidature",true);
                    _output.write_string(ine);
                    PostLicence.VoeuHelper.write(_output,voeu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("envoyerCandidature",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.UniversiteOperations _self = (PostLicence.UniversiteOperations) _so.servant;
                try
                {
                    _self.envoyerCandidature( ine,  voeu);
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
     * Operation envoyerCandidatureD
     */
    public void envoyerCandidatureD(PostLicence.dossierEtudiant dossierEtu, String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("envoyerCandidatureD",true);
                    PostLicence.dossierEtudiantHelper.write(_output,dossierEtu);
                    _output.write_string(ine);
                    PostLicence.VoeuHelper.write(_output,voeu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("envoyerCandidatureD",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.UniversiteOperations _self = (PostLicence.UniversiteOperations) _so.servant;
                try
                {
                    _self.envoyerCandidatureD( dossierEtu,  ine,  voeu);
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
     * Operation madDossier
     */
    public PostLicence.dossierEtudiant madDossier(String ine)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("madDossier",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    PostLicence.dossierEtudiant _arg_ret = PostLicence.dossierEtudiantHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("madDossier",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.UniversiteOperations _self = (PostLicence.UniversiteOperations) _so.servant;
                try
                {
                    return _self.madDossier( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation repondrePropositionvoeux
     */
    public void repondrePropositionvoeux(String ine, PostLicence.Voeu voeu)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("repondrePropositionvoeux",true);
                    _output.write_string(ine);
                    PostLicence.VoeuHelper.write(_output,voeu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("repondrePropositionvoeux",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.UniversiteOperations _self = (PostLicence.UniversiteOperations) _so.servant;
                try
                {
                    _self.repondrePropositionvoeux( ine,  voeu);
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
                PostLicence.UniversiteOperations _self = (PostLicence.UniversiteOperations) _so.servant;
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

}
