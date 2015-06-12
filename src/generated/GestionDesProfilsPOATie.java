package generated;

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
    public generated.GestionDesVoeux connexion(generated.IEtudiant iorEtudiant, String ine, String mdp)
        throws generated.DonneesInvalides
    {
        return _tie.connexion( iorEtudiant,  ine,  mdp);
    }

    /**
     * Operation consulterProfil
     */
    public generated.Etudiant consulterProfil(String ine)
        throws generated.DonneesInvalides
    {
        return _tie.consulterProfil( ine);
    }

    /**
     * Operation modifierProfil
     */
    public void modifierProfil(String ine, String adr)
        throws generated.DonneesInvalides
    {
        _tie.modifierProfil( ine,  adr);
    }

    /**
     * Operation inscriptionGestionDesVoeux
     */
    public void inscriptionGestionDesVoeux(generated.GestionDesVoeux GDesVx)
    {
        _tie.inscriptionGestionDesVoeux( GDesVx);
    }

    /**
     * Operation etudiantInscrit
     */
    public boolean etudiantInscrit(String ine)
        throws generated.DonneesInvalides
    {
        return _tie.etudiantInscrit( ine);
    }

    /**
     * Operation getFicheEtudiant
     */
    public generated.Etudiant getFicheEtudiant(String ine)
        throws generated.DonneesInvalides
    {
        return _tie.getFicheEtudiant( ine);
    }

    /**
     * Operation autorisationConnexion
     */
    public boolean autorisationConnexion(String ine, String mdp)
        throws generated.DonneesInvalides
    {
        return _tie.autorisationConnexion( ine,  mdp);
    }

    /**
     * Operation inscriptionEtudiant
     */
    public boolean inscriptionEtudiant(String ine, String mdp)
        throws generated.DonneesInvalides
    {
        return _tie.inscriptionEtudiant( ine,  mdp);
    }

    /**
     * Operation getGDV
     */
    public generated.GestionDesVoeux getGDV()
    {
        return _tie.getGDV();
    }

}
