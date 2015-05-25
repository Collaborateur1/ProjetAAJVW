package PostLicence;

/**
 * Interface definition : LoadBalancerEtudiant
 * 
 * @author OpenORB Compiler
 */
public class _LoadBalancerEtudiantStub extends org.omg.CORBA.portable.ObjectImpl
        implements LoadBalancerEtudiant
{
    static final String[] _ids_list =
    {
        "IDL:PostLicence/LoadBalancerEtudiant:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = PostLicence.LoadBalancerEtudiantOperations.class;

    /**
     * Operation getProfil
     */
    public PostLicence.GestionDesProfils getProfil(String ine)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getProfil",true);
                    _output.write_string(ine);
                    _input = this._invoke(_output);
                    PostLicence.GestionDesProfils _arg_ret = PostLicence.GestionDesProfilsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getProfil",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.LoadBalancerEtudiantOperations _self = (PostLicence.LoadBalancerEtudiantOperations) _so.servant;
                try
                {
                    return _self.getProfil( ine);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getServProfil
     */
    public PostLicence.GestionDesProfils getServProfil(short num)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getServProfil",true);
                    _output.write_short(num);
                    _input = this._invoke(_output);
                    PostLicence.GestionDesProfils _arg_ret = PostLicence.GestionDesProfilsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getServProfil",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.LoadBalancerEtudiantOperations _self = (PostLicence.LoadBalancerEtudiantOperations) _so.servant;
                try
                {
                    return _self.getServProfil( num);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation inscriptionGDP
     */
    public void inscriptionGDP(PostLicence.GestionDesProfils iorGestionDesProfils, short numero)
        throws PostLicence.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionGDP",true);
                    PostLicence.GestionDesProfilsHelper.write(_output,iorGestionDesProfils);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionGDP",_opsClass);
                if (_so == null)
                   continue;
                PostLicence.LoadBalancerEtudiantOperations _self = (PostLicence.LoadBalancerEtudiantOperations) _so.servant;
                try
                {
                    _self.inscriptionGDP( iorGestionDesProfils,  numero);
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
