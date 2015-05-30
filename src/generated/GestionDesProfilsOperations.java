package generated;

/**
 * Interface definition : GestionDesProfils
 * 
 * @author OpenORB Compiler
 */
public interface GestionDesProfilsOperations
{
    /**
     * Read accessor for numeroGDP attribute
     * @return the attribute value
     */
    public short numeroGDP();

    /**
     * Operation connexion
     */
    public generated.GestionDesVoeux connexion(generated.IEtudiant iorEtudiant, String ine, String mdp)
        throws generated.DonneesInvalides;

    /**
     * Operation consulterProfil
     */
    public generated.Etudiant consulterProfil(String ine)
        throws generated.DonneesInvalides;

    /**
     * Operation modifierProfil
     */
    public void modifierProfil(String ine, String adr)
        throws generated.DonneesInvalides;

    /**
     * Operation inscriptionGestionDesVoeux
     */
    public void inscriptionGestionDesVoeux(generated.GestionDesVoeux GDesVx);

}
