package generated;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Read accessor for nomRectorat attribute
     * @return the attribute value
     */
    public String nomRectorat();

    /**
     * Operation transfertDossier
     */
    public void transfertDossier(generated.dossierEtudiant dossierEtu, generated.Voeu voeu);

    /**
     * Operation envoyerListeVoeuxGDV
     */
    public void envoyerListeVoeuxGDV(generated.Voeu[] lv, generated.Etudiant etu)
        throws generated.DonneesInvalides;

    /**
     * Operation envoyerDecisionCandidatureRectorat
     */
    public void envoyerDecisionCandidatureRectorat(String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides;

    /**
     * Operation envoyerDecisionCandidatureUniv
     */
    public void envoyerDecisionCandidatureUniv(generated.Etudiant etu, generated.Voeu voeu)
        throws generated.DonneesInvalides;

    /**
     * Operation inscriptionUniv
     */
    public void inscriptionUniv(generated.Universite iorLUniversite);

    /**
     * Operation inscriptionGDV
     */
    public void inscriptionGDV(generated.GestionDesVoeux Gdv);

    /**
     * Operation repondrePropositionVoeux
     */
    public void repondrePropositionVoeux(String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides;

    /**
     * Operation deliberationJury
     */
    public void deliberationJury();

}
