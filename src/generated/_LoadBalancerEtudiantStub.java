package generated;

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

    private final static Class _opsClass = generated.LoadBalancerEtudiantOperations.class;

    /**
     * Operation getProfil
     */
    public generated.GestionDesProfils getProfil(String ine)
        throws generated.DonneesInvalides
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
                    generated.GestionDesProfils _arg_ret = generated.GestionDesProfilsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getProfil",_opsClass);
                if (_so == null)
                   continue;
                generated.LoadBalancerEtudiantOperations _self = (generated.LoadBalancerEtudiantOperations) _so.servant;
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
    public generated.GestionDesProfils getServProfil(short num)
        throws generated.DonneesInvalides
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
                    generated.GestionDesProfils _arg_ret = generated.GestionDesProfilsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getServProfil",_opsClass);
                if (_so == null)
                   continue;
                generated.LoadBalancerEtudiantOperations _self = (generated.LoadBalancerEtudiantOperations) _so.servant;
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
    public void inscriptionGDP(generated.GestionDesProfils iorGestionDesProfils, short numero)
        throws generated.DonneesInvalides
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionGDP",true);
                    generated.GestionDesProfilsHelper.write(_output,iorGestionDesProfils);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionGDP",_opsClass);
                if (_so == null)
                   continue;
                generated.LoadBalancerEtudiantOperations _self = (generated.LoadBalancerEtudiantOperations) _so.servant;
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

    /**
     * Operation getAllGDP
     */
    public generated.GestionDesProfils[] getAllGDP()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getAllGDP",true);
                    _input = this._invoke(_output);
                    generated.GestionDesProfils[] _arg_ret = generated.seqGDPHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAllGDP",_opsClass);
                if (_so == null)
                   continue;
                generated.LoadBalancerEtudiantOperations _self = (generated.LoadBalancerEtudiantOperations) _so.servant;
                try
                {
                    return _self.getAllGDP();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
