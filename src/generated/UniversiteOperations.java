package generated;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public interface UniversiteOperations
{
    /**
     * Read accessor for nomUniversite attribute
     * @return the attribute value
     */
    public String nomUniversite();

    /**
     * Read accessor for villeUniversite attribute
     * @return the attribute value
     */
    public String villeUniversite();

    /**
     * Read accessor for academieUniversite attribute
     * @return the attribute value
     */
    public String academieUniversite();

    /**
     * Operation envoyerCandidature
     */
    public void envoyerCandidature(String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides;

    /**
     * Operation envoyerCandidatureD
     */
    public void envoyerCandidatureD(generated.dossierEtudiant dossierEtu, String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides;

    /**
     * Operation madDossier
     */
    public generated.dossierEtudiant madDossier(String ine);

    /**
     * Operation repondrePropositionvoeux
     */
    public void repondrePropositionvoeux(String ine, generated.Voeu voeu)
        throws generated.DonneesInvalides;

    /**
     * Operation getFicheEtudiant
     */
    public generated.Etudiant getFicheEtudiant(String ine)
        throws generated.DonneesInvalides;

    /**
     * Operation estEtudiant
     */
    public boolean estEtudiant(String ine);

    /**
     * Operation deliberationJury
     */
    public void deliberationJury();

    /**
     * Operation deliberationFinal
     */
    public void deliberationFinal();

}
