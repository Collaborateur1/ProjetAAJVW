package generated;

/**
 * Interface definition : LoadBalancerEtudiant
 * 
 * @author OpenORB Compiler
 */
public class LoadBalancerEtudiantPOATie extends LoadBalancerEtudiantPOA
{

    //
    // Private reference to implementation object
    //
    private LoadBalancerEtudiantOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public LoadBalancerEtudiantPOATie(LoadBalancerEtudiantOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public LoadBalancerEtudiantPOATie(LoadBalancerEtudiantOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public LoadBalancerEtudiantOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(LoadBalancerEtudiantOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation getProfil
     */
    public generated.GestionDesProfils getProfil(String ine)
        throws generated.DonneesInvalides
    {
        return _tie.getProfil( ine);
    }

    /**
     * Operation getServProfil
     */
    public generated.GestionDesProfils getServProfil(short num)
        throws generated.DonneesInvalides
    {
        return _tie.getServProfil( num);
    }

    /**
     * Operation inscriptionGDP
     */
    public void inscriptionGDP(generated.GestionDesProfils iorGestionDesProfils, short numero)
        throws generated.DonneesInvalides
    {
        _tie.inscriptionGDP( iorGestionDesProfils,  numero);
    }

}
