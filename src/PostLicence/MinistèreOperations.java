package PostLicence;

/**
 * Interface definition : Ministère
 * 
 * @author OpenORB Compiler
 */
public interface MinistèreOperations
{
    /**
     * Operation madDesFormationsFrance
     */
    public PostLicence.Formation[] madDesFormationsFrance();

    /**
     * Operation depotDesFormationsRectorat
     */
    public void depotDesFormationsRectorat(PostLicence.Formation[] ListeFormation);

    /**
     * Operation inscriptionRectorat
     */
    public void inscriptionRectorat(String nomRectorat, PostLicence.Rectorat iorRectorat)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation recupererRectorat
     */
    public PostLicence.Rectorat recupererRectorat(String nomRectorat)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation rectoratRattacherUniv
     */
    public PostLicence.Rectorat rectoratRattacherUniv(String nomAcademie)
        throws PostLicence.DonneesInvalides;

    /**
     * Operation deliberationJury
     */
    public void deliberationJury();

}
