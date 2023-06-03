//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Eleonora Macchi - 748736 - VA
//Riccardo Maria Rosarin - 749914 -VA

package serverES.database_connector;

/**
 *
 * @author big
 */
class DBConnectionException extends Exception {

    /**
     * Creates a new instance of <code>DBConnectionException</code> without
     * detail message.
     */
    public DBConnectionException() {
    }

    /**
     * Constructs an instance of <code>DBConnectionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DBConnectionException(String msg) {
        super(msg);
    }
}
