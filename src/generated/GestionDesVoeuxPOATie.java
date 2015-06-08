package generated;

/**
 * Interface definition : GestionDesVoeux
 * 
 * @author OpenORB Compiler
 */
public class GestionDesVoeuxPOATie extends GestionDesVoeuxPOA
{

    //
    // Private reference to implementation object
    //
    private GestionDesVoeuxOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionDesVoeuxPOATie(GestionDesVoeuxOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionDesVoeuxPOATie(GestionDesVoeuxOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionDesVoeuxOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionDesVoeuxOperations delegate_)
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
     * Read accessor for numeroGDV attribute
     */
    public short numeroGDV()
    {
        return _tie.numeroGDV();
    }

    /**
     * Operation inscriptionIE
     */
    public void inscriptionIE(String ine, generated.IEtudiant iorEtudiant)
        throws generated.DonneesInvalides
    {
        _tie.inscriptionIE( ine,  iorEtudiant);
    }

    /**
     * Operation rechercherFormation
     */
    public generated.Formation[] rechercherFormation(String motscles)
    {
        return _tie.rechercherFormation( motscles);
    }

    /**
     * Operation chargerVoeux
     */
    public generated.Voeu[] chargerVoeux(String ine)
        throws generated.DonneesInvalides
    {
        return _tie.chargerVoeux( ine);
    }

    /**
     * Operation faireUnVoeu
     */
    public generated.Voeu[] faireUnVoeu(String ine, generated.Voeu monVoeux, short ordre)
        throws generated.DonneesInvalides, generated.UtilisationInterdite
    {
        return _tie.faireUnVoeu( ine,  monVoeux,  ordre);
    }

    /**
     * Operation repondreAuxPropositions
     */
    public void repondreAuxPropositions(String ine, generated.decision choixEtu, short numeroVoeu)
        throws generated.DonneesInvalides, generated.UtilisationInterdite
    {
        _tie.repondreAuxPropositions( ine,  choixEtu,  numeroVoeu);
    }

    /**
     * Operation modifierVoeu
     */
    public void modifierVoeu(String ine, short numeroVoeu, short ordre)
        throws generated.DonneesInvalides, generated.UtilisationInterdite
    {
        _tie.modifierVoeu( ine,  numeroVoeu,  ordre);
    }

    /**
     * Operation supprimerVoeux
     */
    public void supprimerVoeux(String ine, short numeroVoeu)
        throws generated.DonneesInvalides, generated.UtilisationInterdite
    {
        _tie.supprimerVoeux( ine,  numeroVoeu);
    }

    /**
     * Operation transmettreDecisionCandidatureRectorat
     */
    public void transmettreDecisionCandidatureRectorat(String ine, generated.Voeu Reponse)
        throws generated.DonneesInvalides
    {
        _tie.transmettreDecisionCandidatureRectorat( ine,  Reponse);
    }

    /**
     * Operation possedeVoeux
     */
    public boolean possedeVoeux(String ine)
    {
        return _tie.possedeVoeux( ine);
    }

}
