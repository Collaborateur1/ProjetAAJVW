package generated;

/**
 * Interface definition : GestionDesVoeux
 * 
 * @author OpenORB Compiler
 */
public interface GestionDesVoeuxOperations
{
    /**
     * Read accessor for numeroGDV attribute
     * @return the attribute value
     */
    public short numeroGDV();

    /**
     * Operation inscriptionIE
     */
    public void inscriptionIE(String ine, generated.IEtudiant iorEtudiant)
        throws generated.DonneesInvalides;

    /**
     * Operation rechercherFormation
     */
    public generated.Formation[] rechercherFormation(String motscles);

    /**
     * Operation chargerVoeux
     */
    public generated.Voeu[] chargerVoeux(String ine)
        throws generated.DonneesInvalides;

    /**
     * Operation faireUnVoeu
     */
    public void faireUnVoeu(String ine, generated.Voeu monVoeux, short ordre)
        throws generated.DonneesInvalides, generated.UtilisationInterdite;

    /**
     * Operation repondreAuxPropositions
     */
    public void repondreAuxPropositions(String ine, generated.decision choixEtu)
        throws generated.DonneesInvalides, generated.UtilisationInterdite;

    /**
     * Operation modifierVoeu
     */
    public void modifierVoeu(String ine, short numeroVoeu, short ordre)
        throws generated.DonneesInvalides, generated.UtilisationInterdite;

    /**
     * Operation supprimerVoeux
     */
    public void supprimerVoeux(String ine, short numeroVoeu)
        throws generated.DonneesInvalides, generated.UtilisationInterdite;

    /**
     * Operation transmettreDecisionCandidatureRectorat
     */
    public void transmettreDecisionCandidatureRectorat(String ine, generated.Voeu Reponse)
        throws generated.DonneesInvalides;

}
