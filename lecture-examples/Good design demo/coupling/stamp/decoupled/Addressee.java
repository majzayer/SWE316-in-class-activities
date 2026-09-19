/*
 * Stamp (de-)coupling example
 * Emailer depends only on the data it needs from an addressee.
 */
public interface Addressee {
    String getName();

    String getEmail();
}
