package generated;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class RectoratPOATie extends RectoratPOA
{

    //
    // Private reference to implementation object
    //
    private RectoratOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public RectoratOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(RectoratOperations delegate_)
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
     * Read accessor for nomRectorat attribute
     */
    public String nomRectorat()
    {
        return _tie.nomRectorat();
    }

    /**
     * Operation transfertDossier
     */
    public void transfertDossier(generated.dossierEtudiant dossierEtu, generated.Voeu voeu)
    {
        _tie.transfertDossier( dossierEtu,  voeu);
    }

    /**
     * Operation envoyerListeVoeuxGDV
     */
    public void envoyerListeVoeuxGDV(generated.Voeu[] lv, generated.Etudiant etu)
        throws generated.DonneesInvalides
    {
        _tie.envoyerListeVoeuxGDV( lv,  etu);
    }

    /**
     * Operation envoyerDecisionCandidatureRectorat
     */
    public void envoyerDecisionCandidatureRectorat(String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides
    {
        _tie.envoyerDecisionCandidatureRectorat( ine,  voeu);
    }

    /**
     * Operation envoyerDecisionCandidatureUniv
     */
    public void envoyerDecisionCandidatureUniv(generated.Etudiant etu, generated.Voeu voeu)
        throws generated.DonneesInvalides
    {
        _tie.envoyerDecisionCandidatureUniv( etu,  voeu);
    }

    /**
     * Operation inscriptionUniv
     */
    public void inscriptionUniv(generated.Universite iorLUniversite, String nomUniv)
    {
        _tie.inscriptionUniv( iorLUniversite,  nomUniv);
    }

    /**
     * Operation inscriptionGDV
     */
    public void inscriptionGDV(short numeroGDV, generated.GestionDesVoeux Gdv)
    {
        _tie.inscriptionGDV( numeroGDV,  Gdv);
    }

    /**
     * Operation repondrePropositionVoeux
     */
    public void repondrePropositionVoeux(String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides
    {
        _tie.repondrePropositionVoeux( ine,  voeu);
    }

    /**
     * Operation deliberationJury
     */
    public void deliberationJury()
    {
        _tie.deliberationJury();
    }

    /**
     * Operation deliberationJuryFinal
     */
    public void deliberationJuryFinal()
    {
        _tie.deliberationJuryFinal();
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
     * Operation ajoutPrerequis
     */
    public void ajoutPrerequis(generated.Formation formation, String[] prerequis)
    {
        _tie.ajoutPrerequis( formation,  prerequis);
    }

}
