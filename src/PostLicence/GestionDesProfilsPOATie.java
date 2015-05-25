package PostLicence;

/**
 * Interface definition : GestionDesProfils
 * 
 * @author OpenORB Compiler
 */
public class GestionDesProfilsPOATie extends GestionDesProfilsPOA
{

    //
    // Private reference to implementation object
    //
    private GestionDesProfilsOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionDesProfilsPOATie(GestionDesProfilsOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionDesProfilsPOATie(GestionDesProfilsOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionDesProfilsOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionDesProfilsOperations delegate_)
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
     * Read accessor for numeroGDP attribute
     */
    public short numeroGDP()
    {
        return _tie.numeroGDP();
    }

    /**
     * Operation connexion
     */
    public PostLicence.GestionDesVoeux connexion(PostLicence.IEtudiant iorEtudiant, String ine, String mdp)
        throws PostLicence.DonneesInvalides
    {
        return _tie.connexion( iorEtudiant,  ine,  mdp);
    }

    /**
     * Operation consulterProfil
     */
    public PostLicence.Etudiant consulterProfil(String ine)
        throws PostLicence.DonneesInvalides
    {
        return _tie.consulterProfil( ine);
    }

    /**
     * Operation modifierProfil
     */
    public void modifierProfil(String ine, String adr)
        throws PostLicence.DonneesInvalides
    {
        _tie.modifierProfil( ine,  adr);
    }

    /**
     * Operation inscriptionGestionDesVoeux
     */
    public void inscriptionGestionDesVoeux(PostLicence.GestionDesVoeux GDesVx)
    {
        _tie.inscriptionGestionDesVoeux( GDesVx);
    }

}
