package PostLicence;

/**
 * Interface definition : IEtudiant
 * 
 * @author OpenORB Compiler
 */
public interface IEtudiantOperations
{
    /**
     * Operation notifier
     */
    public void notifier(String message);

    /**
     * Operation majEtatVoeux
     */
    public void majEtatVoeux(PostLicence.Voeu[] listeVoeux);

}
