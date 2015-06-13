package generated;

/**
 * Interface definition : Minist�re
 * 
 * @author OpenORB Compiler
 */
public interface Minist�reOperations
{
    /**
     * Operation madDesFormationsFrance
     */
    public generated.Formation[] madDesFormationsFrance();

    /**
     * Operation depotDesFormationsRectorat
     */
    public void depotDesFormationsRectorat(generated.Formation Formation);

    /**
     * Operation inscriptionRectorat
     */
    public void inscriptionRectorat(String nomRectorat, generated.Rectorat iorRectorat)
        throws generated.DonneesInvalides;

    /**
     * Operation recupererRectorat
     */
    public generated.Rectorat recupererRectorat(String nomRectorat)
        throws generated.DonneesInvalides;

    /**
     * Operation rectoratRattacherUniv
     */
    public generated.Rectorat rectoratRattacherUniv(String nomAcademie)
        throws generated.DonneesInvalides;

    /**
     * Operation deliberationJury
     */
    public void deliberationJury();

    /**
     * Operation GetRectoratEtudiant
     */
    public generated.Rectorat GetRectoratEtudiant(String ine)
        throws generated.DonneesInvalides;

    /**
     * Operation EnregistrerRectoratEtudiant
     */
    public void EnregistrerRectoratEtudiant(String ine, generated.Rectorat recto);

    /**
     * Operation InscriptionGDVDansRectorats
     */
    public void InscriptionGDVDansRectorats(short num, generated.GestionDesVoeux gdv);

}
